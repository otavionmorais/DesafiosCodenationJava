package com.challenge.endpoints;

import com.challenge.entity.User;
import com.challenge.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> findAll(){
        return this.userService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> findById(@PathVariable Long id){
        return this.userService.findById(id);
    }

    @GetMapping(params = {"accelerationName"})
    public List<User> findByAccelerationName(@RequestParam String accelerationName){
        return this.userService.findByAccelerationName(accelerationName);
    }

    @GetMapping(params = {"companyId"})
    public List<User> findByCompanyId(@RequestParam Long companyId){
        return this.userService.findByCompanyId(companyId);
    }

    public User save(User user){
        return this.userService.save(user);
    }

}
