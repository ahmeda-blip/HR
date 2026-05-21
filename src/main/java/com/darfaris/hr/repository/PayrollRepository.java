package com.darfaris.hr.repository;

import com.darfaris.hr.model.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PayrollRepository extends JpaRepository<Payroll, Long> {
    List<Payroll> findByEmployeeId(Long employeeId);
    List<Payroll> findByPaymentStatus(Payroll.PaymentStatus status);
    List<Payroll> findByPaymentMonthAndPaymentYear(Integer month, Integer year);
    Payroll findByEmployeeIdAndPaymentMonthAndPaymentYear(Long employeeId, Integer month, Integer year);
}
