package com.udea.siiuseguimproyectosback.services.project.participant;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.udea.siiuseguimproyectosback.domain.dto.project.ProjectParticipantDTO;
import com.udea.siiuseguimproyectosback.domain.dto.project.VinculoEstudianteDTO;
import com.udea.siiuseguimproyectosback.domain.entity.project.ProjectIFormal;
import com.udea.siiuseguimproyectosback.domain.entity.project.ProjectParticipant;
import com.udea.siiuseguimproyectosback.domain.mapper.project.IProjectParticipantMapper;
import com.udea.siiuseguimproyectosback.persistence.project.IProjectParticipantRepository;
import com.udea.siiuseguimproyectosback.persistence.project.ProcedureVinculoEstudianteRepository;

@Service
public class ProjectParticipantServiceImpl implements IProjectParticipantService {

	private final IProjectParticipantRepository projectParticipantRepository;
	private final IProjectParticipantMapper participantMapper;
	private final ProcedureVinculoEstudianteRepository procedureRepository;

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
			IProjectParticipantMapper participantMapper, ProcedureVinculoEstudianteRepository procedureRepository) {
		this.projectParticipantRepository = projectParticipantRepository;
		this.participantMapper = participantMapper;
		this.procedureRepository = procedureRepository;
	}

	@Override
	public Optional<List<ProjectParticipantDTO>> findByProjectCode(String projectCode, String documentNumber) {
		// Validaciones q nos puedan hacer falta
		List<ProjectParticipant> participants = projectParticipantRepository.findByProjectCode(projectCode);

		participants.stream().forEach(participant -> {

			VinculoEstudianteDTO vinculo = procedureRepository
					.leerVinculoEstudiante(participant.getResponsible().getId());

			participant.setPORCENTAJE_COMPLETADO(vinculo.getPorcentajeCompletado());
			participant.setNOMBRE_PROGRAMA(vinculo.getNombrePrograma());

		});

		return participants.isEmpty() ? Optional.empty() : Optional.of(participantMapper.toDTO(participants));
	}

	@Override
	public ProjectParticipantDTO create(ProjectParticipantDTO dto, String documentNumber) {
		return participantMapper.toDTO(projectParticipantRepository.save(participantMapper.toEntity(dto)));
	}

	@Override
	public List<ProjectParticipantDTO> findAll(String documentNumber) {
		return projectParticipantRepository.findAll().stream().map(participantMapper::toDTO)
				.collect(Collectors.toList());
	}

	@Override
	public Optional<ProjectParticipantDTO> findById(Long id, String documentNumber) {
		return projectParticipantRepository.findById(id).map(participantMapper::toDTO);
	}

	@Override
	public Optional<ProjectParticipantDTO> update(Long id, ProjectParticipantDTO dto, String documentNumber) {
		return projectParticipantRepository.findById(id).map(existing -> {
			ProjectParticipant entity = participantMapper.toEntity(dto);
			entity.setId(existing.getId());
			entity.setDateModify(new Timestamp(System.currentTimeMillis()));
			ProjectParticipant updated = projectParticipantRepository.save(entity);
			return participantMapper.toDTO(updated);
		});
	}

	@Override
	public boolean delete(Long id, String documentNumber) {
		return projectParticipantRepository.findById(id).map(existing -> {
			projectParticipantRepository.delete(existing);
			return true;
		}).orElse(false);
	}

}
