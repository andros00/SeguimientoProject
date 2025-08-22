package com.udea.siiuseguimproyectosback.services.project.participant;

import java.util.List;
import java.util.Optional;

import com.udea.siiuseguimproyectosback.domain.dto.project.ProjectParticipantDTO;
import com.udea.siiuseguimproyectosback.domain.entity.project.ProjectParticipant;
import com.udea.siiuseguimproyectosback.domain.mapper.project.IProjectParticipantMapper;
import com.udea.siiuseguimproyectosback.persistence.project.IProjectParticipantRepository;

public class ProjectParticipantServiceImpl implements IProjectParticipantService {

	private final IProjectParticipantRepository projectParticipantRepository;
	private final IProjectParticipantMapper participantMapper;

	/**
	 * Constructs an instance of {@link ProjectParticipantServiceImpl}.
	 * <p>
	 * This constructor injects the required dependencies for repository and mapper.
	 * </p>
	 *
	 * @param selectionProcessRepository the repository for selection process data.
	 * @param selectionProcessMapper     the mapper for converting entities to DTOs.
	 */

	public ProjectParticipantServiceImpl(IProjectParticipantRepository projectParticipantRepository,
			IProjectParticipantMapper participantMapper) {
		this.projectParticipantRepository = projectParticipantRepository;
		this.participantMapper = participantMapper;
	}

	@Override
	public Optional<List<ProjectParticipantDTO>> findByProjectCode(String projectCode, String documentNumber) {
		// Validaciones q nos puedan hacer falta
		List<ProjectParticipant> participants = projectParticipantRepository.findByProjectCode(projectCode);
		return participants.isEmpty() ? Optional.empty() : Optional.of(participantMapper.toDTO(participants));
	}

}
