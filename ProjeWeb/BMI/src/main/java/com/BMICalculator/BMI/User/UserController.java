package com.BMICalculator.BMI.User;

import com.BMICalculator.BMI.BMI.BMI;
import com.BMICalculator.BMI.BMI.BMIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.Console;
import java.io.IOException;
import java.util.UUID;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BMIService bmiService;






    @PostMapping("/user")
    @Transactional
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public BMI saveUser(@RequestBody User user) {
        User returnedUser = userRepository.save(user);
        user.setId(returnedUser.getId());
        BMI bmi = bmiService.calculateAndSaveBmi(user);

        return bmi;
    }
}






