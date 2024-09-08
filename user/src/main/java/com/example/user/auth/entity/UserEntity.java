package com.example.user.auth.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "member")
@Getter
@Builder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_seq")
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "hashed_pass")
    private String password;
    @Column(name = "role")
    private String role;

}
