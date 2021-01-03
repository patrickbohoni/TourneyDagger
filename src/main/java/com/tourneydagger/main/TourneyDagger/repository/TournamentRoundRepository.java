package com.tourneydagger.main.TourneyDagger.repository;

import com.tourneydagger.main.TourneyDagger.entities.TournamentRound;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TournamentRoundRepository extends JpaRepository<TournamentRound, Long> {

    @Query(value = "select distinct tournamentRound from TournamentRound tournamentRound left join fetch tournamentRound.games",
            countQuery = "select count(distinct tournamentRound) from TournamentRound tournamentRound")
    Page<TournamentRound> findAllWithEagerRelationships(Pageable pageable);

    @Query("select distinct tournamentRound from TournamentRound tournamentRound left join fetch tournamentRound.games")
    List<TournamentRound> findAllWithEagerRelationships();

    @Query("select tournamentRound from TournamentRound tournamentRound left join fetch tournamentRound.games where tournamentRound.id =:id")
    Optional<TournamentRound> findOneWithEagerRelationships(@Param("id") Long id);
}
