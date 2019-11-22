package com.challenge.endpoints;

import com.challenge.dto.CandidateDTO;
import com.challenge.entity.Candidate;
import com.challenge.mappers.CandidateMapper;
import com.challenge.mappers.CandidateMapperImpl;
import com.challenge.service.impl.CandidateService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    private final CandidateService candidateService;
    private final CandidateMapperImpl candidateMapper = new CandidateMapperImpl();

    @Autowired
    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;

    }

    @GetMapping("/{userId}/{accelerationId}/{companyId}")
    public CandidateDTO findById(@PathVariable Long userId, @PathVariable Long companyId, @PathVariable Long accelerationId) {
        Optional<Candidate> resp = this.candidateService.findById(userId, companyId, accelerationId);
        return candidateMapper.map(resp.get());
    }

    @GetMapping(params = "companyId")
    public List<CandidateDTO> findByCompanyId(@RequestParam Long companyId){
        List<Candidate> resp = this.candidateService.findByCompanyId(companyId);
        return candidateMapper.map(resp);
    }

    @PostMapping
    public Candidate save(@RequestBody Candidate candidate){
        return this.candidateService.save(candidate);
    }
}
