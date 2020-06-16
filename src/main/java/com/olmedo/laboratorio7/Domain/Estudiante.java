package com.olmedo.laboratorio7.Domain;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(schema="public",name="estudiante")
public class Estudiante {
    @Id
    @Column(name="c_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigoEstudiante;

    @Column(name="nombre")
    @NotEmpty(message = "El nombre del estudiante no puede estar vacio")
    private String nombre;


    @Column(name="apellido")
    @NotEmpty(message = "El apellido del estudiante no puede estar vacio")
    private String apellido;

    @Column(name = "carne")
    @NotEmpty(message = "El carnet del estudiante no puede estar vacio")
    private String carne;

    @Column(name = "carrera")
    @NotEmpty(message = "La carrera del estudiante no puede estar vacio")
    private String carrera;

    public Estudiante() {
    }

    public Integer getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public void setCodigoEstudiante(Integer codigoEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCarne() {
        return carne;
    }

    public void setCarne(String carne) {
        this.carne = carne;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
}
