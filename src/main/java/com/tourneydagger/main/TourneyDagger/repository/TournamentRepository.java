package com.tourneydagger.main.TourneyDagger.repository;

import com.tourneydagger.main.TourneyDagger.entities.Tournament;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament,Long> {

    @Query("select tournament from Tournament tournament left join fetch tournament.tournamentrounds where tournament.id =:id")
    Optional<Tournament> findOneWithEagerRelationships(@Param("id") Long id);


}
