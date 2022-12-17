package com.example.appjamserver.domain.user.domain.repository;

import com.example.appjamserver.domain.user.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByAccountId(String accountId);

    @Query("select u from User u where u.home.address like %:address")
    List<User> queryByAddRess(String address);

}
