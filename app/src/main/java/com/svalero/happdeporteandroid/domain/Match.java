package com.svalero.happdeporteandroid.domain;

import java.time.LocalTime;

public class Match {

    private long id;
    private String teamB;
    private int markerA;
    private int markerB;
    private String analysis;
    private double latitude; //para poder ubicar en el mapa
    private double longitude; //para poder ubicar en el mapa
    private String dateMatch;
    private String hourMatch;
    private Team teamInMatch;

    /**
     *Constructor para modificar Partidos
     */
    public Match(long id, String teamB, int markerA, int markerB, String analysis, double latitude, double longitude, String dateMatch, String hourMatch, Team teamInMatch) {
        this.id = id;
        this.teamB = teamB;
        this.markerA = markerA;
        this.markerB = markerB;
        this.analysis = analysis;
        this.latitude = latitude;
        this.longitude = longitude;
        this.dateMatch = dateMatch;
        this.hourMatch = hourMatch;
        this.teamInMatch = teamInMatch;
    }

    /**
     *Constructor para registrar Partidos por id en la URL de la API
     */
    public Match(String teamB, int markerA, int markerB, String analysis, double latitude, double longitude, String dateMatch, String hourMatch) {
        this.teamB = teamB;
        this.markerA = markerA;
        this.markerB = markerB;
        this.analysis = analysis;
        this.latitude = latitude;
        this.longitude = longitude;
        this.dateMatch = dateMatch;
        this.hourMatch = hourMatch;
    }

    /**
     *Constructor para modificar Partidos
     */
    public Match(String teamB, int markerA, int markerB, String analysis, double latitude, double longitude, String dateMatch, String hourMatch, Team teamInMatch) {
        this.teamB = teamB;
        this.markerA = markerA;
        this.markerB = markerB;
        this.analysis = analysis;
        this.latitude = latitude;
        this.longitude = longitude;
        this.dateMatch = dateMatch;
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

    public String getDateMatch() {
        return dateMatch;
    }

    public void setDateMatch(String dateMatch) {
        this.dateMatch = dateMatch;
    }

    public String getHourMatch() {
        return hourMatch;
    }

    public void setHourMatch(String hourMatch) {
        this.hourMatch = hourMatch;
    }

    public Team getTeamInMatch() {
        return teamInMatch;
    }

    public void setTeamInMatch(Team teamInMatch) {
        this.teamInMatch = teamInMatch;
    }
}
