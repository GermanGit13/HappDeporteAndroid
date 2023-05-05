package com.svalero.happdeporteandroid.domain;

import java.time.LocalTime;

/**
 * Objeto igual que el de la API
 */
public class Team {

    private long id;
    private String category;
    private String competition;
    private double cuota;
    private String dayTrain;
    private String startTrain;
    private String endTrain;
    private boolean active;
    private User user;

    public Team() {}

    /**
     *Constructor para modificar Equipos
     */
    public Team(long id, String category, String competition, String dayTrain, String startTrain, String endTrain, boolean active, User user) {
        this.id = id;
        this.category = category;
        this.competition = competition;
//        this.cuota = cuota; //la carga la API
        this.dayTrain = dayTrain;
        this.startTrain = startTrain;
        this.endTrain = endTrain;
        this.active = active;
        this.user = user;
    }

    /**
     *Constructor para registrar Equipos sin cuota y con el user por pathVariable
    */
    public Team(String category, String competition, String dayTrain, String startTrain, String endTrain, boolean active) {
        this.category = category;
        this.competition = competition;
//        this.cuota = cuota;
        this.dayTrain = dayTrain;
        this.startTrain = startTrain;
        this.endTrain = endTrain;
        this.active = active;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCompetition() {
        return competition;
    }

    public void setCompetition(String competition) {
        this.competition = competition;
    }

    public double getCuota() {
        return cuota;
    }

    public void setCuota(double cuota) {
        this.cuota = cuota;
    }

    public String getDayTrain() {
        return dayTrain;
    }

    public void setDayTrain(String dayTrain) {
        this.dayTrain = dayTrain;
    }

    public String getStartTrain() {
        return startTrain;
    }

    public void setStartTrain(String startTrain) {
        this.startTrain = startTrain;
    }

    public String getEndTrain() {
        return endTrain;
    }

    public void setEndTrain(String endTrain) {
        this.endTrain = endTrain;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
