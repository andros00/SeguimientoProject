package com.udea.siiuseguimproyectosback.services.project.participantRol;

import java.util.List;
import java.util.Optional;

import com.udea.siiuseguimproyectosback.domain.dto.project.ProjectParticipantRolDTO;

public interface IProjectParticipantRolService {

	List<ProjectParticipantRolDTO> findAll(String user);

	Optional<ProjectParticipantRolDTO> findById(Long id, String user);

}
