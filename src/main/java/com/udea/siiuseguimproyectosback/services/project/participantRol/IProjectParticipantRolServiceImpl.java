package com.udea.siiuseguimproyectosback.services.project.participantRol;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.udea.siiuseguimproyectosback.domain.dto.project.ProjectParticipantRolDTO;
import com.udea.siiuseguimproyectosback.domain.mapper.project.IProjectParticipantRolMapper;
import com.udea.siiuseguimproyectosback.persistence.project.IProjectParticipantRolRespository;

import org.springframework.stereotype.Service;

@Service
public class IProjectParticipantRolServiceImpl implements IProjectParticipantRolService {

	private final IProjectParticipantRolRespository projectParticipantRolRepository;
	private final IProjectParticipantRolMapper participantRolMapper;

	public IProjectParticipantRolServiceImpl(IProjectParticipantRolRespository projectParticipantRolRepository,
			IProjectParticipantRolMapper participantRolMapper) {
		super();
		this.projectParticipantRolRepository = projectParticipantRolRepository;
		this.participantRolMapper = participantRolMapper;
	}

	@Override
	public List<ProjectParticipantRolDTO> findAll(String user) {
		return projectParticipantRolRepository.findAll().stream().map(participantRolMapper::toDTO)
				.collect(Collectors.toList());
	}

	@Override
	public Optional<ProjectParticipantRolDTO> findById(Long id, String user) {
		return projectParticipantRolRepository.findById(id).map(participantRolMapper::toDTO);
	}

}
