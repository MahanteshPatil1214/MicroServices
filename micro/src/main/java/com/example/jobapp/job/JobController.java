package com.example.jobapp.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping
    public ResponseEntity<List<Job>> findAll(){
        return ResponseEntity.ok(jobService.findAll());
    }

    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job){
        jobService.createJob(job);
        return  new ResponseEntity<>("Job Added Successfully",HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){
        Job job = jobService.getJobById(id);
        if(job != null)
            return new ResponseEntity<>(job, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id){
        boolean deleted = jobService.deleteJobById(id);

        if(deleted)
            return new ResponseEntity<>("Job Deleted Successfully", HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateJobById(@PathVariable Long id,
                                                @RequestBody Job updatedJob){
        boolean updated = jobService.updatejobById(id,updatedJob);
        if(updated)
            return new ResponseEntity<>("Job Updated Successfully", HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
