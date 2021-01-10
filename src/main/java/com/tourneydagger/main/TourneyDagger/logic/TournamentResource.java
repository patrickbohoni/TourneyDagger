package com.tourneydagger.main.TourneyDagger.logic;

import com.tourneydagger.main.TourneyDagger.entities.Tournament;
import com.tourneydagger.main.TourneyDagger.repository.TournamentRepository;
import com.tourneydagger.main.TourneyDagger.repository.TournamentRoundRepository;
import com.tourneydagger.main.TourneyDagger.logic.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Transactional
public class TournamentResource {

    private final Logger log = LoggerFactory.getLogger(TournamentResource.class);

    private static final String ENTITY_NAME = "tournament";

    @Value("{TourneyDagger.clientApp.name}")
    private String applicationName;

    private final TournamentRepository tournamentRepository;

    private TournamentRoundRepository tournamentRoundRepository;

    public TournamentResource(TournamentRepository tournamentRepository) {
        this.tournamentRepository = tournamentRepository;
    }


    @PostMapping("/tournaments")
    public ResponseEntity<Tournament> createTournament(@RequestBody Tournament tournament) throws URISyntaxException {
        log.debug("REST request to save Tournament : {}", tournament);
        if (tournament.getId() != null) {
            throw new BadRequestAlertException("A new tournament cannot already have an ID", ENTITY_NAME, "idexists");
        }
        if(tournamentRoundRepository.count() > 3 ) {
            throw new BadRequestAlertException("This tournament is limited to 3 rounds", ENTITY_NAME, "3 rounds maximum");
        }
        Tournament result = tournamentRepository.save(tournament);
        return ResponseEntity.created(new URI("/api/tournaments/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
                .body(result);
    }


    @PutMapping("/tournaments")
    public ResponseEntity<Tournament> updateTournament(@RequestBody Tournament tournament) throws URISyntaxException {
        log.debug("REST request to update Tournament : {}", tournament);
        if (tournament.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if(tournamentRoundRepository.count() > 3 ) {
            throw new BadRequestAlertException("This tournament is limited to 3 rounds", ENTITY_NAME, "3 rounds maximum");
        }
        Tournament result = tournamentRepository.save(tournament);
        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, tournament.getId().toString()))
                .body(result);
    }


    @GetMapping("/tournaments")
    public List<Tournament> getAllTournaments(@RequestParam(required = false, defaultValue = "false") boolean eagerload) {
        log.debug("REST request to get all Tournaments");
        return tournamentRepository.findAllWithEagerRelationships();
    }


    @GetMapping("/tournaments/{id}")
    public ResponseEntity<Tournament> getTournament(@PathVariable Long id) {
        log.debug("REST request to get Tournament : {}", id);
        Optional<Tournament> tournament = tournamentRepository.findOneWithEagerRelationships(id);
        return ResponseUtil.wrapOrNotFound(tournament);
    }


    @DeleteMapping("/tournaments/{id}")
    public ResponseEntity<Void> deleteTournament(@PathVariable Long id) {
        log.debug("REST request to delete Tournament : {}", id);
        tournamentRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
