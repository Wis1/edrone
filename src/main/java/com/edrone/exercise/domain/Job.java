package com.edrone.exercise.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Job {

    private Long id;
    private int lengthMin;
    private int lengthMax;
    private List<Character> characterList;
    private int amountStrings;
}
