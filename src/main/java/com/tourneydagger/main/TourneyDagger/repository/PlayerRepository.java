package com.tourneydagger.main.TourneyDagger.repository;

import com.tourneydagger.main.TourneyDagger.entities.Player;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

}