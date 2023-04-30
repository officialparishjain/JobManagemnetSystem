package com.parishjain.BuissnessManagement.service;

import com.parishjain.BuissnessManagement.models.Job;
import com.parishjain.BuissnessManagement.repository.JobRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    JobRepository jobRepository;

    public String addJob(List<Job> jobs) {


        // Inbuilt

        Iterable<Job> jobList = jobRepository.saveAll(jobs);
        if(jobList != null ) return "Added";
        else return "Not Added";
    }

    public Job fetchJobById(Integer id) {
        // Optional is a container object that may or may not contain a non-null value.
        // It is a class in the java.util package introduced in Java 8.
        //The main purpose of Optional is to eliminate null checks in your code and provide a
        // more expressive way to handle null values. Instead of returning null, a method that
        // may or may not produce a value can return an Optional instance.
       Optional<Job> optionalJob = jobRepository.findById(id);
       if(optionalJob.isPresent()) return optionalJob.get();
       else throw new RuntimeException("Job with ID " + id + " not found");
    }

    public Iterable<Job> fetchAllJobs() {
        return jobRepository.findAll();
    }

    @Transactional
    public String updateSalaryById(Integer id, Double salary) {
        jobRepository.updateJobSalary(id,salary);
        return "Updated";
    }

    public List<Job> fetchAllJobsByDateGreater(LocalDate date) {
        return jobRepository.findByJobAppliedDateGreaterThan(date);
    }

    public List<Job> fetchJobBySalaryLess(Double salary) {
        return jobRepository.findByJobSalaryLessThan(salary);
    }

    public Long fetchJobsAvailable(){
        return jobRepository.count();
    }

    @Transactional
    public String deleteByEmployerName(String empName) {
        jobRepository.deleteByEmpName(empName);
        return "Deleted";
    }

    public List<Job> fetchBySalaryGreaterAndLocation(Double salary, String location) {
        return jobRepository.findByJobSalaryGreaterThanAndJobLocationEquals(salary,location);
    }
}
