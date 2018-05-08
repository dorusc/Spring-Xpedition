package com.doruleanu.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

//import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name= "clienti")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })

public class Client  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    
    @NotNull
    @Column(name = "nume")
    private String nume;
    
    @NotNull
    @Column(name = "tara")
    private String tara;
    
    @NotNull
    @Column(name = "adresa")
    private String adresa;
    
    @NotNull
    @Column(name = "cif")
    private String cif;
    
    @NotNull
    @Column(name = "banca")
    private String banca;
    
    @NotNull
    @Column(name = "cont")
    private String cont;
    
    @Column(name = "contract")
    private String contract;
    
    @Column(name = "condlivr")
    private String condlivr;
    
    @Column(name = "condpl")
    private String condpl;

 /*   @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private List<Factura> facturi;
 */   
    public Client(){}

}

