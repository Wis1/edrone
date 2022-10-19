package com.edrone.exercise.controller;

import com.edrone.exercise.domain.Job;
import com.edrone.exercise.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;

@RestController
@RequestMapping("v1/strings")
@RequiredArgsConstructor
public class Controller {

    private JobService jobService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createNewJob(@RequestBody Job job) throws FileNotFoundException {

        jobService.createNewJob(job);

    }

    @GetMapping
    public int getHowManyJobsRunning(){
        return 0;
    }


    @GetMapping
    public String getResultJob(){

        return null;
    }
}
