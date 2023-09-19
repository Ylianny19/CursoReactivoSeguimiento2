package com.reactive.course.reactive.course.model;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String telefono;

    private String direccion;

}
