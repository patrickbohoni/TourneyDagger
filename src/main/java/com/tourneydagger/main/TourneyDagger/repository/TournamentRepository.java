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

    @Query(value = "select distinct tournament from Tournament tournament left join fetch tournament.tournamentrounds",
            countQuery = "select count(distinct tournament) from Tournament tournament")
    Page<Tournament> findAllWithEagerRelationships(Pageable pageable);

    @Query("select distinct tournament from Tournament tournament left join fetch tournament.tournamentrounds")
    List<Tournament> findAllWithEagerRelationships();

    @Query("select tournament from Tournament tournament left join fetch tournament.tournamentrounds where tournament.id =:id")
    Optional<Tournament> findOneWithEagerRelationships(@Param("id") Long id);
}
