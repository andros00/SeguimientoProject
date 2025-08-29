package com.udea.siiuseguimproyectosback.domain.dto.project;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResearchGroupDto {
	private Long id;
	private String fullName;
	private String shortName;
	private String colcienciasCode;
	private Integer researchArea;
	private String physicalLocation;
	private String siteLocation;
	private String phone;
	private String email;
	private String website;
	private String status;
	private String type;
	private String colcienciasClassification;
	private Integer creationYear;
	private String generalObjective;
	private String mission;
	private String fax;
	private Integer knowledgeArea;
	private Integer linkedEntitiesNumber;
	private Integer endorsedEntitiesNumber;
	private Integer reportedYearQuarter;
	private Integer reportedQuarter;
	private String groupId;
	private Integer corporationYsiu;
	private String associatedToSiu;
	private Integer mainOds;
	private Long oecdArea;
	private Long oecdSubarea;
}
