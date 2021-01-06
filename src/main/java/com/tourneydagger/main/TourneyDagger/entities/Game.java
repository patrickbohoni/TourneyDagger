package com.tourneydagger.main.TourneyDagger.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.tourneydagger.main.TourneyDagger.entities.enumeration.Winner;


@Entity
@Table(name = "game")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Game implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "winner")
    private Winner winner;

    @ManyToOne
    @JsonIgnoreProperties(value = "games", allowSetters = true)
    private Player player1;

    @ManyToOne
    @JsonIgnoreProperties(value = "games", allowSetters = true)
    private Player player2;

    @ManyToMany(mappedBy = "games")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnore
    private Set<TournamentRound> rounds = new HashSet<>();

    @OneToOne(mappedBy = "round")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnore
    private TournamentRound singularRound;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Winner getWinner() {
        return winner;
    }

    public Game winner(Winner winner) {
        this.winner = winner;
        return this;
    }

    public void setWinner(Winner winner) {
        this.winner = winner;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Game player1(Player player) {
        this.player1 = player;
        return this;
    }

    public void setPlayer1(Player player) {
        this.player1 = player;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Game player2(Player player) {
        this.player2 = player;
        return this;
    }

    public void setPlayer2(Player player) {
        this.player2 = player;
    }

    public Set<TournamentRound> getRounds() {
        return rounds;
    }

    public Game rounds(Set<TournamentRound> tournamentRounds) {
        this.rounds = tournamentRounds;
        return this;
    }

    public Game addRound(TournamentRound tournamentRound) {
        this.rounds.add(tournamentRound);
        tournamentRound.getGames().add(this);
        return this;
    }

    public Game removeRound(TournamentRound tournamentRound) {
        this.rounds.remove(tournamentRound);
        tournamentRound.getGames().remove(this);
        return this;
    }

    public void setRounds(Set<TournamentRound> tournamentRounds) {
        this.rounds = tournamentRounds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Game)) {
            return false;
        }
        return id != null && id.equals(((Game) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + getId() +
                ", winner='" + getWinner() + "'" +
                "}";
    }

    public void setWinner() {
    }


}
