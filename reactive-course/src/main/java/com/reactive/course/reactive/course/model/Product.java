package com.reactive.course.reactive.course.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.annotation.Id;



@Table(name="product")
@Data
@AllArgsConstructor
public class Product {

    @Id
    private Long id;
    private String nombre;
    private String codigo;
    private String stock;

}
