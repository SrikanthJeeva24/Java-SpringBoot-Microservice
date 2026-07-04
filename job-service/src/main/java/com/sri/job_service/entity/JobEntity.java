package com.sri.job_service.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "jobs")
public class JobEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title Cannot be Empty")
    private String title;

    @NotBlank(message = "Description Cannot be Empty")
    private String description;

    @NotBlank(message = "Location Cannot be Empty")
    private String location;

    @NotNull(message = "Salary Cannot be Empty")
    private Double salary;

    @NotBlank(message = "Company Name Cannot be Empty")
    private String companyName;

    @NotBlank(message = "Skills Required Cannot be Empty")
    private String skillsRequired;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}

