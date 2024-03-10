package com.BMICalculator.BMI.BMI;

import com.BMICalculator.BMI.Report.Report;
import com.BMICalculator.BMI.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BMIRepository extends JpaRepository<BMI, Integer> {
    @Modifying
    @Query(value ="INSERT INTO bmi(bmi_index,classification,date_calculated,user_id) values (:#{#bmi.bmiIndex},:#{#bmi.classification},:#{#bmi.dateCalculated},:#{#bmi.userId});", nativeQuery = true)
    int addBmi(@Param("bmi")BMI bmi);

    @Query(value ="select * from bmi where user_id = :userId", nativeQuery = true)
    BMI getBMIByUserId(int userId);
}
