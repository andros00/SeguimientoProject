package com.udea.siiuseguimproyectosback.services.project.groupservice;

import java.util.List;
import java.util.Optional;

import com.udea.siiuseguimproyectosback.domain.dto.project.ResearchGroupDto;

public interface IResearchGroupService {
//    ResearchGroupDto save(ResearchGroupDto dto);
	Optional<ResearchGroupDto> findById(Long id, String user);

	List<ResearchGroupDto> findAll();
//    ResearchGroupDto update(Long id, ResearchGroupDto dto);
//    void delete(Long id);
}