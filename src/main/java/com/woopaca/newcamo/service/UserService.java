package com.woopaca.newcamo.service;

import com.woopaca.newcamo.controller.dto.user.SignInRequestDto;
import com.woopaca.newcamo.controller.dto.user.SignUpRequestDto;
import com.woopaca.newcamo.controller.dto.user.ValidateDuplicateEmailDto;

public interface UserService {

    void validateDuplicateEmail(final ValidateDuplicateEmailDto validateDuplicateEmailDto);

    Long signUp(final SignUpRequestDto signUpRequestDto);

    String signIn(final SignInRequestDto signInRequestDto);
}
