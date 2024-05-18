package com.qsp.employee_management_system.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.employee_management_system.dao.EmployeeDao;
import com.qsp.employee_management_system.dto.Employee;
import com.qsp.employee_management_system.repo.EmployeeRepo;
import com.qsp.employee_management_system.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class Controller {

//	@Autowired
//	private EmployeeDao dao;
	
	@Autowired
	private EmployeeService service;

	@PostMapping
	public Employee save(@RequestBody Employee employee) {
		return service.save(employee);

	}

	@PostMapping("/saveall")
	public List<Employee> saveAllEmployee(@RequestBody List<Employee> list) {
		return service.saveAllEmployee(list);
	}

	@GetMapping("/find")
	public Employee findPerson(@RequestParam int id) {
		return service.findPerson(id);

	}

	@GetMapping("find/all")
	public List<Employee> findAll() {
		return service.findAll();
	}
	
	@GetMapping("/find/phone")
	public Employee findPerson(@RequestParam long phone) {
		return service.findPerson(phone);

	}

	@GetMapping("/find/email")
	public Employee findPerson(@RequestParam String email) {
		return service.findPerson(email);

	}

	@GetMapping("/find/address")
	public List<Employee> findByAddress(@RequestParam String address) {
		return service.findByAddress(address);
	}

	@GetMapping("/find/name")
	public List<Employee> findByName(@RequestParam String name) {
		return service.findByName(name);

	}
	
	@GetMapping("find/designation")
	public List<Employee> findByDesignation(@RequestParam String designation)
	{
		return service.findByDesignation(designation);
		
	}
	
	@GetMapping("find/salary/lessthan")
	public List<Employee> findLessThanSal(@RequestParam double salary)
	{
		return service.findLessThanSal(salary);
	}
	
	@GetMapping("find/salary/greaterthan")
	public List<Employee> findGreaterThanSal(@RequestParam double salary)
	{
		return service.findGreaterThanSal(salary);
	}
	
	@GetMapping("find/salary/between")
	public List<Employee> findSalaryBetween(@RequestParam double salary1,@RequestParam double salary2)
	{
		return service.findSalaryBetween(salary1,salary2);
	}

	
	@PutMapping("/update")
	public Employee update(@RequestParam int id, @RequestBody Employee employee) {
		return service.update(id, employee);
	}

	@PatchMapping("/update/phone/{id}/{phone}")
	public Employee updatePhone(@PathVariable int id, @PathVariable long phone) {
		return service.updatePhone(id, phone);
	}

	@PatchMapping("/update/email/{id}/{email}")
	public Employee updateEmail(@PathVariable int id, @PathVariable String email) {
		return service.updateEmail(id, email);
	}

	@PatchMapping("/update/password")
	public Employee updatePassword(@RequestParam int id, @RequestParam String password) {
		return service.updatePasswordById(id, password);
	}

	@PatchMapping("/update/address")
	public Employee updateAddress(@RequestParam int id, @RequestParam String address) {
		return service.updateAddress(id, address);
	}
	
	@PatchMapping("/update/designation")
	public Employee updateDesignation(@RequestParam int id, @RequestParam String designation) {
		return service.updateDesignation(id, designation);
	}

	

	@GetMapping("/login")
	public String loginPerson(@RequestParam String userName, @RequestParam String password) {
		
		return service.loginPerson(userName, password);
	}

	
	@DeleteMapping("/delete")
	public Employee delete(@RequestParam int id) {
		return service.delete(id);

	}

	@DeleteMapping("delete/email")
	public Employee deleteByEmail(@RequestParam String email) {
		return service.deleteByEmail(email);
	}

	@DeleteMapping("/delete/phone")
	public Employee deleteByPhone(@RequestParam long phone) {
		return service.deleteByPhone(phone);
	}
	
	@PatchMapping("/update/password/id")
	public Employee updatePasswordById(@RequestParam int id ,@RequestParam String password)
	{
		return service.updatePasswordById(id ,password);
		
	}
	
	@PatchMapping("/update/password/phone")
	public Employee updatePasswordByPhone(@RequestParam long phone ,@RequestParam String password)
	{
		return service.updatePasswordByPhone(phone ,password);
	}
	
	@PatchMapping("/update/password/email")
	public Employee updatePasswordByEmail(@RequestParam String email ,@RequestParam String password)
	{
		return service.updatePasswordByEmail(email ,password);
	}
}
