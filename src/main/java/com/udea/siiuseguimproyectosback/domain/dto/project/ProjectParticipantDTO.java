package com.udea.siiuseguimproyectosback.domain.dto.project;

import lombok.Data;

import java.util.List;

@Data
public class ProjectParticipantDTO {
    private String id;
    private String project;
    private String fullName;
    private String responsible;
    private ProjectParticipantRolDTO projectParticipantRole;
    private Long group;
    private Integer dedicationMonths;
    private Integer dedicationHours;
    private Integer dedicationMonthsPlan;
    private Integer dedicationHoursPlan;
    private Long supportedProgramCode;
    private Double academicProgPercentage;
    private String NOMBRE_PROGRAMA;
    private Double PORCENTAJE_COMPLETADO;
}
