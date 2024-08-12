package com.example.employee.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import com.example.employee.dao.EmployeeDao;
import com.example.employee.entityclass.Employee;
import com.example.employee.exception.AgeException;
import com.example.employee.exception.DateTimeException;
import com.example.employee.exception.EmployeeNotFoundException;
//import com.example.employee.exception.NameAlreadyExistsException;
import com.example.employee.exception.NameNotFoundException;
import com.example.employee.exception.StartWithException;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDao ed;
	
	public String postThis(Employee e) {
		return ed.postThis(e);
	}
	
	@GetMapping(value="/get")
	public List<Employee> get(){
		return ed.get();
	}
	
	@GetMapping(value="/gets/{a}")
	public Employee gets(@PathVariable int a){
		return ed.gets(a);
	}
	
	@GetMapping(value="/del/{a}")
	public String del(@PathVariable int a){
		return ed.del(a);
	}
	
	public List<Employee> findAge(int a) throws Exception{
		if(ed.findAge(a).isEmpty()) {
			throw new AgeException("Age is under 18");
		}else {
			return ed.findAge(a);
		}
	}
	
	public List<Employee> getByName(String x) throws Exception {
		if(ed.getByName(x).isEmpty()) {
			throw new NameNotFoundException("Mentioned name is not found here");
		}else {
			return ed.getByName(x);
		}
	}
	
	public Employee starts(String k) throws Exception {
		if(k==null|| !k.startsWith("S")) {
			throw new StartWithException("Name not start with s");
						
		}else {
			return ed.starts(k);
		}
	}
	
//	public String addEmp(Employee name) throws Exception {
//		
//		Employee existingCustomer=ed.findById(name.getId()).orElse(null);
//		if(existingCustomer==null) {
//			ed.save(name);
//			return "Employee added successfully";
//		}else {
//			throw new NameAlreadyExistsException("Employee already present");
//		}
//		
//	}
	
//	public String addEmp(String name) throws Exception {
//		if(ed.addEmp(name).equals(name)) {
//			throw new NameAlreadyExistsException("Name already present");
//		}else {
//			return ed.addEmp(name);
//		}
//	}
	
	public void validateDate(String dateStr) throws Exception {
        try {
            LocalDate.parse(dateStr);
        } catch (Exception e) {
            throw new DateTimeException("Invalid date format: " + dateStr, e);
        }
    }

	
//	 public Employee getEmployeeById(Long id) {
//	        return ed.findById(id)
//	                .map(employee -> checkEmployeeNameLength(employee))
//	                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
//	    }
	
//	public List<Employee> findLen() throws Exception{
//		List<Employee>x= ed.findLen();
//		 
//	}
	 
//		if(l.getName().length()<=4) {
//			return ed.findLen(l);
//			
//		}else {
//			throw new EmployeeNotFoundException("Length is very less");
//		}
	
}
