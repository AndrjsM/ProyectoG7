package com.veterinaria.demo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;


@Data
@Document(collection = "Proveedores")
public class Proveedor {
    @Id
    private String id; // _id en MongoDB 675c7c979e787624f5f437bc
    @Field("proveedor_id")
    private Integer proveedorId; // proveedor_id 1
    @Field("nombre_comercial")
    private String nombreComercial; // nombre_comercial Albet
    @Field("ced_juridica")
    private String cedJuridica; // ced_juridica 310111111
    private String direccion; // direccion SJ
    private String telefono; // telefono 22223333
    private String representante; // representante Andy Blanco
    @Field("correo_rep")
    private String correoRep; // correo_rep ablanco@albetcr.com
    
    // Constructor
    public Proveedor() {}
    
    // Si gets y sets por que los genmera el data

    public Proveedor(Integer proveedorId, String nombreComercial, String cedJuridica, String direccion, String telefono, String representante, String correoRep) {
        this.proveedorId = proveedorId;
        this.nombreComercial = nombreComercial;
        this.cedJuridica = cedJuridica;
        this.direccion = direccion;
        this.telefono = telefono;
        this.representante = representante;
        this.correoRep = correoRep;
    }
}