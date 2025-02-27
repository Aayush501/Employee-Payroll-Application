package com.bridgelabz.employeepayrollapp.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Getter
@Setter
@Entity
@Table(name = "Payroll")
public class PayrollEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    @JdbcTypeCode(SqlTypes.INTEGER)
    private Integer id;

    @Column(nullable = false, length = 20)  // Name cannot be null, max length 100
    private String name;

    @Column(nullable = false)  // Salary cannot be null
    private Double salary;
}
