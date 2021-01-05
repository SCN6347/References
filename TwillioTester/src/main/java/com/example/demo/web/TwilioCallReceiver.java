package com.example.demo.web;

import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TwilioCallReceiver {

	@RequestMapping(value = "testEndpoint", method = RequestMethod.POST)
	public void receiveTwlilioResponse(@RequestParam HashMap<String, String> responseMap)
	{
		System.out.println(responseMap.toString());
	
	}
}
