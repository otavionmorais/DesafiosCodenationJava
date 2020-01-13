package com.challenge.endpoints;

import com.challenge.dto.SubmissionDTO;
import com.challenge.entity.Submission;
import com.challenge.mappers.SubmissionMapper;
import com.challenge.service.impl.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/submission")
public class SubmissionController {

    private final SubmissionService submissionService;
    private final SubmissionMapper submissionMapper;

    @Autowired
    public SubmissionController(SubmissionService submissionService, SubmissionMapper submissionMapper) {
        this.submissionService = submissionService;
        this.submissionMapper = submissionMapper;
    }

    @GetMapping(params = {"challengeId", "accelerationId"})
    public List<SubmissionDTO> findByChallengeIdAndAccelerationId(@RequestParam Long challengeId, @RequestParam Long accelerationId){
        List<Submission> resp = this.submissionService.findByChallengeIdAndAccelerationId(challengeId, accelerationId);
        return submissionMapper.map(resp);
    }

    @PostMapping
    public Submission save(@RequestBody Submission submission){
        return this.submissionService.save(submission);
    }

}
