package com.veterinaria.demo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "Inventarios")
public class Inventario {
    @Id
    private String id; // _id en MongoDB 675c7c979e787624f5f437bc
    @Field("inventario_id")
    private Integer inventarioId; 
    @Field("proveedor_id")
    private Integer proveedorId;
    @Field("producto_id")
    private Integer productoId;
    @Field("stock_disponible")
    private Integer stockDisp;
    @Field("stock_minimo")
    private Integer stockMin;
    @Field("fecha_ultima_modificacion")
    private String fechaUltima;
    
    // Constructor
    public Inventario() {}
    
    // Si gets y sets por que los genmera el data

    public Inventario(Integer inventarioId, Integer proveedorId, Integer productoId, Integer stockDisp, Integer stockMin, String fechaUltima) {
        this.inventarioId = inventarioId;
        this.proveedorId = proveedorId;
        this.productoId = productoId;
        this.stockDisp = stockDisp;
        this.stockMin = stockMin;
        this.fechaUltima = fechaUltima;
    }
}