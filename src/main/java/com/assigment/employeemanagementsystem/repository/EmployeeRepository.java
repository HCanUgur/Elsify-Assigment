package com.assigment.employeemanagementsystem.repository;

import com.assigment.employeemanagementsystem.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {


}
