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
    private LocalTime startTrain;
    private LocalTime endTrain;
    private boolean active;

}
