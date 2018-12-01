package com.nish.sessionmanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nish.sessionmanagement.bo.EmployeeBO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeServiceImpl {
	@Autowired
	private AsynchService asynchService;

	public List<List<EmployeeBO>> geEmployeeDetails() {
		log.info("Starting the Asynch process");
		List<Future<List<EmployeeBO>>> empFutures = Stream.generate(() -> asynchService.geEmployeeDetails()).limit(100)
				.collect(Collectors.toList());
		List<EmployeeBO> processedResult = new ArrayList<>();
		final boolean isExecutionCOmplete = false;
		while (!isExecutionCOmplete) {
			if (empFutures.stream().allMatch(empFut -> empFut.isDone())) {
				return empFutures.stream().map(fut -> {

					try {
						return fut.get();
					} catch (InterruptedException | ExecutionException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return null;
					}

				}).collect(Collectors.toList());
			}
		}
	}
}
