package com.doruleanu.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.math.BigDecimal;


@Data
@Entity
@Table(name= "export")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })

public class Export  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "factid", nullable = false, referencedColumnName = "id")
    @JsonIgnore
    private Factura factura;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pr", nullable = false, referencedColumnName = "id")
    @JsonIgnore
    private Product product;
    
    @NotNull
    @Column(name = "cant")
    private BigDecimal cant;
    
    @NotNull
    @Column(name = "valuni")
    private BigDecimal valuni;
    
    @NotNull
    @Column(name = "weight")
    private BigDecimal weight;
    

    public Export() {
        }


}