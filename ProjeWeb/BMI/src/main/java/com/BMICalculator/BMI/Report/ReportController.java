package com.BMICalculator.BMI.Report;

import com.BMICalculator.BMI.BMI.BMI;
import com.BMICalculator.BMI.BMI.BMIService;
import com.BMICalculator.BMI.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reports")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ReportController {
    private final ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

   @GetMapping("/reports")
   public List<Report> getReports(@RequestParam String name) {
        return this.reportService.getReportsByUserName(name);
   }
}
