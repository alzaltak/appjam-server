package com.example.appjamserver.domain.user.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String accountId;

    @Column(nullable = false)
    private String email;

    @Column(length = 60)
    private String password;

    @Column(nullable = false)
    private String lastName; // 성

    @Column(nullable = false)
    private String firstName; // 이름

    @Column(nullable = false)
    private String profileImageUrl;

    @Column(nullable = false)
    private String myLang;


}
