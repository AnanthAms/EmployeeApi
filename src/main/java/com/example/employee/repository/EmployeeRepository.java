package com.example.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.employee.entityclass.Employee;

public interface EmployeeRepository extends JpaRepository <Employee,Integer> {

	@Query(value="select * from employee where age < ?",nativeQuery=true)
	public List<Employee> findAge(int a);
	
	@Query(value="select * from employee where name=?",nativeQuery=true)
	public List<Employee> getByName(String x);
	
	@Query(value="select * from employee ",nativeQuery=true)
	public List<Employee> starts(String k);
	
	//public String addEmp(String name);
}
