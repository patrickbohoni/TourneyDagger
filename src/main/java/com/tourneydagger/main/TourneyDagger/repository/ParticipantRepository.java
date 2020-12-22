package com.tourneydagger.main.TourneyDagger.repository;

import com.tourneydagger.main.TourneyDagger.entities.Participant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long> {

}
