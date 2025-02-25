package com.microservices.participant_services.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.participant_services.dto.ParticipantRequest;
import com.microservices.participant_services.dto.ParticipantResponse;
import com.microservices.participant_services.services.ParticipantServices;

@RestController
//@CrossOrigin
@RequestMapping("/api/participant")
public class ParticipantController {
	@Autowired
	ParticipantServices participantServices;
	
	 @PostMapping("/create")
	   @ResponseStatus(HttpStatus.CREATED)
	    public void createParticipant(@RequestBody ParticipantRequest participantRequest) {
	        //productService.createProduct(productRequest);
		   participantServices.createParticipant(participantRequest);
		    
	 }
	 @GetMapping("/getParticipants")
	    @ResponseStatus(HttpStatus.OK)
	    public List<ParticipantResponse> getAllParticipants() {
	        return participantServices.getAllParticipants();
	    }

	   

}
