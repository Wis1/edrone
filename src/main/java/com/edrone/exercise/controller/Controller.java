package com.edrone.exercise.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/strings")
@RequiredArgsConstructor
public class Controller {

    @PostMapping
    public void createNewJob(){

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
