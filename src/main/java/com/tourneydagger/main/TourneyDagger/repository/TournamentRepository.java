package com.tourneydagger.main.TourneyDagger.repository;

import com.tourneydagger.main.TourneyDagger.entities.Tournament;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament,Long> {

}
