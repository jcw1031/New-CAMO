package com.woopaca.newcamo.controller;

import com.woopaca.newcamo.controller.dto.cafe.CafeRegisterRequestDto;
import com.woopaca.newcamo.service.CafeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/v1/cafes")
@RequiredArgsConstructor
public class CafeController {

    private final CafeService cafeService;

    @PostMapping("")
    public ResponseEntity<String> cafeRegister(
            @RequestBody @Valid final CafeRegisterRequestDto cafeRegisterRequestDto,
            @RequestHeader("Authorization") final String authorization) {
        Long cafeId = cafeService.register(cafeRegisterRequestDto, authorization);
        return ResponseEntity.created(URI.create("/api/v1/cafes/" + cafeId))
                .body("카페 등록 완료");
    }
}
