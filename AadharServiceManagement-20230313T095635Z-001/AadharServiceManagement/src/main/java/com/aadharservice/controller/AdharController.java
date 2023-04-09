package com.aadharservice.controller;

import java.util.HashMap;
import java.util.Random;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.aadharservice.bean.Aadhar;

@RestController
public class AdharController {

	@GetMapping("/getaadharcard/{id}")
	public Aadhar getAadhar(@PathVariable Integer id) {

		HashMap<String, Integer> uriVariable = new HashMap<>();

		uriVariable.put("id", id);

		ResponseEntity<Aadhar> response = new RestTemplate().getForEntity("http://localhost:9090/api/getuser/{id}",
				Aadhar.class, uriVariable);

		//All the data from user Management service will come here
		Aadhar aadhar = response.getBody();

		// it create generate the random number to get the aadhar card number
		Random random = new Random();

		Integer aadharnumber = random.nextInt();

		
		
		
		
		Aadhar data = new Aadhar(aadharnumber, id, aadhar.getName(), aadhar.getEmail(), aadhar.getPassword(),
				aadhar.getAbout(), aadhar.getRoles());
		

		return data;

	}
}
