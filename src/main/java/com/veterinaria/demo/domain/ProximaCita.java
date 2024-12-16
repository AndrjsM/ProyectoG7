package com.veterinaria.demo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "Proximas_Citas")
public class ProximaCita {
    @Id
    private String id; // _id en MongoDB 675c7c979e787624f5f437bc
    @Field("prox_cita_id")
    private Integer proximaCitaId; 
    @Field("consulta_id")
    private Integer consultaId;
    @Field("fecha_cita")
    private String fechaCita;
    
    // Constructor
    public ProximaCita() {}
    
    // Si gets y sets por que los genmera el data

    public ProximaCita(Integer proximaCitaId, Integer consultaId, String fechaCita) {
        this.proximaCitaId = proximaCitaId;
        this.consultaId = consultaId;
        this.fechaCita = fechaCita;
    }
}