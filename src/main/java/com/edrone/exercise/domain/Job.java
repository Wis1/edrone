package com.edrone.exercise.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Job {

    @Id
    private Long id;

    @Column
    private int lengthMin;

    @Column
    private int lengthMax;

    @Column
    private char[] characterArray;

    @Column
    private int amountStrings;
}
