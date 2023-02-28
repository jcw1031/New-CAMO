package com.woopaca.newcamo.controller.dto.cafe;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CafeRegisterRequestDto {

    @NotBlank(message = "카페 이름은 비어있을 수 없습니다.")
    private String cafeName;
    @NotBlank(message = "카페 주소는 비어있을 수 없습니다.")
    private String cafeAddress;
    private String cafePhone;
    private String cafeIntroduction;
}
