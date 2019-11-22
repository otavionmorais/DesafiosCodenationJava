package com.challenge.endpoints;

import com.challenge.entity.Acceleration;
import com.challenge.service.impl.AccelerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/acceleration")
public class AccelerationController {

    private final AccelerationService accelerationService;

    @Autowired
    public AccelerationController(AccelerationService accelerationService) {
        this.accelerationService = accelerationService;
    }

    @GetMapping
    public List<Acceleration> findAll(){
        return this.accelerationService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Acceleration> findById(@PathVariable Long id){
        return this.accelerationService.findById(id);
    }

    @GetMapping(params = {"companyId"})
    public List<Acceleration> findByCompanyId(@RequestParam Long companyId){
        return this.accelerationService.findByCompanyId(companyId);
    }

    @PostMapping
    public Acceleration save(@RequestBody Acceleration acc){
        return this.accelerationService.save(acc);
    }

}
