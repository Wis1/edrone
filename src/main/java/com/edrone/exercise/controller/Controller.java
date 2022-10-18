package com.edrone.exercise.controller;

import com.edrone.exercise.domain.Job;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/strings")
@RequiredArgsConstructor
public class Controller {

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createNewJob(@RequestBody Job job){

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
