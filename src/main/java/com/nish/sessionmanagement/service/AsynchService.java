package com.nish.sessionmanagement.service;

import java.util.List;
import java.util.concurrent.Future;

import com.nish.sessionmanagement.bo.EmployeeBO;

public interface AsynchService {
	public Future<List<EmployeeBO>> geEmployeeDetails();
}
