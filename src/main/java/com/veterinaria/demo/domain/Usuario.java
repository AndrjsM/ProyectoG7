package com.veterinaria.demo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "Usuarios") // Nombre de la colección en MongoDB
public class Usuario {

    @Id
    private String id; // _id en MongoDB (ejemplo: 6762e612d8de41e5ddb1c058)
    
    @Field("cliente_id")
    private Integer clienteId; // cliente_id (ejemplo: 702240860)
    
    @Field("username")
    private String username; // username (ejemplo: "francisco")
    
    @Field("contrasenha")
    private String contrasenha; // contrasenha (ejemplo: "123")
    
    @Field("roll")
    private String roll; // roll (ejemplo: "USER_ADMIN")

    // Constructor sin parámetros
    public Usuario() {}

    // Constructor con parámetros
    public Usuario(Integer clienteId, String username, String contrasenha, String roll) {
        this.clienteId = clienteId;
        this.username = username;
        this.contrasenha = contrasenha;
        this.roll = roll;
    }
}