package com.udea.siiuseguimproyectosback.domain.dto.project;

import java.sql.Timestamp;
import java.util.Date;

import lombok.Data;

@Data
public class ProjectIFormalDTO {

	private Long id;
	private String projectCode;
	private Long duration;
	private Timestamp startDate;
	private Timestamp endDate;
	private String notifiedIf;
	private String notifiedFf;
	private String notifiedPa;
	private String notifiedAr;
	private Timestamp notifiedDatePe;
	private Timestamp notifiedDateTe;
	private String userCreate;
	private Timestamp dateCreate;
	private String userModify;
	private Timestamp dateModify;
	private String internalCode;
	private String status;
	private String approvalCode;
	private Date approvalDate;
}
