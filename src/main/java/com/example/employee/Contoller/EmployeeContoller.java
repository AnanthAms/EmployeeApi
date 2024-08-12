package com.example.employee.Contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.entityclass.Employee;
//import com.example.employee.exception.EmployeeNotFoundException;
import com.example.employee.service.EmployeeService;

@RestController
public class EmployeeContoller {

	@Autowired
	EmployeeService es;
	
	@PostMapping (value="/postEmp")
	public String postThis(@RequestBody Employee e) {
		return es.postThis(e);
	}
	
	@GetMapping(value="/get")
	public List<Employee> get(){
		return es.get();
	}
	
	@GetMapping(value="/gets/{a}")
	public Employee gets(@PathVariable int a){
		return es.gets(a);
	}
	
	@GetMapping(value="/del/{a}")
	public String del(@PathVariable int a){
		return es.del(a);
	}
	
	@GetMapping (value="/age/{a}")
	public List< Employee> findAge(@PathVariable int a) throws Exception{
		return es.findAge(a);
	}
	
	
	@GetMapping(value="/name/{x}")
	public List< Employee> getByName(@PathVariable String x) throws Exception {
		return es.getByName(x);
	}
	
	@GetMapping(value="/start")
	public Employee starts(@RequestParam String k) throws Exception {
		return es.starts(k);
		
	}
//	
//	@PostMapping(value="/addEmployee/{name}")
//	public String addEmp(@RequestBody String name) throws Exception{
//		return es.addEmp(name);
//		
//	}
	

	 @GetMapping("/validate-date")
	    public String validateDate(@RequestParam String date) throws Exception {
	         es.validateDate(date);
	        return "Date is valid";
	    }
	 
//	 @GetMapping(value="/care/{l}")
//	 public List<Employee> findLen() {
//		 return es.findLen();
//		 
//	 }
	 
//	 @GetMapping("/{id}")
//	    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
//	        try {
//	            Employee employee = es.getEmployeeById(id);
//	            return ResponseEntity.ok(employee);
//	        } catch (Exception  ex) {
//	            return ResponseEntity.badRequest().body(null);
//	        }
//	    }
}
