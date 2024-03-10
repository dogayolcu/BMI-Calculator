package com.BMICalculator.BMI.BMI;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "BMI")
public class BMI {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "bmi_index")
    private double bmiIndex;

    @Column(name = "classification")
    private String classification;

    @Column(name = "date_calculated")
    private LocalDate dateCalculated;

    public BMI() {
        // Default constructor
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public double getBmiIndex() {
        return bmiIndex;
    }

    public void setBmiIndex(double bmiIndex) {
        this.bmiIndex = bmiIndex;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public LocalDate getDateCalculated() {
        return dateCalculated;
    }

    public void setDateCalculated(LocalDate dateCalculated) {
        this.dateCalculated = dateCalculated;
    }


}
