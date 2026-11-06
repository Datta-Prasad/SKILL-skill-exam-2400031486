package com.klef.soa.service;

import java.util.List;

import com.klef.soa.entity.Result;

public interface ResultService
{
    public String addResult(Result result);

    public List<Result> viewAllResults();

    public Result viewResultById(Long id);

    public String updateResult(Result result);

    public String deleteResult(Long id);

    public List<Result> findByName(String name);

    public List<Result> findByGender(String gender);
}