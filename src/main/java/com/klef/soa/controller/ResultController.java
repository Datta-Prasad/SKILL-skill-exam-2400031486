package com.klef.soa.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klef.soa.entity.Result;
import com.klef.soa.service.ResultService;

@RestController
@RequestMapping("/result")
public class ResultController {
    private final ResultService resultService;

    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addResult(@RequestBody Result result)
    {
        String message = resultService.addResult(result);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @GetMapping("/viewall")
    public ResponseEntity<List<Result>> viewAllResults()
    {
        List<Result> resultList = resultService.viewAllResults();
        return new ResponseEntity<>(resultList, HttpStatus.OK);
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<?> viewResultById(@PathVariable Long id)
    {
        Result result = resultService.viewResultById(id);

        if(result != null)
        {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }

        return new ResponseEntity<>("Result Not Found", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateResult(@RequestBody Result result)
    {
        String message = resultService.updateResult(result);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteResult(@PathVariable Long id)
    {
        String message = resultService.deleteResult(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("/findbyname/{name}")
    public ResponseEntity<List<Result>> findByName(@PathVariable String name)
    {
        List<Result> list = resultService.findByName(name);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/findbygender/{gender}")
    public ResponseEntity<List<Result>> findByGender(@PathVariable String gender)
    {
        List<Result> list = resultService.findByGender(gender);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}