package com.veterinaria.demo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "Pacientes") // Nombre de la colección en MongoDB
public class Paciente {

    @Id
    private String id; // _id en MongoDB (ejemplo: 675e2cd4e792142cd1faf64f)
    
    @Field("paciente_id")
    private Integer pacienteId; // paciente_id (ejemplo: 1)
    
    @Field("nombre_mascota")
    private String nombreMascota; // nombre_mascota (ejemplo: "Missy")
    
    @Field("especie")
    private String especie; // especie (ejemplo: "Gato")
    
    @Field("raza")
    private String raza; // raza (ejemplo: "Siames")
    
    @Field("edad_meses")
    private Integer edadMeses; // edad_meses (ejemplo: 36)
    
    @Field("nombre_duenho")
    private String nombreDuenho; // nombre_duenho (ejemplo: "Karla")
    
    @Field("ced_duenho")
    private Integer cedDuenho; // ced_duenho (ejemplo: "11112222")
    
    @Field("telefono_contacto")
    private Integer telefonoContacto; // telefono_contacto (ejemplo: "33338888")

    // Constructor sin parámetros
    public Paciente() {}

    // Constructor con parámetros
    public Paciente(Integer pacienteId, String nombreMascota, String especie, String raza, Integer edadMeses, String nombreDuenho, Integer cedDuenho, Integer telefonoContacto) {
        this.pacienteId = pacienteId;
        this.nombreMascota = nombreMascota;
        this.especie = especie;
        this.raza = raza;
        this.edadMeses = edadMeses;
        this.nombreDuenho = nombreDuenho;
        this.cedDuenho = cedDuenho;
        this.telefonoContacto = telefonoContacto;
    }
}