package com.tourneydagger.main.TourneyDagger.logic;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import com.tourneydagger.main.TourneyDagger.entities.Game;
import com.tourneydagger.main.TourneyDagger.logic.errors.BadRequestAlertException;
import com.tourneydagger.main.TourneyDagger.repository.GameRepository;
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
public class GameResource {

    private final Logger log = LoggerFactory.getLogger(GameResource.class);

    private static final String ENTITY_NAME = "game";

    @Value("{TourneyDagger.clientApp.name}")
    private String applicationName;

    private final GameRepository gameRepository;

    public GameResource(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }


    @PostMapping("/games")
    public ResponseEntity<Game> createGame(@RequestBody Game game) throws URISyntaxException {
        log.debug("REST request to save Game : {}", game);
        if (game.getId() != null) {
            throw new BadRequestAlertException("A new game cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Game result = gameRepository.save(game);
        return ResponseEntity.created(new URI("/api/games/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
                .body(result);
    }


    @PutMapping("/games")
    public ResponseEntity<Game> updateGame(@RequestBody Game game) throws URISyntaxException {
        log.debug("REST request to update Game : {}", game);
        if (game.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }

        //TODO
        //        game.getWinner() - aici se poate scrie codul care da puncte la winner
        // un failsafe sa se verifice daca jocul din baza de date sa nu fi avut un winner, atunci sa se faca un undo la punctaj
        //ca un safety net

        Game result = gameRepository.save(game);
        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, game.getId().toString()))
                .body(result);
    }


    @GetMapping("/games")
    public List<Game> getAllGames() {
        log.debug("REST request to get all Games");
        return gameRepository.findAll();
    }



    @GetMapping("/games/{id}")
    public ResponseEntity<Game> getGame(@PathVariable Long id) {
        log.debug("REST request to get Game : {}", id);
        Optional<Game> game = gameRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(game);
    }


    @DeleteMapping("/games/{id}")
    public ResponseEntity<Void> deleteGame(@PathVariable Long id) {
        log.debug("REST request to delete Game : {}", id);
        gameRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }


}
