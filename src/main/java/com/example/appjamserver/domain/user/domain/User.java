package com.example.appjamserver.domain.user.domain;

import com.example.appjamserver.domain.home.domain.Home;
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

    @Column(nullable = false)
    private Integer believe; // 신뢰도

    @Column(nullable = false)
    private Integer reviewers;

    @OneToOne(mappedBy = "user")
    private Home home;

    public void setBelieve(Integer believe) {
        this.believe = believe;
    }

    public void addReviewers() {
        this.reviewers += 1;
    }

    public String getLocation() {
        return this.home.getLocation();
    }

}
