package com.example.experiments.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.experiments.dto.AuditorAwareDto;
import com.example.experiments.service.AuditorAwareService;

@RestController
@RequestMapping(value = "auditorAware")
public class AuditorAwareExpController {

	@Autowired
	private AuditorAwareService auditorAwareService;
	
	@PostMapping
	public void createAuditorAwareRecord(@RequestBody AuditorAwareDto auditorAwareDto, HttpServletRequest request)
	{
		auditorAwareService.createAuditorAwareRecord(auditorAwareDto);	
	}
	
	@RequestMapping(value = "/get-count", method = RequestMethod.GET)
	public Long getAuditorAwareRecordCount(HttpServletRequest request)
	{
		return auditorAwareService.getAuditorAwareRecordcount();
	}
	
	@RequestMapping(value = "/get-record/{id}", method = RequestMethod.GET)
	public ResponseEntity<AuditorAwareDto>  getAuditorAwareRecord(@PathVariable("id") Integer id, HttpServletRequest request)
	{
		AuditorAwareDto auditorAwareDtoResponse = auditorAwareService.getAuditorAwareRecord(id);	
		if(auditorAwareDtoResponse== null) return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		else return new ResponseEntity<AuditorAwareDto>(auditorAwareDtoResponse, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<AuditorAwareDto> updateAuditorAwareRecord(@RequestBody AuditorAwareDto auditorAwareDto, HttpServletRequest request)
	{
		AuditorAwareDto auditorAwareDtoResponse = auditorAwareService.updateAuditorAwareRecord(auditorAwareDto);
		if(auditorAwareDtoResponse== null) return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		else return new ResponseEntity<AuditorAwareDto>(auditorAwareDtoResponse, HttpStatus.OK);
	}
	
	@DeleteMapping
	@RequestMapping(value = "/{id}")
	public void deleteAuditorAwareRecord(@PathVariable("id") Integer id, HttpServletRequest request)
	{
		auditorAwareService.deleteAuditorAwareRecord(id);	
	}
}
