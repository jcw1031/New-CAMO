package com.woopaca.newcamo.service;

import com.woopaca.newcamo.controller.dto.cafe.CafeRegisterRequestDto;

public interface CafeService {

    Long register(final CafeRegisterRequestDto cafeRegisterRequestDto, final String authorization);
}
