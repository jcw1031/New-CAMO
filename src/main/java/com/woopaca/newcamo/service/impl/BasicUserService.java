package com.woopaca.newcamo.service.impl;

import com.woopaca.newcamo.config.jwt.JwtProvider;
import com.woopaca.newcamo.controller.dto.SignInRequestDto;
import com.woopaca.newcamo.controller.dto.SignUpRequestDto;
import com.woopaca.newcamo.controller.dto.ValidateDuplicateEmailDto;
import com.woopaca.newcamo.entity.User;
import com.woopaca.newcamo.exception.user.DuplicateEmailException;
import com.woopaca.newcamo.exception.user.InvalidCheckPassword;
import com.woopaca.newcamo.exception.user.InvalidSignInUser;
import com.woopaca.newcamo.exception.user.NotValidateDuplicateEmail;
import com.woopaca.newcamo.repository.UserRepository;
import com.woopaca.newcamo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BasicUserService implements UserService {

    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;

    @Override
    public void validateDuplicateEmail(final ValidateDuplicateEmailDto validateDuplicateEmailDto) {
        if (userRepository.existsByEmail(validateDuplicateEmailDto.getEmail())) {
            throw new DuplicateEmailException();
        }
    }

    @Override
    public Long signUp(final SignUpRequestDto signUpRequestDto) {
        User user = validateSignUpUser(signUpRequestDto);
        User savedUser = userRepository.save(user);
        return savedUser.getId();
    }

    private User validateSignUpUser(final SignUpRequestDto signUpRequestDto) {
        Boolean isExists = userRepository.existsByEmail(signUpRequestDto.getEmail());
        if (isExists) {
            throw new NotValidateDuplicateEmail();
        }

        String password = signUpRequestDto.getPassword();
        String checkPassword = signUpRequestDto.getCheckPassword();
        if (!password.equals(checkPassword)) {
            throw new InvalidCheckPassword();
        }

        return User.from(signUpRequestDto);
    }

    @Override
    public String signIn(final SignInRequestDto signInRequestDto) {
        User user = validateSignInUser(signInRequestDto);
        return jwtProvider.createToken(user.getId(), user.getEmail(),
                user.getRoles(), 5);
    }

    private User validateSignInUser(final SignInRequestDto signInRequestDto) {
        String email = signInRequestDto.getEmail();
        String password = signInRequestDto.getPassword();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new InvalidSignInUser());

        if (!BCrypt.checkpw(password, user.getPassword())) {
            throw new InvalidSignInUser();
        }
        return user;
    }

}
