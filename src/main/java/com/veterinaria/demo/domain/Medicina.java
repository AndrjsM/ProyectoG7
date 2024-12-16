package com.veterinaria.demo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "Medicinas") // Nombre de la colección en MongoDB
public class Medicina {
    
    @Id
    private String id; // _id en MongoDB (ejemplo: 675e2b93e792142cd1faf612)
    
    @Field("medicina_id")
    private Integer medicinaId; // medicina_id (ejemplo: 1)
    
    @Field("nombre_comercial")
    private String nombreComercial; // nombre_comercial (ejemplo: "Amoxicilina")
    
    @Field("nombre_compuesto")
    private String nombreCompuesto; // nombre_compuesto (ejemplo: "Amoxicilina")
    
    @Field("casa_farma")
    private String casaFarma; // casa_farma (ejemplo: "Calox")
    
    @Field("requiere_prescripcion")
    private String requierePrescripcion; // requiere_prescripcion (ejemplo: "si")
    
    private String aplicacion; // aplicación (ejemplo: "oral")

    // Constructor sin parámetros
    public Medicina() {}

    // Constructor con parámetros
    public Medicina(Integer medicinaId, String nombreComercial, String nombreCompuesto, String casaFarma, String requierePrescripcion, String aplicacion) {
        this.medicinaId = medicinaId;
        this.nombreComercial = nombreComercial;
        this.nombreCompuesto = nombreCompuesto;
        this.casaFarma = casaFarma;
        this.requierePrescripcion = requierePrescripcion;
        this.aplicacion = aplicacion;
    }

}
