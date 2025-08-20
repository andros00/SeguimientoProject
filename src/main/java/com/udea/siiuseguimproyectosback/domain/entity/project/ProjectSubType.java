package com.udea.siiuseguimproyectosback.domain.entity.project;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "SIIU_SUBTIPO_PROYECTO")
public class ProjectSubType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDENTIFICADOR", nullable = false, updatable = false)
    private Long id;

    
    @Size(max = 200)
    @Column(name = "NOMBRE", nullable = false, length = 200)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "TIPO_PROYECTO", referencedColumnName = "IDENTIFICADOR", nullable = true)
    private ProjectType projectType;

    @Column(name = "DESCRIPCION")
    private String description;

    
    @Column(name = "INICIO_VIGENCIA")
    private Date startDate;

    @Column(name = "FIN_VIGENCIA")
    private Date endDate;

    
    @Size(max = 16)
    @Column(name = "REGISTRADOR", nullable = false, length = 16)
    private String recorder;

    
    @Size(max = 2)
    @Column(name = "SELECTOR_REGISTRADOR", nullable = false, length = 2)
    private String recorderSelector;

    
    @Column(name = "FECHA_ULTIMO_CAMBIO")
    private Date lastChangeDate;
}
