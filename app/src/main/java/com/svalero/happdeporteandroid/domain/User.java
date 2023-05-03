package com.svalero.happdeporteandroid.domain;

public class User {

    private long id;
    private String username;
    private String pass;
    private String rol;
    private boolean coach;
    private String name;
    private String surname;
    private String address;
    private String mail;
    private String phone;


    /**
     *Constructor para registrar Usuarios
     */
    public User(long id, String username, String pass, String rol, boolean coach, String name, String surname, String address, String mail, String phone) {
        this.id = id;
        this.username = username;
        this.pass = pass;
        this.rol = rol;
        this.coach = coach;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.mail = mail;
        this.phone = phone;
    }

    /**
     *Constructor para modificar Usuarios
     */
    public User(String username, String pass, String rol, boolean coach, String name, String surname, String address, String mail, String phone) {
        this.username = username;
        this.pass = pass;
        this.rol = rol;
        this.coach = coach;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.mail = mail;
        this.phone = phone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public boolean isCoach() {
        return coach;
    }

    public void setCoach(boolean coach) {
        this.coach = coach;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
