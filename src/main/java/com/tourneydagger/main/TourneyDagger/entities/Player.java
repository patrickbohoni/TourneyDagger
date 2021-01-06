package com.tourneydagger.main.TourneyDagger.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "player")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Player implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "points")
    private Integer points;

    @Column(name = "ranking")
    private Integer ranking;

    @Column(name = "w_lr")
    private String wLR;

//    @ManyToOne - asta dupa ce implementam userii
//    @JsonIgnoreProperties(value = "players", allowSetters = true)
//    private User user;

    @ManyToOne
    @JsonIgnoreProperties(value = "players", allowSetters = true)
    private Tournament tournament;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPoints() {
        return points;
    }

    public Player points(Integer points) {
        this.points = points;
        return this;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getRanking() {
        return ranking;
    }

    public Player ranking(Integer ranking) {
        this.ranking = ranking;
        return this;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public String getwLR() {
        return wLR;
    }

    public Player wLR(String wLR) {
        this.wLR = wLR;
        return this;
    }

    public void setwLR(String wLR) {
        this.wLR = wLR;
    }

//    public User getUser() {
//        return user;
//    }

//    public Player user(User user) {
//        this.user = user;
//        return this;
//    }

//    public void setUser(User user) {
//        this.user = user;
//    }

    public Tournament getTournament() {
        return tournament;
    }

    public Player tournament(Tournament tournament) {
        this.tournament = tournament;
        return this;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Player)) {
            return false;
        }
        return id != null && id.equals(((Player) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + getId() +
                ", points=" + getPoints() +
                ", ranking=" + getRanking() +
                ", wLR='" + getwLR() + "'" +
                "}";
    }

}
