package com.BMICalculator.BMI.BMI;

import com.BMICalculator.BMI.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bmi")
@CrossOrigin(origins = "*")
public class BMIController {
    private final BMIService bmiService;

    @Autowired
    public BMIController(BMIService bmiService) {
        this.bmiService = bmiService;
    }

    @PostMapping
    public ResponseEntity<BMI> calculateAndSaveBmi(@RequestBody User user) {
        BMI bmi = bmiService.calculateAndSaveBmi(user);
        return ResponseEntity.ok(bmi);
    }


}
