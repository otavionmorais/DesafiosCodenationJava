package com.challenge.endpoints;

import com.challenge.entity.Acceleration;
import com.challenge.entity.Challenge;
import com.challenge.service.impl.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/challenge")
public class ChallengeController {

    private final ChallengeService challengeService;

    @Autowired
    public ChallengeController(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    @GetMapping(params = {"accelerationId", "userId"})
    public List<Challenge> findByAccelerationIdAndUserId(@RequestParam Long accelerationId, @RequestParam Long userId) {
        return this.challengeService.findByAccelerationIdAndUserId(accelerationId, userId);
    }

    @PostMapping
    public Challenge save(@RequestBody Challenge acc){
        return this.challengeService.save(acc);
    }

}
