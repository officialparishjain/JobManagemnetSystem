package com.parishjain.BuissnessManagement.repository;

import com.parishjain.BuissnessManagement.models.Job;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface JobRepository extends CrudRepository<Job,Integer> {


    // CUSTOM FINDER
    public List<Job> findByJobAppliedDateGreaterThan(LocalDate localDate);

    public List<Job> findByJobSalaryLessThan(Double salary);

    public List<Job> findByJobSalaryGreaterThanAndJobLocationEquals(Double salary, String location);

    // CUSTOM QUERY

    @Modifying
    @Query(value = "update job set JOB_SALARY= :salary where JOB_ID=:id ",nativeQuery = true)
    public void updateJobSalary(Integer id,Double salary);

    @Modifying
    @Query(value = "delete from job where JOB_EMPLOYER_NAME=:empName",nativeQuery = true)
    public void deleteByEmpName(String empName);
}
