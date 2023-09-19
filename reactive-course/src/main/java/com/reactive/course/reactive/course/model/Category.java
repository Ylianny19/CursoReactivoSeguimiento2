package com.reactive.course.reactive.course.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;
    private String codigo;
}
