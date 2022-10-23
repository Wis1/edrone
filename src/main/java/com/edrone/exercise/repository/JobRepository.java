package com.edrone.exercise.repository;

import com.edrone.exercise.domain.Job;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface JobRepository extends JpaRepository<Job, Long> {

    @Override
    Optional<Job> findById(Long id);
}
