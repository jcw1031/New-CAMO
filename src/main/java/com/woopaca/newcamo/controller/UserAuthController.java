package com.woopaca.newcamo.controller;

import com.woopaca.newcamo.controller.dto.SignInRequestDto;
import com.woopaca.newcamo.controller.dto.SignUpRequestDto;
import com.woopaca.newcamo.controller.dto.ValidateDuplicateEmailDto;
import com.woopaca.newcamo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserAuthController {

    private final UserService userService;

    @PostMapping("/validate-email")
    public ResponseEntity<String> validateDuplicateEmail(
            @RequestBody @Valid final ValidateDuplicateEmailDto validateDuplicateEmailDto
    ) {
        userService.validateDuplicateEmail(validateDuplicateEmailDto);
        return ResponseEntity.ok().body("사용 가능한 이메일입니다.");
    }

    @PostMapping("/sign-up")
    public ResponseEntity<String> userSignUp(
            @RequestBody @Valid final SignUpRequestDto signUpRequestDto) {
        Long signUpUserId = userService.signUp(signUpRequestDto);
        return ResponseEntity.created(URI.create("/api/v1/users/" + signUpUserId))
                .body("회원가입이 완료되었습니다.");
    }

    @PostMapping("/sign-in")
    public ResponseEntity<String> userSignIn(
            @RequestBody @Valid final SignInRequestDto signInRequestDto) {
        String token = userService.signIn(signInRequestDto);
        return ResponseEntity.ok().body(token);
    }
}
