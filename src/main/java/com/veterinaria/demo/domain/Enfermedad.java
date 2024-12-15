package com.veterinaria.demo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;


@Data
@Document(collection = "Enfermedades")
public class Enfermedad {
    @Id
    private String id; // _id en MongoDB 675c7c979e787624f5f437bc
    @Field("enfermedad_id")
    private Integer enfermedadId; 
    @Field("nombre_comun")
    private String nombreComun;
    @Field("nombre_cientifico")
    private String nombreCientifico;
    @Field("tiene_cura") 
    private String tieneCura; 
    @Field("es_tratable")
    private String esTratable;
    
    // Constructor
    public Enfermedad() {}
    
    // Si gets y sets por que los genmera el data

    public Enfermedad(Integer enfermedadId, String nombreComun, String nombreCientifico, String tieneCura, String esTratable) {
        this.enfermedadId = enfermedadId;
        this.nombreComun = nombreComun;
        this.nombreCientifico = nombreCientifico;
        this.tieneCura = tieneCura;
        this.esTratable = esTratable;
    }
}