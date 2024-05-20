package com.sd.tech.repository.dept;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sd.tech.entity.dept.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
