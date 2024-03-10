package com.BMICalculator.BMI.Report;

import com.BMICalculator.BMI.BMI.BMI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report, Integer> {

    @Query(value = "SELECT * FROM report where first_name like :name", nativeQuery = true)
    List<Report> getReports(String name);
}
