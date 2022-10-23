package com.edrone.exercise.mapper;

import com.edrone.exercise.domain.Job;
import com.edrone.exercise.dto.JobDto;
import org.springframework.stereotype.Service;

@Service
public class JobMapper {


    public Job mapToJob(JobDto jobDto){
        return new Job(
                jobDto.getId(),
                jobDto.getLengthMin(),
                jobDto.getLengthMax(),
                jobDto.getCharacterArray(),
                jobDto.getAmountStrings()
        );
    }
    public JobDto mapToJobDto(Job job) {

        return new JobDto(
                job.getId(),
                job.getLengthMin(),
                job.getLengthMax(),
                job.getCharacterArray(),
                job.getAmountStrings()
        );
    }
}
