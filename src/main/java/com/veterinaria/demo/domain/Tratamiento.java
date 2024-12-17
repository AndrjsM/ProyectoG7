package com.veterinaria.demo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "Tratamientos") // Nombre de la colección en MongoDB
public class Tratamiento {

    @Id
    private String id; // _id en MongoDB (ejemplo: 675e2be0e792142cd1faf624)
    
    @Field("tratamiento_id")
    private Integer tratamientoId; // tratamiento_id (ejemplo: 1)
    
    @Field("consulta_id")
    private Integer consultaId; // consulta_id (ejemplo: 1, referencia a otra colección)
    
    @Field("enfermedad_id")
    private Integer enfermedadId; // enfermedad_id (ejemplo: 1, referencia a otra colección)
    
    @Field("inventario_id")
    private Integer inventarioId; // inventario_id (ejemplo: 1, referencia a otra colección)
    
    @Field("paciente_id")
    private Integer pacienteId; // paciente_id (ejemplo: 1, referencia a otra colección)
    
    @Field("tratamiento_inicia")
    private String tratamientoInicia; // tratamiento_inicia (ejemplo: "08-Dec-24")
    
    @Field("tratamiento_termina")
    private String tratamientoTermina; // tratamiento_termina (ejemplo: "14-Dec-24")
    
    @Field("requiere_renovar")
    private String requiereRenovar; // requiere_renovar (ejemplo: "si")

    // Constructor sin parámetros
    public Tratamiento() {}

    // Constructor con parámetros
    public Tratamiento(Integer tratamientoId, Integer consultaId, Integer enfermedadId, Integer inventarioId,
                       Integer pacienteId, String tratamientoInicia, String tratamientoTermina, String requiereRenovar) {
        this.tratamientoId = tratamientoId;
        this.consultaId = consultaId;
        this.enfermedadId = enfermedadId;
        this.inventarioId = inventarioId;
        this.pacienteId = pacienteId;
        this.tratamientoInicia = tratamientoInicia;
        this.tratamientoTermina = tratamientoTermina;
        this.requiereRenovar = requiereRenovar;
    }
}
