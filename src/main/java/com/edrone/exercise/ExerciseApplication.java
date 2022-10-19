package com.edrone.exercise;

import com.edrone.exercise.service.JobService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;

@SpringBootApplication
public class ExerciseApplication {

	public static void main(String[] args) throws FileNotFoundException {

////		char[] arr = "abcde".toCharArray();
//		char [] letters = new char [] {'0','a','b','c'};
//		JobService jobService= new JobService();
//		jobService.findComb(letters);
//		System.out.println(jobService.checkJob(letters));
//		jobService.findCombinations(arr, 2, 3);
		SpringApplication.run(ExerciseApplication.class, args);
	}

}
