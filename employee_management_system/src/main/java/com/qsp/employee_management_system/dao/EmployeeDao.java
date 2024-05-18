package com.qsp.employee_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.qsp.employee_management_system.dto.Employee;
import com.qsp.employee_management_system.repo.EmployeeRepo;

@Repository
public class EmployeeDao {

	@Autowired
	private EmployeeRepo repo;
	
	public Employee save( Employee employee)
	{
		return repo.save(employee);
		
	}
	
	public List<Employee> saveAllEmployee( List<Employee> list) {
		 return repo.saveAll(list);
	}
	
	public Employee findPerson( int id) {
		
		return repo.findById(id).get();
	}
	
	public List<Employee> findAll()
	{
		return repo.findAll();
	}
	
	
	public void  delete( Employee e)
	{
		
	      repo.delete(e);
	}
	
//	public Employee update( int id, Employee employee)
//	{
//		Optional<Employee>op=repo.findById(id);
//		if(op.isPresent())
//		{    
//			employee.setId(id);
//			repo.save(employee);
//			return employee ;
//		}
//		else
//		{
//			return null;
//		}
//	}
	
//	public Employee updatePhone( int id , long phone) 
//	{
//		Optional<Employee>op=repo.findById(id);
//		if(op.isPresent())
//		{    
//			Employee employee=op.get();
//			employee.setPhone(phone);
//			repo.save(employee);
//			return employee;
//		}
//		else
//		{
//			return null;		}
//	}
	
	
//	public Employee updateEmail( int id , String email) 
//	{
//		Optional<Employee>op=repo.findById(id);
//		if(op.isPresent())
//		{    
//			Employee employee=op.get();
//			employee.setEmail(email);
//			repo.save(employee);
//			return employee;
//		}
//		else
//		{
//			return null;
//		}
//	}
//	
//	public Employee updatePassword( int id , String password) 
//	{
//		Optional<Employee>op=repo.findById(id);
//		if(op.isPresent())
//		{    
//			Employee employee=op.get();
//			employee.setPassword(password);
//			repo.save(employee);
//			return employee;
//		}
//		else
//		{
//			return null;
//		}
//	}
//	
//	public Employee updateAddress( int id , String address) 
//	{
//		Optional<Employee>op=repo.findById(id);
//		if(op.isPresent())
//		{    
//			Employee employee=op.get();
//			employee.setAddress(address);
//			repo.save(employee);
//			return employee;
//		}
//		else
//		{
//			return null;
//		}
//	}
	
	public Employee findPerson( long phone) 
	{
		return repo.findByPhone(phone);
	}
	
	
	public Employee findPerson( String email) 
	{
		return repo.getByEmail(email);
		
	}
	
	public List<Employee> findByAddress( String address)
	{
	    return repo.employeeByAddress(address);
		
//		if(!(employee.isEmpty()))
//		{    
//			
//			return employee;
//		}
//		else
//		{
//			return null;
//		}
	}
	
	public List<Employee> findByName( String name)
	{
		return repo.personByName(name);
//		List<Employee> employee=(List<Employee>) repo.personByName(name);
//		if(!(employee.isEmpty()))
//		{    
//			
//			return employee;
//		}
//		else
//		{
//			return null;
//		}
	}
	
	public Employee loginPerson( String username)
	{
		try {
		 long phone=Long.parseLong(username);
		 return repo.findByPhone(phone);
		}
		catch(NumberFormatException e)
		{
			return repo.getByEmail(username);
		}
	}
	
	public Employee deleteByEmail( Employee employee)
	{
			repo.delete(employee);
			return employee;
	}
	
	public Employee deleteByPhone( Employee employee)
	{
			repo.delete(employee);
			return employee;
	}

	public List<Employee> findByDesignation(String designation) {
		return repo.findByDesignation(designation);

	}

	public List<Employee> findLessThanSal(double sal) {
		
		  return repo.findBySalaryLessThan(sal);
	}

	public List<Employee> findGreaterThanSal(double sal) {
		
		return repo.findBySalaryGreaterThan(sal);
	}

	public List<Employee> findSalaryBetween(double sal1, double sal2) {
		return repo.findBySalaryBetween(sal1,sal2);
	}

	public Employee updateDesignation(Employee employee) {
		
		    
		  return	repo.save(employee);
		
	}

	public Employee updatePasswordById(Employee employee) {
		
		return repo.save(employee);
	}

	public Employee updatePasswordByPhone(Employee employee) {
		 
		return repo.save(employee);
	}

	public Employee updatePasswordByEmail(Employee employee) {
		
		return repo.save(employee);	}

	
}
