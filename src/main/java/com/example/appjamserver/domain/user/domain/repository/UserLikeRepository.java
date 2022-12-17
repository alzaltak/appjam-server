package com.example.appjamserver.domain.user.domain.repository;

import com.example.appjamserver.domain.home.domain.Home;
import com.example.appjamserver.domain.user.domain.User;
import com.example.appjamserver.domain.user.domain.UserLike;
import org.springframework.data.repository.CrudRepository;

public interface UserLikeRepository extends CrudRepository<UserLike, Long> {

    boolean existsByUserAndHome(User user, Home home);

    void deleteByUserAndHome(User user, Home home);

}
