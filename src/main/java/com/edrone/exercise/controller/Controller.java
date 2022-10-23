package com.edrone.exercise.controller;

import com.edrone.exercise.domain.Job;
import com.edrone.exercise.dto.JobDto;
import com.edrone.exercise.exception.JobNotFoundException;
import com.edrone.exercise.exception.TooMuchStringsException;
import com.edrone.exercise.mapper.JobMapper;
import com.edrone.exercise.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;

@RestController
@RequestMapping("/v1/strings")
@RequiredArgsConstructor
public class Controller {

    private final JobService jobService;
    private final JobMapper jobMapper;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createNewJob(@RequestBody JobDto jobDto) throws FileNotFoundException, TooMuchStringsException {

        jobService.createNewJob(jobDto);
        return ResponseEntity.ok().build();

    }

    @GetMapping
    public int getHowManyJobsRunning(){
        return 0;
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<String> getResultJob(@PathVariable Long id) throws FileNotFoundException, JobNotFoundException {
        JobDto jobDto= jobMapper.mapToJobDto(jobService.getJobById(id));
        return ResponseEntity.ok(jobService.getResultJob(id));
    }
}
