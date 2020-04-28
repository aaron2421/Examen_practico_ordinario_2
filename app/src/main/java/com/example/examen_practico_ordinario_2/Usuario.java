package com.example.examen_practico_ordinario_2;

public class Usuario {
    private String id;
    private String nombre;
    private String username;
    private String apellido;
    private String pass;

    public Usuario(){

    }

    public Usuario(String nombre, String username) {
        this.nombre = nombre;
        this.username = username;
    }

    public Usuario(String id, String nombre, String username, String apellido, String pass) {
        this.id = id;
        this.nombre = nombre;
        this.username = username;
        this.apellido = apellido;
        this.pass = pass;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
