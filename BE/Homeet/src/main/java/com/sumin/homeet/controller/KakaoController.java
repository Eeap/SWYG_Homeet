package com.sumin.homeet.controller;


import com.sumin.homeet.service.KakaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/oauth")
public class KakaoController {
    private final KakaoService kakaoService;
    @GetMapping("/kakao")
    public ResponseEntity<Map<String,String>> kakaoClient(@RequestParam String token) {
        System.out.println("token = " + token);
        HttpHeaders httpHeaders = new HttpHeaders();
//        String accessToken = kakaoService.getKakaoAccessToken(code);
        List<String> data = kakaoService.getKakaoUser(token);

        Map<String,String> msg = new HashMap<>();
        httpHeaders.add("X-AUTH-TOKEN", data.get(0));
        msg.put("token", data.get(0));
        msg.put("userId", data.get(1));
        msg.put("nickname", data.get(2));
        return ResponseEntity.ok().headers(httpHeaders).body(msg);

    }
}
