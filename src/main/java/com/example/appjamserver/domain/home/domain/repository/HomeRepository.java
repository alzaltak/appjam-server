package com.example.appjamserver.domain.home.domain.repository;

import com.example.appjamserver.domain.home.domain.Home;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HomeRepository extends CrudRepository<Home, Long> {

    @Query("select h from Home h where h.address like %:address")
    List<Home> queryByAddress(String address);

}
