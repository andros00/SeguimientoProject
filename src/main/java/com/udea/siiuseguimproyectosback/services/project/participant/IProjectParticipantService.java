package com.udea.siiuseguimproyectosback.services.project.participant;

import java.util.List;
import java.util.Optional;

import com.udea.siiuseguimproyectosback.domain.dto.project.ProjectParticipantDTO;

public interface IProjectParticipantService {
	Optional<List<ProjectParticipantDTO>> findByProjectCode(String projectCode, String documentNumber);
}
