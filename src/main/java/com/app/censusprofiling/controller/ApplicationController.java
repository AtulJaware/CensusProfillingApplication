package com.app.censusprofiling.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.censusprofiling.entity.Application;
import com.app.censusprofiling.exception.ApplicationAlreadyExistsException;
import com.app.censusprofiling.exception.ApplicationNotFoundException;
import com.app.censusprofiling.services.IApplicationService;

@RestController
public class ApplicationController {
	

	@Autowired
	private IApplicationService iApplicationService;
	

	@GetMapping("/applications")
	public List<Application> getAllApplications(){
		return iApplicationService.getAllApplications();
	}
	
	@GetMapping("/application/{id}")
	public Optional<Application> getApplication(@PathVariable int id) throws ApplicationNotFoundException{
		return iApplicationService.getApplication(id);
	}
	
	@PostMapping("/application/add")
	public Application addApplication(@Valid @RequestBody Application  application) throws ApplicationAlreadyExistsException{
		return iApplicationService.addApplication(application);
	}
	
	@DeleteMapping("/application/delete/{id}")
	public Optional<Application> deleteApplication(@PathVariable int id) throws ApplicationNotFoundException{
		return iApplicationService.deleteApplication(id);
	}

	@PutMapping("/application/update/{id}")
	public Application updateApplication(@PathVariable int id, @Valid @RequestBody Application application) throws ApplicationNotFoundException{
		return iApplicationService.updateApplication(id, application);
	}


}
