package com.woopaca.newcamo.controller.dto.user;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SignUpRequestDto {

    @Email(message = "이메일 형식이 올바르지 않습니다.")
    @NotBlank(message = "이메일은 비어있을 수 없습니다.")
    private String email;
    @NotBlank(message = "비밀번호는 비어있을 수 없습니다.")
    @Size(min = 4, max = 20, message = "비밀번호는 4자 이상, 20자 이하여야 합니다.")
    private String password;
    @NotBlank(message = "비밀번호 확인은 비어있을 수 없습니다.")
    private String checkPassword;
    @NotBlank(message = "이름은 비어있을 수 없습니다.")
    @Size(min = 2, max = 10, message = "이름은 2자 이상, 10자 이하여야 합니다.")
    private String name;
    @NotBlank(message = "전화번호는 비어있을 수 없습니다.")
    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$",
            message = "연락처는 '000-0000-0000' 형식으로 입력해야 합니다.")
    private String phone;
}
