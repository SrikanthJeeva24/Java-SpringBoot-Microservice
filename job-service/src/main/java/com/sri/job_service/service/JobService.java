package com.sri.job_service.service;

import com.sri.job_service.dto.JobRequestDTO;
import com.sri.job_service.dto.JobResponseDTO;

import java.util.List;

public interface JobService {
    JobResponseDTO createJob(JobRequestDTO request);

    List<JobResponseDTO> getAllJobs();

    JobResponseDTO getJobById(Long id);

    JobResponseDTO updateJob(Long id, JobRequestDTO request);

    void deleteJob(Long id);

    List<JobResponseDTO> searchJobs(String title);
}
