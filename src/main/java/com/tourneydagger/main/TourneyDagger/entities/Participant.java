package com.tourneydagger.main.TourneyDagger.entities;


import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "participant")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Participant implements Serializable{

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

    //TODO: aici vin relatiile

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Participant name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPoints() {
        return points;
    }

    public Participant points (Integer points) {
        this.points = points;
        return this;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getRanking() {
        return ranking;
    }

    public Participant ranking(Integer ranking) {
        this.ranking = ranking;
        return this;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public String getwLR() {
        return wLR;
    }

    public Participant wLR(String wLR) {
        this.wLR = wLR;
        return this;
    }

    public void setwLR(String wLR) {
        this.wLR = wLR;
    }

    //TODO: aici vin metodele cu care le legi de relatii

    @Override
    public String toString() {
        return "Participant{" +
                "id=" + getId() +
                ", name='" + getName() + "'" +
                ", points=" + getPoints() +
                ", ranking=" + getRanking() +
                ", wLR='" + getwLR() + "'" +
                "}";
    }

}
