package com.edrone.exercise.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Job {

    private Long id;
    private int lengthMin;
    private int lengthMax;
    private char[] characterArray;
    private int amountStrings;
}
