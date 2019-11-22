package com.challenge.service;

import com.challenge.entity.Company;
import com.challenge.repository.CompanyRepository;
import com.challenge.service.interfaces.CompanyServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompanyService implements CompanyServiceInterface {


    private CompanyRepository companyRepository;

    @Autowired(required = true)
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository=companyRepository;
    }

    @Override
    public Optional<Company> findById(Long id) {
        return companyRepository.findById(id);
    }

    @Override
    public List<Company> findByAccelerationId(Long accelerationId) {
        List<Company> result = companyRepository.findByAccelerationId(accelerationId);
        List<Company> resp = result.stream().distinct().collect(Collectors.toList());
        return resp;
    }

    @Override
    public List<Company> findByUserId(Long userId) {
        return companyRepository.findByUserId(userId);
    }

    @Override
    public Company save(Company object) {
        return companyRepository.save(object);
    }
}
