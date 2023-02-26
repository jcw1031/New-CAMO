package com.woopaca.newcamo.controller.dto.cafe;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CafeRegisterRequestDto {

    private String cafeName;
    private String cafeAddress;
    private String cafePhone;
    private String cafeIntroduction;
}
