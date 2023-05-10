package com.svalero.happdeporteandroid.domain;

import java.time.LocalDate;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public User getUserInPlayer() {
        return userInPlayer;
    }

    public void setUserInPlayer(User userInPlayer) {
        this.userInPlayer = userInPlayer;
    }
}
