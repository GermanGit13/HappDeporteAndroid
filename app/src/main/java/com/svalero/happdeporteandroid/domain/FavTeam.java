package com.svalero.happdeporteandroid.domain;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class FavTeam {

    @PrimaryKey
    private long id;
    @ColumnInfo
    private String category;
    @ColumnInfo
    private String competition;
    @ColumnInfo
    private double cuota;
    @ColumnInfo
    private String dayTrain;
    @ColumnInfo
    private String startTrain;
    @ColumnInfo
    private String endTrain;
    @ColumnInfo
    private boolean active;
//    @ColumnInfo
//    private User user;

    public FavTeam (){

    }

    public FavTeam(long id, String category, String competition, double cuota, String dayTrain, String startTrain, String endTrain, boolean active) {
        this.id = id;
        this.category = category;
        this.competition = competition;
        this.cuota = cuota;
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
}
