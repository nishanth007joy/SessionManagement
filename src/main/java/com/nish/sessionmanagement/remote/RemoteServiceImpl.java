package com.nish.sessionmanagement.remote;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nish.sessionmanagement.bo.EmployeeBO;

@Service
public class RemoteServiceImpl implements RemoteService {

	@Autowired
	private RestTemplate restTemplate;

	@Value(value = "${test.api.url}")
	private String uri;

	@Override
	public List<EmployeeBO> getEmployeeDetails() {
		ResponseEntity<List<EmployeeBO>> employeeDetails = restTemplate.exchange(uri, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<EmployeeBO>>() {
				});
		return employeeDetails.getBody();
	}

}
