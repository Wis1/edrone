package com.edrone.exercise.controller;

import com.edrone.exercise.dto.JobDto;
import com.edrone.exercise.exception.JobNotFoundException;
import com.edrone.exercise.exception.TooMuchStringsException;
import com.edrone.exercise.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;

@RestController
@RequestMapping("/v1/strings")
@RequiredArgsConstructor
public class Controller {

    private final JobService jobService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createNewJob(@RequestBody JobDto jobDto) throws FileNotFoundException, TooMuchStringsException {

        jobService.createNewJob(jobDto);

    }

    @GetMapping
    public int getHowManyJobsRunning(){
        return 0;
    }


    @GetMapping(value = "{id}")
    public String getResultJob(@PathVariable Long id) throws FileNotFoundException, JobNotFoundException {

        return jobService.getResultJob(id);
    }
}
