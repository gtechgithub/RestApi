package com.javapoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	
	@Autowired 
	EmployeeRepository empRepo;
	
	public List<Employee> listAllEmployee(){
		List<Employee> emp =  null;
		emp = empRepo.findAll();
		return emp;
	}
	
	public Employee findById(int id) {
		Employee  emp = null;
		emp = empRepo.findById(id);
		return emp;
	}
	
	public void deleteEmployee(int id) {
		empRepo.delete(findById(id));
	}
	
	public void updateEmployee(int id, int salary) {
		Employee  emp = null;
		emp = empRepo.findById(id);
		emp.setSalary(salary);
		empRepo.flush();
	}
	
	public Employee addEmployee(Employee emp) {
		Employee empPersistence = empRepo.save(emp);
		return empPersistence;
	}
}
