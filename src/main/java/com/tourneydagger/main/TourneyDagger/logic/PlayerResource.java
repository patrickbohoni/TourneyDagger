package com.tourneydagger.main.TourneyDagger.logic;

import com.tourneydagger.main.TourneyDagger.entities.Player;
import com.tourneydagger.main.TourneyDagger.repository.PlayerRepository;
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
public class PlayerResource {

    private final Logger log = LoggerFactory.getLogger(PlayerResource.class);

    private static final String ENTITY_NAME = "player";

    @Value("{TourneyDagger.clientApp.name}")
    private String applicationName;

    private final PlayerRepository playerRepository;

    public PlayerResource(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }


    @PostMapping("/players")
    public ResponseEntity<Player> createPlayer(@RequestBody Player player) throws URISyntaxException {
        log.debug("REST request to save Player : {}", player);
        if (player.getId() != null) {
            throw new BadRequestAlertException("A new player cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Player result = playerRepository.save(player);
        return ResponseEntity.created(new URI("/api/players/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
                .body(result);
    }


    @PutMapping("/players")
    public ResponseEntity<Player> updatePlayer(@RequestBody Player player) throws URISyntaxException {
        log.debug("REST request to update Player : {}", player);
        if (player.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Player result = playerRepository.save(player);
        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, player.getId().toString()))
                .body(result);
    }

    @GetMapping("/players")
    public List<Player> getAllPlayers() {
        log.debug("REST request to get all Players");
        return playerRepository.findAll();
    }


    @GetMapping("/players/{id}")
    public ResponseEntity<Player> getPlayer(@PathVariable Long id) {
        log.debug("REST request to get Player : {}", id);
        Optional<Player> player = playerRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(player);
    }

    @DeleteMapping("/players/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Long id) {
        log.debug("REST request to delete Player : {}", id);
        playerRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}