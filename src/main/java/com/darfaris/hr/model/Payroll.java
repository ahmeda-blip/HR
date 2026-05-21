package com.darfaris.hr.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "payroll")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payroll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @Column(name = "payroll_date", nullable = false)
    private LocalDate payrollDate;

    @Column(name = "payment_month")
    private Integer paymentMonth;

    @Column(name = "payment_year")
    private Integer paymentYear;

    @Column(name = "base_salary")
    private Double baseSalary;

    @Column(name = "allowances")
    private Double allowances = 0.0;

    @Column(name = "deductions")
    private Double deductions = 0.0;

    @Column(name = "bonus")
    private Double bonus = 0.0;

    @Column(name = "total_salary")
    private Double totalSalary;

    @Column(name = "working_days")
    private Integer workingDays;

    @Column(name = "present_days")
    private Integer presentDays;

    @Column(name = "absent_days")
    private Integer absentDays;

    @Column(name = "leave_days")
    private Integer leaveDays;

    @Column(name = "payment_status")
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus = PaymentStatus.PENDING;

    @Column(name = "paid_date")
    private LocalDate paidDate;

    @Column(columnDefinition = "TEXT")
    private String notes;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "created_by")
    private String createdBy;

    public enum PaymentStatus {
        PENDING,
        PROCESSED,
        PAID,
        CANCELLED
    }
}
