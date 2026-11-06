package com.klef.soa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klef.soa.entity.Result;

public interface ResultRepository extends JpaRepository<Result, Long>
{
    List<Result> findByName(String name);

    List<Result> findByGender(String gender);
}