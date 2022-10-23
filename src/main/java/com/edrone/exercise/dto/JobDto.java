package com.edrone.exercise.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class JobDto {

    private Long id;
    private int lengthMin;
    private int lengthMax;
    private char[] characterArray;
    private int amountStrings;
}
