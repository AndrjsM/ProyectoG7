package com.veterinaria.demo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;


@Data
@Document(collection = "Productos")
public class Producto {
    @Id
    private String id; // _id en MongoDB 675c7c979e787624f5f437bc
    @Field("producto_id")
    private Integer productoId; 
    @Field("nombre")
    private String nombre;
    @Field("tipo")
    private String tipo;
    @Field("precio") 
    private double precio; 
    
    // Constructor
    public Producto() {}
    
    // Si gets y sets por que los genmera el data

    public Producto(Integer productoId, String nombre, String tipo, double precio) {
        this.productoId = productoId;
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
    }
}