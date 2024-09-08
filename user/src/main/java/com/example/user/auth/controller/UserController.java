package com.example.user.auth.controller;

import com.example.user.auth.dto.JoinDto;
import com.example.user.auth.service.JoinService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final JoinService joinService;

    @PostMapping("/user/api/join")
    public ResponseEntity<?> join(@RequestBody JoinDto joinDto) {

        joinService.joinProcess(joinDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/user/api/test")
    public void test(HttpServletRequest request) {

        String username = request.getHeader("X-auth-username");
        System.out.println(username);
    }
}
