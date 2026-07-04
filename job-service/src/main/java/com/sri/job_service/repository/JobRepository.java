package com.sri.job_service.repository;

import com.sri.job_service.entity.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface JobRepository  extends JpaRepository<JobEntity, Long> {

    boolean existsByTitleAndCompanyNameAndLocation(String title, String companyName, String Location);

    List<JobEntity>
    findByTitleContainingIgnoreCase(
            String title);
}
