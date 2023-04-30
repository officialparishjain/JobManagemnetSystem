package com.parishjain.BuissnessManagement.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long jobId;
    private String jobTitle;
    @Size(min = 25)
    private String jobDescription;
    private String jobLocation;
    private Double jobSalary;
    @NotNull(message = "Cannot be null...")
    private String jobCompanyName;
    @NotNull(message = "Cannot be null...")
    private String jobEmployerName;

    @Enumerated(EnumType.STRING)
    private JobType.Type jobType;
    private LocalDate jobAppliedDate;
}
