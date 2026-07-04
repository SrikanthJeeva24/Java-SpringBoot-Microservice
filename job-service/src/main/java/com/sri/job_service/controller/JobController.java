package com.sri.job_service.controller;

import com.sri.job_service.dto.JobRequestDTO;
import com.sri.job_service.dto.JobResponseDTO;
import com.sri.job_service.service.JobService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/search")
    public ResponseEntity<List<JobResponseDTO>> searchJobs(@RequestParam String title) {
        return ResponseEntity.ok(jobService.searchJobs(title));
    }

    @GetMapping
    public ResponseEntity<List<JobResponseDTO>> getAllJobs() {
        return ResponseEntity.ok(jobService.getAllJobs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobResponseDTO> getJobById(@PathVariable Long id) {
        return ResponseEntity.ok(jobService.getJobById(id));
    }

    @PostMapping
    public ResponseEntity<JobResponseDTO> createJob(@Valid @RequestBody JobRequestDTO req) {
        JobResponseDTO res = jobService.createJob(req);

        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobResponseDTO> updateJob(@PathVariable Long id, @Valid @RequestBody JobRequestDTO req) {
        return ResponseEntity.ok(jobService.updateJob(id, req));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable Long id) {

        jobService.deleteJob(id);

        return ResponseEntity.noContent().build();
    }
}

