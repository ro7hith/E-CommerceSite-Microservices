package com.microservices.participant_services.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.participant_services.model.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Integer>{

}
