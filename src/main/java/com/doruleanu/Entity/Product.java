package com.doruleanu.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity(name = "Product")
@Table(name = "catalog")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    
    @NotNull
    @Column(name = "prodid")
    private String prodid;
    
    @NotNull
    @Column(name = "denumire")
    private String denumire;
    
    @NotNull
    @Column(name = "um")
    private String um;
    
    @NotNull
    @Column(name = "pretbuc")
    private Integer pretbuc;
    
    @NotNull
    @Column(name = "codv")
    private String codv;
    
    @NotNull
    @Column(name = "pretv")
    private BigDecimal pretv;
    
    @NotNull
    @Column(name = "activ")
    private Boolean activ;
    
    @NotNull
    @Column(name = "weight")
    private BigDecimal weight;

/*    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<Export> exports = new ArrayList<>();
    
    public void addExport(Export export) {
        exports.add(export);
        export.setExport(this);
    }
 
    public void removeExport(Export export) {
        exports.add(export);
        export.setExport(null);
    }
 */
    
    public Product(){
    }

}
