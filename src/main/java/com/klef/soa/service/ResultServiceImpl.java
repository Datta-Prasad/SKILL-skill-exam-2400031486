package com.klef.soa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.klef.soa.entity.Result;
import com.klef.soa.repository.ResultRepository;

@Service
public class ResultServiceImpl implements ResultService {
    private final ResultRepository resultRepository;

    public ResultServiceImpl(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    @Override
    public String addResult(Result result)
    {
        resultRepository.save(result);
        return "Result Added Successfully";
    }

    @Override
    public List<Result> viewAllResults()
    {
        return resultRepository.findAll();
    }

    @Override
    public Result viewResultById(Long id)
    {
        Optional<Result> optional = resultRepository.findById(id);

        if(optional.isPresent())
        {
            return optional.get();
        }

        return null;
    }

    @Override
    public String updateResult(Result result)
    {
        Optional<Result> optional = resultRepository.findById(result.getResultId());

        if(optional.isPresent())
        {
            Result r = optional.get();

            r.setName(result.getName());
            r.setGender(result.getGender());
            r.setEmail(result.getEmail());
            r.setLocation(result.getLocation());

            resultRepository.save(r);

            return "Result Updated Successfully";
        }

        return "Result Not Found";
    }

    @Override
    public String deleteResult(Long id)
    {
        Optional<Result> optional = resultRepository.findById(id);

        if(optional.isPresent())
        {
            resultRepository.deleteById(id);
            return "Result Deleted Successfully";
        }

        return "Result Not Found";
    }

    @Override
    public List<Result> findByName(String name)
    {
        return resultRepository.findByName(name);
    }

    @Override
    public List<Result> findByGender(String gender)
    {
        return resultRepository.findByGender(gender);
    }
}