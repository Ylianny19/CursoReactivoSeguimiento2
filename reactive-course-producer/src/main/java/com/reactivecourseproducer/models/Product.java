package com.reactivecourseproducer.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private Integer id;
    private String nombre;

    private String codigo;

    private String stock;

    @Override
    public String toString() {
        return "{" +
                "'id':" + id +
                ", 'nombre':'" + nombre + '\'' +
                ", 'codigo':'" + codigo + '\'' +
                ", 'stock':'" + stock + '\'' +
                '}';
    }
}
