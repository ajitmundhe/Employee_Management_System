package com.qsp.employee_management_system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.qsp.employee_management_system.dao.EmployeeDao;
import com.qsp.employee_management_system.dto.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao dao;

	public Employee save(Employee employee) {
		double salary = employee.getSalary();
		if (salary <= 10000) {
			employee.setGrade('D');
		} else if (salary > 10000 && 20000 >= salary) {
			employee.setGrade('C');
		} else if (salary > 20000 && 40000 >= salary) {
			employee.setGrade('B');
		} else {
			employee.setGrade('A');
		}
		return dao.save(employee);

	}

	public List<Employee> saveAllEmployee(List<Employee> list) {

		for (Employee employee : list) {

			double salary = employee.getSalary();
			if (salary <= 10000) {
				employee.setGrade('D');
			} else if (salary > 10000 && 20000 >= salary) {
				employee.setGrade('C');
			} else if (salary > 20000 && 40000 >= salary) {
				employee.setGrade('B');
			} else {
				employee.setGrade('A');
			}
		}

		return dao.saveAllEmployee(list);
	}

	public Employee findPerson(int id) {

		return dao.findPerson(id);

	}

	public List<Employee> findAll() {
		return dao.findAll();
	}

	public Employee findPerson(@RequestParam long phone) {
		return dao.findPerson(phone);
	}

	public Employee findPerson(@RequestParam String email) {
		return dao.findPerson(email);

	}

	public List<Employee> findByAddress(@RequestParam String address) {
		List<Employee> employee = (List<Employee>) dao.findByAddress(address);

		if (!(employee.isEmpty())) {

			return employee;
		} else {
			return null;
		}
	}

	public List<Employee> findByName(String name) {
//		return dao.findByName(name);
		List<Employee> employee = (List<Employee>) dao.findByName(name);
		if (!(employee.isEmpty())) {

			return employee;
		} else {
			return null;
		}
	}

	public String loginPerson(String username, String password) {
		Employee employee = dao.loginPerson(username);
		if (employee != null) {
			if (employee.getPassword().equals(password)) {
				return "Login Sucessfull";
			} else {
				return "Password Incorrect ";
			}

		} else {
			return "User is not registered";
		}
	}

	public Employee deleteByEmail(String email) {
		Employee employee = dao.findPerson(email);
		if (employee != null) {

			return dao.deleteByEmail(employee);

		} else {
			return null;
		}
	}

	public Employee deleteByPhone(long phone) {
		Employee employee = dao.findPerson(phone);
		if (employee != null) {
			dao.deleteByPhone(employee);
			return employee;
		} else {
			return null;
		}
	}

	public List<Employee> findByDesignation(String designation) {
		List<Employee> employee = dao.findByDesignation(designation);

		if (employee.isEmpty()) {

			return null;
		} else {
			return employee;
		}
	}

	public List<Employee> findLessThanSal(double sal) {

		List<Employee> employee = dao.findLessThanSal(sal);
		if (employee.isEmpty()) {

			return null;
		} else {
			return employee;
		}
	}

	public List<Employee> findGreaterThanSal(double sal) {

		List<Employee> employee = dao.findGreaterThanSal(sal);
		if (employee.isEmpty()) {

			return null;
		} else {
			return employee;
		}
	}

	public List<Employee> findSalaryBetween(double sal1, double sal2) {
		List<Employee> employee = dao.findSalaryBetween(sal1, sal2);
		if (employee.isEmpty()) {

			return null;
		} else {
			return employee;
		}
	}

	public Employee updateDesignation(int id, String designation) {

		Employee employee = dao.findPerson(id);
		if (employee != null) {
			employee.setDesignation(designation);
			return dao.save(employee);
		} else {
			return null;
		}
	}

	public Employee updatePasswordById(int id, String password) {

		Employee employee = dao.findPerson(id);
		if (employee != null) {
			employee.setPassword(password);
			return dao.save(employee);
		} else {
			return null;
		}
	}

	public Employee updatePasswordByPhone(long phone, String password) {

		Employee employee = dao.findPerson(phone);

		if (employee != null) {

			employee.setPassword(password);
			return dao.updatePasswordByPhone(employee);
		} else {
			return null;
		}
	}

	public Employee updatePasswordByEmail(String email, String password) {

		Employee employee = dao.findPerson(email);
		if (employee != null) {

			employee.setPassword(password);
			return dao.updatePasswordByEmail(employee);
		} else {
			return null;
		}
	}

	
	public Employee update( int id, Employee employee)
	{
		Employee e=dao.findPerson(id);
		if(e!=null)
		{    
			employee.setId(id);
			return dao.save(employee);
			
		}
		else
		{
			return null;
		}
	}
	
	public Employee updatePhone( int id , long phone) 
	{
		Employee e=dao.findPerson(id);	
		if(e!=null)
		{    
			e.setPhone(phone);
			return dao.save(e);
			
		}
		else
		{
			return null;
		}	
	}
	
	public Employee updateEmail( int id , String email) 
	{
		Employee e=dao.findPerson(id);	
		if(e!=null)
		{    
			e.setEmail(email);
			return dao.save(e);
			
		}
		else
		{
			return null;
		}
	}
	
	
	public Employee updatePassword( int id , String password) 
	{
		Employee e=dao.findPerson(id);	
		if(e!=null)
		{    
			e.setPassword(password);
			return dao.save(e);
			
		}
		else
		{
			return null;
		}
	}
	
	public Employee updateAddress( int id , String address) 
	{
		Employee e=dao.findPerson(id);	
		if(e!=null)
		{    
			e.setAddress(address);
			return dao.save(e);
			
		}
		else
		{
			return null;
		}
	}
	
	public Employee  delete( int id)
	{
		Employee e=dao.findPerson(id);
	      if(e!=null)
	      {
	    	    dao.delete(e);
	    	    return e;
	      }
	      else
	      {
	    	  return null;
	      }
	
	}
}
