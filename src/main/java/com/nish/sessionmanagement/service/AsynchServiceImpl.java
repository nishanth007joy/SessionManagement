package com.nish.sessionmanagement.service;

import java.util.List;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import com.nish.sessionmanagement.bo.EmployeeBO;
import com.nish.sessionmanagement.remote.RemoteService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AsynchServiceImpl implements AsynchService {
	@Autowired
	private RemoteService remoteService;

	@Async
	@Override
	public Future<List<EmployeeBO>> geEmployeeDetails() {
		log.info("Starting inside asynch");
		List<EmployeeBO> empList = remoteService.getEmployeeDetails();
		return new AsyncResult<List<EmployeeBO>>(empList);
	}

}
