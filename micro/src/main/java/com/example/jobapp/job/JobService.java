package com.example.jobapp.job;

import java.util.List;

public interface JobService {
    List<Job> findAll();

     void createJob(Job job);


    Job getJobById(Long id);

   boolean deleteJobById(Long id);

    boolean updatejobById(Long id, Job updatedJob);
}
