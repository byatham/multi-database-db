package com.sd.tech.entity.emp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity

public class Employee {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "custom_seq_gen")
    @SequenceGenerator(name = "custom_seq_gen", sequenceName = "custom_sequence", allocationSize = 5)
	private int id;
	private String name;
	private String dept;
	private double salary;
	private String email;
	private int age;
	public Employee(String name, String dept, double salary, String email, int age) {
		super();
		this.name = name;
		this.dept = dept;
		this.salary = salary;
		this.email = email;
		this.age = age;
	}

	
	
	


}
