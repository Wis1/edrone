package com.edrone.exercise.service;

import com.edrone.exercise.domain.Job;
import com.edrone.exercise.dto.JobDto;
import com.edrone.exercise.exception.JobNotFoundException;
import com.edrone.exercise.exception.TooMuchStringsException;
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

    private PrintWriter outputFile;


    public void createNewJob(JobDto jobDto) throws FileNotFoundException, TooMuchStringsException {
        if (checkJob(jobDto.getCharacterArray())<jobDto.getAmountStrings())
            throw new TooMuchStringsException();
        else
            findComb(jobDto.getCharacterArray());

    }
//    private void findCombinations(char[] array, StringBuilder candidate, int lengthMin, int lengthMax) {
//        if (candidate.length() == lengthMax)
//            return;
//
//        for (int i = 0; i < array.length; i++) {
//            candidate.append(array[i]);
//          if (candidate.length()<lengthMin)
////                candidate.append(array[i]);
//            System.out.println(candidate);
//            findCombinations(array,candidate,lengthMin, lengthMax);
//            candidate.deleteCharAt(candidate.length()-1);
//        }
//    }
//    public void findCombinations(char[] array,int lengthMin, int lengthMax) {
//        findCombinations(array, new StringBuilder(), lengthMin, lengthMax);
//    }

    public int checkJob(char[] letters){
        int max_length = 3;
        int b = letters.length - 1;
        int n = 0;
        for (int k = 0; k <= max_length; k++)
            n = (n*b)+b;
        return n;
    }
    public void findComb(char[] letters) throws FileNotFoundException {
        int remainder;
        int b = letters.length - 1;

        for (int i = 1; i <= checkJob(letters); i++) {
            int current = i;
            String combination = "";
            do {
                remainder = current % b;
                if (remainder == 0) {
                    combination += letters[b];
                    current = current/b - 1;
                } else {
                    combination += letters[remainder];
                    current = current/b;
                }
            } while (current > 0);
            outputFile= new PrintWriter("Strings");
            outputFile.println(combination);
            System.out.println(combination);
        }
        outputFile.close();
    }

    public String getResultJob(Long id) throws FileNotFoundException, JobNotFoundException {
        Job job=jobRepository.findById(id).orElseThrow(JobNotFoundException::new);
        File myFile= new File("Strings");
        Scanner in= new Scanner(myFile); 
        String all = "";
        int counter=0;
        while(in.hasNext()&&counter<=job.getAmountStrings()) {
            String line= in.nextLine();
            all= all+line+"\n";
            counter +=1;
        }

        return all;

    }
}
