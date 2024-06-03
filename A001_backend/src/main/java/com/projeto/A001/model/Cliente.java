package com.projeto.A001.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Cliente")
public class Cliente {    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;   
    private String nome;    
    private String cpf;    
    private String nacionalidade;    
    private String cep;    
    private String rua;    
    private String numero;    
    private String complemento;    
    private String bairro;    
    private String cidade;    
    private String estado;    
    private String telefone;    
    private String email;
}
