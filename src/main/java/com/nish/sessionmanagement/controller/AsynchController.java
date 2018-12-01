package com.nish.sessionmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nish.sessionmanagement.bo.EmployeeBO;
import com.nish.sessionmanagement.service.AsynchService;
import com.nish.sessionmanagement.service.EmployeeServiceImpl;

@RestController
public class AsynchController {
	@Autowired
	private EmployeeServiceImpl asynchService;

	@GetMapping(path="/employee")
	public List<List<EmployeeBO>> getEmployeeDetails() {
		return asynchService.geEmployeeDetails();
	}
}
