package com.veterinaria.demo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;  // Importamos la clase Date

@Data
@Document(collection = "Doctores")
public class Doctor {
    
    @Id
    private String id; // _id en MongoDB (ejemplo: 675e2b93e792142cd1faf612)
    
    @Field("doctor_id")
    private Integer doctorId; // doctor_id (ejemplo: 1)
    
    private String nombre; // nombre (ejemplo: Manuel)
    private String apellidos; // apellidos (ejemplo: Bedoya)
    
    @Field("fecha_nacimiento")
    private String fechaNacimiento; // fecha_nacimiento (ejemplo: "12-05-89")
    
    private Date fechaNacimientoFormateada; // fechaNacimiento convertido a Date (ejemplo: Date tipo)
    
    @Field("no_colegiado")
    private Integer noColegiado; // no_colegiado (ejemplo: 85209)
    
    @Field("anho_incorporacion")
    private Integer anhoIncorporacion; // anho_incorporacion (ejemplo: 2015)

    // Constructor
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

    // Getters y Setters
    public Date getFechaNacimientoFormateada() {
        return fechaNacimientoFormateada;
    }

    public void setFechaNacimientoFormateada(Date fechaNacimientoFormateada) {
        this.fechaNacimientoFormateada = fechaNacimientoFormateada;
    }
}
