package com.edrone.exercise.service;

import com.edrone.exercise.domain.Job;
import com.edrone.exercise.dto.JobDto;
import com.edrone.exercise.exception.JobNotFoundException;
import com.edrone.exercise.exception.TooMuchStringsException;
import com.edrone.exercise.mapper.JobMapper;
import com.edrone.exercise.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class JobService {

    private final JobRepository jobRepository;
    private final JobMapper jobMapper;

    private PrintWriter outputFile;
    private String combination="";


    public void createNewJob(JobDto jobDto) throws FileNotFoundException, TooMuchStringsException {
        if (checkPossibleNumberOfCombinations(jobDto.getCharacterArray(), jobDto.getLengthMax())<jobDto.getAmountStrings())
            throw new TooMuchStringsException();
        else {
            jobRepository.save(jobMapper.mapToJob(jobDto));
            findCombinations(jobDto.getCharacterArray(), jobDto.getLengthMin(), jobDto.getLengthMax());
        }
    }
    private void findCombinations(char[] array, StringBuilder candidate, int lengthMin, int lengthMax) throws FileNotFoundException {

        if (candidate.length() == lengthMax){
            outputFile.println(combination);
            outputFile.close();
            return;
        }
        else {
            outputFile = new PrintWriter("Strings");

            for (int i = 0; i < array.length; i++) {
                candidate.append(array[i]);
                combination = combination + candidate+"\n";
                findCombinations(array, candidate, lengthMin, lengthMax);
                candidate.deleteCharAt(candidate.length() - 1);
            }
        }
    }
    public void findCombinations(char[] array,int lengthMin, int lengthMax) throws FileNotFoundException {
        findCombinations(array, new StringBuilder(), lengthMin, lengthMax);
    }

    public int checkPossibleNumberOfCombinations(char[] letters, int maxLength){
        int b = letters.length - 1;
        int n = 0;
        for (int k = 0; k <= maxLength; k++)
            n = (n*b)+b;
        return n;
    }

    public Job getJobById(Long id) throws JobNotFoundException{

        return jobRepository.findById(id).orElseThrow(JobNotFoundException::new);

    }

    public String getResultJob(Long id) throws FileNotFoundException, JobNotFoundException {
        Job job=jobRepository.findById(id).orElseThrow(JobNotFoundException::new);
        File myFile= new File("Strings");
        Scanner in= new Scanner(myFile);
        StringBuilder all = new StringBuilder();
        int counter=0;
        while(in.hasNext()&&counter<=job.getAmountStrings()) {
            String line= in.nextLine();
            all.append(line).append("\n");
            counter +=1;
        }
        in.close();

        return all.toString();

    }
}
