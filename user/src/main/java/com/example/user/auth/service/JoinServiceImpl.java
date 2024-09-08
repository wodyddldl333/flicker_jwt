package com.example.user.auth.service;

import com.example.user.auth.dto.JoinDto;
import com.example.user.auth.entity.UserEntity;
import com.example.user.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class JoinServiceImpl implements JoinService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void joinProcess(JoinDto joinDto) {

        String username = joinDto.getUsername();
        String password = joinDto.getPassword();

        Boolean isExist = userRepository.existsByUsername(username);

        if (isExist) {
            // TODO : 예외처리!!
            throw new RuntimeException("이미 존재하는 아이디");
        };

        UserEntity user1 = UserEntity.builder()
                .username(username)
                .password(bCryptPasswordEncoder.encode(password))
                .role("ROLE_ADMIN")
                .build();

        userRepository.save(user1);
    }
}
