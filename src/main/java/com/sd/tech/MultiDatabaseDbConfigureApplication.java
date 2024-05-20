package com.sd.tech;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sd.tech.entity.dept.Department;
import com.sd.tech.entity.emp.Employee;
import com.sd.tech.repository.dept.DepartmentRepository;
import com.sd.tech.repository.emp.EmployeeRepository;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
//@ComponentScan(basePackages = { "com.sd.tech","com.sd.tech.repository","com.sd.tech.config"})

public class MultiDatabaseDbConfigureApplication {
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	//@Autowired
	//MessageRepository  messageRepository;

	@PostConstruct  
	public void initDBRecords() {  
		
		List<Employee> employees=new ArrayList<>();

	    employees.add(new Employee("John Doe", "HR", 50000.0,  "johnefexample@gmail.com", 30));  
	    employees.add(new Employee("Jane Smith", "Finance",60000.0,"jane@example@gmail.com", 35));  
	    employees.add(new Employee("Nagaiah", "HR", 50000.0,  "nag@gmail.com", 30));  
	    employees.add(new Employee("Chennaiah", "Finance",60000.0,"jane@example@gmail.com", 35));  
	    employees.add(new Employee("Ramaiah", "HR", 50000.0,  "johnefexample@gmail.com", 30));  
	    employees.add(new Employee("Jangaiah", "Finance",60000.0,"jane@example@gmail.com", 35));  
	    
	    employeeRepository.saveAll(employees);  
	    
	    List<Department> departments = new ArrayList<>();  
	    departments.add(new Department("Finance", "John Doe"));  
	    departments.add(new Department("Human Resources", "Jane Smith"));  
	    departments.add(new Department("Marketing", "Alice Johnson"));  
	    departments.add(new Department("Engineering", "Bob Williams"));  
	    departments.add(new Department("Sales", "Eva Brown"));  
	    departmentRepository.saveAll(departments);  
	   
	    /*
	    List<Greet> greets = new ArrayList<>(); 
	    greets.add(new Greet("Hello Good Morning"));
	    
	    greets.add(new Greet("Hello Good Afternoon"));
	    greets.add(new Greet("Hello Good Evening"));
	    greets.add(new Greet("Hello Good night"));

	    messageRepository.saveAll(greets); */
		
	} 

	public static void main(String[] args) {
		SpringApplication.run(MultiDatabaseDbConfigureApplication.class, args);
	}

}
