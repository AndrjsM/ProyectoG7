package com.veterinaria.demo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;


@Data
@Document(collection = "Pagos")
public class Pago {
    @Id
    private String id; // _id en MongoDB 675c7c979e787624f5f437bc
    @Field("pago_id")
    private Integer pagoId; 
    @Field("consulta_id")
    private Integer consultaId;
    @Field("subtotal")
    private double subTotal;
    @Field("impuesto") 
    private double impuesto; 
    @Field("total")
    private double total;
    
    // Constructor
    public Pago() {}
    
    // Si gets y sets por que los genmera el data

    public Pago(Integer pagoId, Integer consultaId, double subTotal, double impuesto, double total) {
        this.pagoId = pagoId;
        this.consultaId = consultaId;
        this.subTotal = subTotal;
        this.impuesto = impuesto;
        this.total = total;
    }
}