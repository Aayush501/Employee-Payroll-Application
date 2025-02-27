package com.bridgelabz.employeepayrollapp.repository;

import com.bridgelabz.employeepayrollapp.entities.PayrollEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayrollRepository extends JpaRepository<PayrollEntity, Integer> {
}
