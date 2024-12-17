package com.veterinaria.demo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "Doctores") // Nombre de la colección en MongoDB
public class Doctor {

    @Id
    private String id; // _id en MongoDB (ejemplo: 675e2b93e792142cd1faf613)
    
    @Field("doctor_id")
    private Integer doctorId; // doctor_id (ejemplo: 2)
    
    @Field("nombre")
    private String nombre; // nombre (ejemplo: "Anamaria")
    
    @Field("apellidos")
    private String apellidos; // apellidos (ejemplo: "Ulloa")
    
    @Field("fecha_nacimmiento")
    private String fechaNacimiento; // fecha_nacimmiento (ejemplo: "12-21-1991")
    
    @Field("no_colegiado")
    private Integer noColegiado; // no_colegiado (ejemplo: 88524)
    
    @Field("anho_incorporacion")
    private Integer anhoIncorporacion; // anho_incorporacion (ejemplo: 2019)

    // Constructor sin parámetros
    public Doctor() {}

    // Constructor con parámetros
    public Doctor(Integer doctorId, String nombre, String apellidos, String fechaNacimiento, Integer noColegiado, Integer anhoIncorporacion) {
        this.doctorId = doctorId;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.noColegiado = noColegiado;
        this.anhoIncorporacion = anhoIncorporacion;
    }

}
