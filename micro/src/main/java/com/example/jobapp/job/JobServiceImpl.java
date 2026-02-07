package com.example.jobapp.job;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class JobServiceImpl implements JobService{

    private List<Job> jobs = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        job.setId(nextId++);
       jobs.add(job);
    }

    @Override
    public Job getJobById(Long id) {
        for(Job job :jobs){
            if(job.getId().equals(id)){
                return job;
            }
        }
        return null;
    }

    @Override
    public boolean deleteJobById(Long id) {
//        for (Job job : jobs){
//            if(job.getId().equals(id)){
//                jobs.remove(job);
//                return true;
//            }
//        }
//        return false;
        Iterator<Job> iterator = jobs.iterator();
        while(iterator.hasNext()){
            Job job = iterator.next();
            if(job.getId().equals(id)){
                iterator.remove();
                return  true;
            }
        }
        return false;
    }

    @Override
    public boolean updatejobById(Long id, Job updatedJob) {
        for(Job job :jobs){
            if(job.getId().equals(id)){
                job.setDescription(updatedJob.getDescription());
                job.setLocation(updatedJob.getLocation());
                job.setTitle(updatedJob.getTitle());
                job.setMaxSalary(updatedJob.getMaxSalary());
                job.setMinSalary(updatedJob.getMinSalary());
                return true;
            }
        }
        return false;
    }


}
