package com.woopaca.newcamo.service.impl;

import com.woopaca.newcamo.controller.dto.cafe.CafeRegisterRequestDto;
import com.woopaca.newcamo.repository.CafeRepository;
import com.woopaca.newcamo.service.CafeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BasicCafeService implements CafeService {

    private final CafeRepository cafeRepository;

    @Override
    public void register(final CafeRegisterRequestDto cafeRegisterRequestDto) {
    }
}
