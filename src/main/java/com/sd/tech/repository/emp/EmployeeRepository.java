package com.sd.tech.repository.emp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sd.tech.entity.emp.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
