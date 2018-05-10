package com.doruleanu.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Date;
//import java.util.List;

@Data
@Entity
@Table(name= "factexit")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })


public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    
    @NotNull
    @Column(name = "datafact")
    private Date datafact;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clientid", nullable = false,  referencedColumnName = "id")
    @JsonIgnore
    private Client client;
    
    @NotNull
    @Column(name = "notify")
    private String notify;
    
    @NotNull
    @Column(name = "auto1")
    private String auto1;
    
    @NotNull
    @Column(name = "incarc")
    private String incarc;
    
    @NotNull
    @Column(name = "descarc")
    private String descarc;
    
    @NotNull
    @Column(name = "condlivr")
    private String condlivr;

/*    @OneToMany(cascade = CascadeType.ALL, mappedBy = "factura")
    private List<Export> exports;
*/
    public Factura() {
    }


}