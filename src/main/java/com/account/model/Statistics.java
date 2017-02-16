package com.account.model;

import javax.persistence.*;
import java.util.Set;
/**
 * Created by mcgra on 16.02.2017.
 */
@Entity
@Table(name = "statistics")
public class Statistics {
    private Long id;
    private Long win;
    private Long lose;
    private Long draw;
    private Set<Statistics> statistics;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getWin() {
        return win;
    }

    public void setWin(Long win) {
        this.win = win;
    }

    public Long getLose() {
        return lose;
    }

    public void setLose(Long lose) {
        this.lose = lose;
    }

    public Long getDraw() {
        return draw;
    }

    public void setDraw(Long draw) {
        this.draw = draw;
    }

    @ManyToMany
    @JoinTable(name = "user_statistics", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "statistics_id"))
    public Set<Statistics> getStatistics() {
        return statistics;
    }

    public void setStatistics(Set<Statistics> statistics) {
        this.statistics = statistics;
    }
}
