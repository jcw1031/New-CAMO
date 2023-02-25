package com.woopaca.newcamo.service;

import com.woopaca.newcamo.controller.dto.SignInRequestDto;
import com.woopaca.newcamo.controller.dto.SignUpRequestDto;
import com.woopaca.newcamo.controller.dto.ValidateDuplicateEmailDto;

public interface UserService {

    void validateDuplicateEmail(final ValidateDuplicateEmailDto validateDuplicateEmailDto);

    Long signUp(final SignUpRequestDto signUpRequestDto);

    String signIn(final SignInRequestDto signInRequestDto);
}
