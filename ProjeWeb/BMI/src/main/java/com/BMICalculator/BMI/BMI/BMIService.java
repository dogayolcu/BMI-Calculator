package com.BMICalculator.BMI.BMI;

import com.BMICalculator.BMI.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class BMIService {

    private final BMIRepository bmiRepository;

    @Autowired
    public BMIService(BMIRepository bmiRepository) {
        this.bmiRepository = bmiRepository;
    }

    public BMI calculateAndSaveBmi(User user) {
        BMI bmi = new BMI();
        bmi.setUserId(user.getId());
        bmi.setDateCalculated(LocalDate.now());


        bmiRepository.addBmi(bmi);

        return bmiRepository.getBMIByUserId(user.getId());
    }

    private String classify(double bmiIndex) {
        if (bmiIndex < 16) return "Severe Thinness";
        if (bmiIndex < 17) return "Moderate Thinness";
        if (bmiIndex < 18.5) return "Mild Thinness";
        if (bmiIndex < 25) return "Normal";
        if (bmiIndex < 30) return "Overweight";
        if (bmiIndex < 35) return "Obese Class I";
        if (bmiIndex < 40) return "Obese Class II";
        return "Obese Class III";
    }

  
}
