package com.BMICalculator.BMI.Report;

import com.BMICalculator.BMI.BMI.BMI;
import com.BMICalculator.BMI.BMI.BMIRepository;
import com.BMICalculator.BMI.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReportService {

    private final ReportRepository reportRepository;

    @Autowired
    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    List<Report> getReportsByUserName(String name){
        return reportRepository.getReports(name);
    }
}