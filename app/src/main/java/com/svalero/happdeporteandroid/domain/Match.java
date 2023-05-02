package com.svalero.happdeporteandroid.domain;

import androidx.room.ColumnInfo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Match {


    private long id;
    private String teamB;
    private int markerA;
    private int markerB;
    private String analysis;
    private String location;
    private double latitude; //para poder ubicar en el mapa
    private double longitude; //para poder ubicar en el mapa
    private LocalTime hourMatch;
    private Team teamInMatch;

    /**
     *Constructor para modificar Partidos
     */
    public Match(long id, String teamB, int markerA, int markerB, String analysis, String location, double latitude, double longitude, LocalTime hourMatch, Team teamInMatch) {
        this.id = id;
        this.teamB = teamB;
        this.markerA = markerA;
        this.markerB = markerB;
        this.analysis = analysis;
        this.location = location;
        this.latitude = latitude;
        this.longitude = longitude;
        this.hourMatch = hourMatch;
        this.teamInMatch = teamInMatch;
    }


    /**
     *Constructor para registrar Partidos
     */
    public Match(String teamB, int markerA, int markerB, String analysis, String location, double latitude, double longitude, LocalTime hourMatch, Team teamInMatch) {
        this.teamB = teamB;
        this.markerA = markerA;
        this.markerB = markerB;
        this.analysis = analysis;
        this.location = location;
        this.latitude = latitude;
        this.longitude = longitude;
        this.hourMatch = hourMatch;
        this.teamInMatch = teamInMatch;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTeamB() {
        return teamB;
    }

    public void setTeamB(String teamB) {
        this.teamB = teamB;
    }

    public int getMarkerA() {
        return markerA;
    }

    public void setMarkerA(int markerA) {
        this.markerA = markerA;
    }

    public int getMarkerB() {
        return markerB;
    }

    public void setMarkerB(int markerB) {
        this.markerB = markerB;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public LocalTime getHourMatch() {
        return hourMatch;
    }

    public void setHourMatch(LocalTime hourMatch) {
        this.hourMatch = hourMatch;
    }

    public Team getTeamInMatch() {
        return teamInMatch;
    }

    public void setTeamInMatch(Team teamInMatch) {
        this.teamInMatch = teamInMatch;
    }
}
