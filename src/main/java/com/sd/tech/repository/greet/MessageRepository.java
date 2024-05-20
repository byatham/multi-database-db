package com.sd.tech.repository.greet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sd.tech.entity.dept.Department;
import com.sd.tech.entity.greet.Greet;

@Repository
public interface MessageRepository extends JpaRepository<Greet, Integer> {

}
