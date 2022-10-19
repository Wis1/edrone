package com.edrone.exercise.service;

import com.edrone.exercise.domain.Job;
import com.edrone.exercise.exception.TooMuchStringsException;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

@Service
public class JobService {

    public void createNewJob(Job job) throws FileNotFoundException {
        if (checkJob(job.getCharacterArray())<job.getAmountStrings())
            new TooMuchStringsException();
        else
            findComb(job.getCharacterArray());

    }
    private void findCombinations(char[] array, StringBuilder candidate, int lengthMin, int lengthMax) {
        if (candidate.length() == lengthMax)
            return;

        for (int i = 0; i < array.length; i++) {
            candidate.append(array[i]);
//            if (candidate.length()<lengthMin)
//                candidate.append(array[i]);
            System.out.println(candidate);
            findCombinations(array,candidate,lengthMin, lengthMax);
            candidate.deleteCharAt(candidate.length()-1);
        }
    }
    public void findCombinations(char[] array,int lengthMin, int lengthMax) {
        findCombinations(array, new StringBuilder(), lengthMin, lengthMax);
    }

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
        PrintWriter outputFile= new PrintWriter("Strings");
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
            outputFile.println(combination);
            System.out.println(combination);
        }
        outputFile.close();
    }
}
