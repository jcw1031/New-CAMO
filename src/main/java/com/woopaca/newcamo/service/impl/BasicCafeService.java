package com.woopaca.newcamo.service.impl;

import com.woopaca.newcamo.config.jwt.JwtUtils;
import com.woopaca.newcamo.controller.dto.cafe.CafeRegisterRequestDto;
import com.woopaca.newcamo.entity.User;
import com.woopaca.newcamo.entity.cafe.Cafe;
import com.woopaca.newcamo.exception.cafe.DuplicateCafeException;
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
    private final JwtUtils jwtUtils;

    @Override
    @Transactional
    public Long register(final CafeRegisterRequestDto cafeRegisterRequestDto, final String authorization) {
        validateDuplicateCafe(cafeRegisterRequestDto);
        Cafe cafe = Cafe.from(cafeRegisterRequestDto);

        String token = jwtUtils.resolveToken(authorization);
        User user = jwtUtils.getUserOfToken(token);
        cafe.setOwner(user);
        user.addUserRoleOwner();
        cafeRepository.save(cafe);
        return cafe.getId();
    }

    private void validateDuplicateCafe(final CafeRegisterRequestDto cafeRegisterRequestDto) {
        String cafeName = cafeRegisterRequestDto.getCafeName();
        cafeRepository.findByCafeName(cafeName).ifPresent(cafe -> {
            if (cafe.getCafeAddress().equals(cafeRegisterRequestDto.getCafeAddress())) {
                throw new DuplicateCafeException();
            }
        });
    }
}
