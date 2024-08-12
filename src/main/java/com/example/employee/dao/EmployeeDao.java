package com.example.employee.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.employee.entityclass.Employee;
import com.example.employee.exception.NameAlreadyExistsException;
import com.example.employee.repository.EmployeeRepository;

@Repository
public class EmployeeDao {
	
	@Autowired
	EmployeeRepository er;

	public String postThis(Employee e) {
		er.save(e);
		return "Posted successfully";
	}
	
	@GetMapping(value="/get")
	public List<Employee> get(){
		return er.findAll();
	}
	
	@GetMapping(value="/gets/{a}")
	public Employee gets(@PathVariable int a){
		return er.findById(a).get();
	}
	
	@GetMapping(value="/del/{a}")
	public String del(@PathVariable int a){
		 er.deleteById(a);
		 return "Delete Successfully";
	}
	
	public List<Employee> findAge(int a) throws Exception{
		return er.findAge(a);
	}
	
	public List< Employee> getByName( String x) throws Exception {
		return er.getByName(x);
	}
	
	public Employee starts(String k) throws Exception{
		return er.findAll().get(0);
	}
	
//	public String addEmp(String name) {
//		return er.addEmp(name);
//		
//	}
	
	

//	 public Employee getEmployeeById( Long id) {
//		 return er.findById(id);
//	 }
	
//	public List<Employee> findLen(){
//		//return er.findLen(emp);
//	return	er.findAll();
//		
//	}
}
