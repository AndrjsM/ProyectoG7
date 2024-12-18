package com.veterinaria.demo.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Clientes")
public class Cliente {

    @Id
    private String id; // MongoDB genera automáticamente este id

    @Field("cliente_id")
    private Integer cedula;

    @Field("nombre")
    private String nombre;

    @Field("apellido1")
    private String apellido1;

    @Field("apellido2")
    private String apellido2;

    @Field("correo")
    private String correo;

    @Field("celular")
    private Integer celular;

    @Field("provincia")
    private String provincia;

    @Field("canton")
    private String canton;

    @Field("distrito")
    private String distrito;

    @Field("direccion_exacta")
    private String direccionExacta;

    // Constructor sin parámetros
    public Cliente() {}

    // Constructor con parámetros
    public Cliente(String nombre, String apellido1, String apellido2, String correo,
                   Integer celular, String provincia, String canton, String distrito, String direccionExacta) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.correo = correo;
        this.celular = celular;
        this.provincia = provincia;
        this.canton = canton;
        this.distrito = distrito;
        this.direccionExacta = direccionExacta;
    }
}
