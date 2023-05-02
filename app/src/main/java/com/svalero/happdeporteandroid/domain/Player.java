package com.svalero.happdeporteandroid.domain;

import java.time.LocalDate;
import java.util.List;

public class Player {

    private long id;
    private String name;
    private String surname;
    private String dni;
    private LocalDate birthDate;
    private String allergy;
    private int dorsal;
    private char sex;
    private boolean active;
    private User userInPlayer;

    /**
     *Constructor para modificar Jugadores
     */
    public Player(long id, String name, String surname, String dni, LocalDate birthDate, String allergy, int dorsal, char sex, boolean active, User userInPlayer) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dni = dni;
        this.birthDate = birthDate;
        this.allergy = allergy;
        this.dorsal = dorsal;
        this.sex = sex;
        this.active = active;
        this.userInPlayer = userInPlayer;
    }

    /**
     *Constructor para registrar Jugadores
     */
    public Player(String name, String surname, String dni, LocalDate birthDate, String allergy, int dorsal, char sex, boolean active, User userInPlayer) {
        this.name = name;
        this.surname = surname;
        this.dni = dni;
        this.birthDate = birthDate;
        this.allergy = allergy;
        this.dorsal = dorsal;
        this.sex = sex;
        this.active = active;
        this.userInPlayer = userInPlayer;
    }
}
