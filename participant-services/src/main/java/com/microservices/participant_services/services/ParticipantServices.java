package com.microservices.participant_services.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.participant_services.dto.ParticipantRequest;
import com.microservices.participant_services.dto.ParticipantResponse;
import com.microservices.participant_services.model.Participant;
import com.microservices.participant_services.repository.ParticipantRepository;


@Service
public class ParticipantServices {
	
	@Autowired
	ParticipantRepository participantRepository;
	public void createParticipant(ParticipantRequest participantRequest)
	{
		  Participant partipant = new Participant(
	                participantRequest.getName(),
	                participantRequest.getEmail(),
	                participantRequest.getPhone(),
	                participantRequest.getTopic(),
	                participantRequest.getTimepreference(),
	                participantRequest.getTransport());
	               

	        participantRepository.save(partipant);
	        //log.info("Product {} is saved", product.getId());
	    }

	    public List<ParticipantResponse> getAllParticipants() {
	        List<Participant> participants = participantRepository.findAll();

	        return participants.stream().map(this::mapToParticipantResponse).toList();
	    }
	    private ParticipantResponse mapToParticipantResponse(Participant participant) {
	        return new ParticipantResponse(
	        		participant.getId(),
	                participant.getName(),
	                participant.getEmail(),
	                participant.getPhone(),
	                participant.getTopic(),
	                participant.getTimepreference(),
	                participant.getTransport());
	                
	    }

}
