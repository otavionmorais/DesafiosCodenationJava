package com.challenge.endpoints;

import com.challenge.entity.Company;
import com.challenge.service.impl.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public List<Company> findAll(){
        return this.companyService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Company> findById(@PathVariable Long id){
        return this.companyService.findById(id);
    }

    @GetMapping(params = {"accelerationId"})
    public List<Company> findByAccelerationId(@RequestParam Long accelerationId){
        return this.companyService.findByAccelerationId(accelerationId);
    }

    @GetMapping(params = {"userId"})
    public List<Company> findByUserId(@RequestParam Long userId){
        return this.companyService.findByUserId(userId);
    }

    @PostMapping
    public Company save(@RequestBody Company company){
        return this.companyService.save(company);
    }
}
