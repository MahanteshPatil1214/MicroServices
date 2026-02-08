package com.example.jobapp.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping
    public ResponseEntity<List<Company> >getAllCompanies(){
        return new ResponseEntity<>(companyService.getAllCompanies(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createCompany(@RequestBody Company company ){
        companyService.createCompany(company);
        return new ResponseEntity<>("Company added Successfully",HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id,
                                                @RequestBody Company company){
        companyService.updateCompany(id,company);
        return new ResponseEntity<>("Company Updated Successfully",HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompanyById(@PathVariable Long id){
        boolean deleted = companyService.deleteCompanyById(id);
        if(deleted)
            return new ResponseEntity<>("Company deleted Successfully",HttpStatus.OK);
        else
             return new ResponseEntity<>("Company Not Found",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id){
        Company company = companyService.getCompanyById(id);
        if(company != null ) {
            return new ResponseEntity<>(company, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
