package com.parishjain.BuissnessManagement.controller;

import com.parishjain.BuissnessManagement.models.Job;
import com.parishjain.BuissnessManagement.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/job")
public class JobController {

    @Autowired
    JobService jobService;
    // Add Job
    @PostMapping(value = "/add")
    public String addJob(@RequestBody List<Job> jobs){
       return jobService.addJob(jobs);
    }

    @GetMapping(value = "/id/{id}")
    public Job findJobById(@PathVariable Integer id){
        return jobService.fetchJobById(id);
    }

    @GetMapping(value = "/salary/less/{salary}")
    public List<Job> findJobBySalaryLess(@PathVariable Double salary){
        return jobService.fetchJobBySalaryLess(salary);
    }

    @GetMapping(value = "/count")
    public Long findJobCount(){
        return jobService.fetchJobsAvailable();
    }
    @GetMapping(value = "/getAll")
    public Iterable<Job> getAllJobs(){
            return jobService.fetchAllJobs();
        }

    @GetMapping(value = "/byDate/{date}")
    public List<Job> getAllJobByDateGreater(@PathVariable LocalDate date){
        return jobService.fetchAllJobsByDateGreater(date);
    }

    // Update Job
    @PutMapping(value = "/update/salary/{salary}/id/{id}")
    public String updateJobSalaryById(@PathVariable Integer id,@PathVariable Double salary){
        return jobService.updateSalaryById(id,salary);
    }


    // Delete Job
    @DeleteMapping(value = "/delete/employer/{empName}")
    public String deleteByEmployerName(@PathVariable String empName){
        return jobService.deleteByEmployerName(empName);
    }

    @GetMapping(value = "/salary/greater/{salary}/location/{location}")
    public List<Job> getBySalaryGreaterAndLocation(@PathVariable Double salary, @PathVariable String location){
        return jobService.fetchBySalaryGreaterAndLocation(salary,location);
    }


}
