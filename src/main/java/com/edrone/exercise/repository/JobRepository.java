package com.edrone.exercise.repository;

import com.edrone.exercise.domain.Job;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {


}
