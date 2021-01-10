package com.tourneydagger.main.TourneyDagger.logic;

import com.tourneydagger.main.TourneyDagger.entities.TournamentRound;
import com.tourneydagger.main.TourneyDagger.logic.errors.BadRequestAlertException;
import com.tourneydagger.main.TourneyDagger.repository.TournamentRoundRepository;

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
public class TournamentRoundResource {

    private final Logger log = LoggerFactory.getLogger(TournamentRoundResource.class);

    private static final String ENTITY_NAME = "tournamentRound";

    @Value("{TourneyDagger.clientApp.name}")
    private String applicationName;

    private final TournamentRoundRepository tournamentRoundRepository;

    public TournamentRoundResource(TournamentRoundRepository tournamentRoundRepository) {
        this.tournamentRoundRepository = tournamentRoundRepository;
    }


    @PostMapping("/tournament-rounds")
    public ResponseEntity<TournamentRound> createTournamentRound(@RequestBody TournamentRound tournamentRound) throws URISyntaxException {
        log.debug("REST request to save TournamentRound : {}", tournamentRound);
        if (tournamentRound.getId() != null) {
            throw new BadRequestAlertException("A new tournamentRound cannot already have an ID", ENTITY_NAME, "idexists");
        }
        TournamentRound result = tournamentRoundRepository.save(tournamentRound);
        return ResponseEntity.created(new URI("/api/tournament-rounds/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
                .body(result);
    }


    @PutMapping("/tournament-rounds")
    public ResponseEntity<TournamentRound> updateTournamentRound(@RequestBody TournamentRound tournamentRound) throws URISyntaxException {
        log.debug("REST request to update TournamentRound : {}", tournamentRound);
        if (tournamentRound.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        TournamentRound result = tournamentRoundRepository.save(tournamentRound);
        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, tournamentRound.getId().toString()))
                .body(result);
    }


    @GetMapping("/tournament-rounds")
    public List<TournamentRound> getAllTournamentRounds(@RequestParam(required = false, defaultValue = "false") boolean eagerload) {
        log.debug("REST request to get all TournamentRounds");
        return tournamentRoundRepository.findAllWithEagerRelationships();
    }


    @GetMapping("/tournament-rounds/{id}")
    public ResponseEntity<TournamentRound> getTournamentRound(@PathVariable Long id) {
        log.debug("REST request to get TournamentRound : {}", id);
        Optional<TournamentRound> tournamentRound = tournamentRoundRepository.findOneWithEagerRelationships(id);
        return ResponseUtil.wrapOrNotFound(tournamentRound);
    }


    @DeleteMapping("/tournament-rounds/{id}")
    public ResponseEntity<Void> deleteTournamentRound(@PathVariable Long id) {
        log.debug("REST request to delete TournamentRound : {}", id);
        tournamentRoundRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}