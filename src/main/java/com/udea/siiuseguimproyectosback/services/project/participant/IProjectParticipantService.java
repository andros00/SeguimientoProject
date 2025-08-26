package com.udea.siiuseguimproyectosback.services.project.participant;

import java.util.List;
import java.util.Optional;

import com.udea.siiuseguimproyectosback.domain.dto.project.ProjectParticipantDTO;

public interface IProjectParticipantService {
	
	Optional<List<ProjectParticipantDTO>> findByProjectCode(String projectCode, String documentNumber);

	ProjectParticipantDTO create(ProjectParticipantDTO dto, String documentNumber);

	List<ProjectParticipantDTO> findAll(String documentNumber);
	
	Optional<ProjectParticipantDTO> findById(Long id, String documentNumber);

	Optional<ProjectParticipantDTO> update(Long id, ProjectParticipantDTO dto, String documentNumber);

	boolean delete(Long id, String documentNumber);
}
