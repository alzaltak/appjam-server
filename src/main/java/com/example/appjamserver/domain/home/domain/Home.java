package com.example.appjamserver.domain.home.domain;

import com.example.appjamserver.domain.user.domain.User;
import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
public class Home {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String homeInfo; // 집 유형

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private Integer roomCounts; // 방 개수

    @Column(nullable = false)
    private Integer homeSize; // 평수

    @Column(nullable = false)
    private Integer maxPeopleSize; // 최대 인원 수

    @Column(nullable = false)
    private String homeImageUrl;

    @Column(nullable = false)
    private String homeCategory; // 몇 인실인지

    @Column(nullable = false)
    private String culture; // 지역 문화

    @Column(nullable = false)
    private String item; // 지원 가능한 물품

    @Column(nullable = false)
    private String share; // 추천인

    @Column(nullable = false)
    private String title; // 제목

    @Column(nullable = false)
    private String content; // 내용글

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
