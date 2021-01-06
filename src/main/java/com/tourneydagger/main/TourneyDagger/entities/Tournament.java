package com.tourneydagger.main.TourneyDagger.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.tourneydagger.main.TourneyDagger.entities.enumeration.TournamentType;

@Entity
@Table(name = "tournament")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Tournament implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

    @Column(name = "date")
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private TournamentType type;

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JoinTable(name = "tournament_tournamentrounds",
            joinColumns = @JoinColumn(name = "tournament_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "tournamentrounds_id", referencedColumnName = "id"))
    private Set<TournamentRound> tournamentrounds = new HashSet<>();

    @OneToMany
    @JsonIgnoreProperties(value = "tournament", allowSetters = true)
    private Set<Player> players;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Tournament name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public Tournament location(String location) {
        this.location = location;
        return this;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getDate() {
        return date;
    }

    public Tournament date(LocalDate date) {
        this.date = date;
        return this;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public TournamentType getType() {
        return type;
    }

    public Tournament type(TournamentType type) {
        this.type = type;
        return this;
    }

    public void setType(TournamentType type) {
        this.type = type;
    }

    public Set<TournamentRound> getTournamentrounds() {
        return tournamentrounds;
    }

    public Tournament tournamentrounds(Set<TournamentRound> tournamentRounds) {
        this.tournamentrounds = tournamentRounds;
        return this;
    }

    public Tournament addTournamentrounds(TournamentRound tournamentRound) {
        this.tournamentrounds.add(tournamentRound);
        tournamentRound.getTournaments().add(this);
        return this;
    }

    public Tournament removeTournamentrounds(TournamentRound tournamentRound) {
        this.tournamentrounds.remove(tournamentRound);
        tournamentRound.getTournaments().remove(this);
        return this;
    }

    public void setTournamentrounds(Set<TournamentRound> tournamentRounds) {
        this.tournamentrounds = tournamentRounds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Tournament)) {
            return false;
        }
        return id != null && id.equals(((Tournament) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Tournament{" +
                "id=" + getId() +
                ", name='" + getName() + "'" +
                ", location='" + getLocation() + "'" +
                ", date='" + getDate() + "'" +
                ", type='" + getType() + "'" +
                "}";
    }


}
