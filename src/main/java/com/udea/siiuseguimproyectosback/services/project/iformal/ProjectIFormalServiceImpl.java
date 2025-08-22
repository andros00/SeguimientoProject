package com.udea.siiuseguimproyectosback.services.project.iformal;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import com.udea.siiuseguimproyectosback.domain.dto.project.ProjectIFormalDTO;
import com.udea.siiuseguimproyectosback.domain.entity.project.ProjectIFormal;
import com.udea.siiuseguimproyectosback.domain.mapper.project.IProjectIFormalMapper;
import com.udea.siiuseguimproyectosback.persistence.project.IProjectIFormalRepository;

import org.springframework.stereotype.Service;

@Service
public class ProjectIFormalServiceImpl implements IProjectIFormalService {

	private final IProjectIFormalRepository repository;
	private final IProjectIFormalMapper mapper;

	public ProjectIFormalServiceImpl(IProjectIFormalRepository repository, IProjectIFormalMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public ProjectIFormalDTO create(ProjectIFormalDTO dto) {
		ProjectIFormal entity = mapper.toEntity(dto);
		entity.setDateCreate(new Timestamp(System.currentTimeMillis()));
		ProjectIFormal saved = repository.save(entity);
		return mapper.toDTO(saved);
	}

	@Override
	public Optional<ProjectIFormalDTO> findById(Long id) {
		return repository.findById(id).map(mapper::toDTO); // 🔹 Devuelve DTO
	}

	@Override
	public List<ProjectIFormalDTO> findAll() {
		return repository.findAll().stream().map(mapper::toDTO).toList(); // 🔹 Devuelve lista de DTOs
	}

	@Override
	public Optional<ProjectIFormalDTO> update(Long id, ProjectIFormalDTO dto) {
		return repository.findById(id).map(existing -> {
			ProjectIFormal entity = mapper.toEntity(dto);
			entity.setId(existing.getId());
			entity.setDateModify(new Timestamp(System.currentTimeMillis()));
			ProjectIFormal updated = repository.save(entity);
			return mapper.toDTO(updated);
		});
	}

	@Override
	public boolean delete(Long id) {
		return repository.findById(id).map(existing -> {
			repository.delete(existing);
			return true;
		}).orElse(false);
	}
}
