package com.tourneydagger.main.TourneyDagger.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tournament_round")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class TournamentRound implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "round_number")
    private Integer roundNumber;

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JoinTable(name = "tournament_round_games",
            joinColumns = @JoinColumn(name = "tournament_round_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "games_id", referencedColumnName = "id"))
    private Set<Game> games = new HashSet<>();

    @ManyToMany(mappedBy = "tournamentrounds")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnore
    private Set<Tournament> tournaments = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public TournamentRound name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRoundNumber() {
        return roundNumber;
    }

    public TournamentRound roundNumber(Integer roundNumber) {
        this.roundNumber = roundNumber;
        return this;
    }

    public void setRoundNumber(Integer roundNumber) {
        this.roundNumber = roundNumber;
    }

    public Set<Game> getGames() {
        return games;
    }

    public TournamentRound games(Set<Game> games) {
        this.games = games;
        return this;
    }

    public TournamentRound addGames(Game game) {
        this.games.add(game);
        game.getRounds().add(this);
        return this;
    }

    public TournamentRound removeGames(Game game) {
        this.games.remove(game);
        game.getRounds().remove(this);
        return this;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }

    public Set<Tournament> getTournaments() {
        return tournaments;
    }

    public TournamentRound tournaments(Set<Tournament> tournaments) {
        this.tournaments = tournaments;
        return this;
    }

    public TournamentRound addTournament(Tournament tournament) {
        this.tournaments.add(tournament);
        tournament.getTournamentrounds().add(this);
        return this;
    }

    public TournamentRound removeTournament(Tournament tournament) {
        this.tournaments.remove(tournament);
        tournament.getTournamentrounds().remove(this);
        return this;
    }

    public void setTournaments(Set<Tournament> tournaments) {
        this.tournaments = tournaments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TournamentRound)) {
            return false;
        }
        return id != null && id.equals(((TournamentRound) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "TournamentRound{" +
                "id=" + getId() +
                ", name='" + getName() + "'" +
                ", roundNumber=" + getRoundNumber() +
                "}";
    }
    
}
