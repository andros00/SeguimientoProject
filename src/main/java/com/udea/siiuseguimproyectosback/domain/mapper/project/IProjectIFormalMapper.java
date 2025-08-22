package com.udea.siiuseguimproyectosback.domain.mapper.project;

import com.udea.siiuseguimproyectosback.domain.dto.project.ProjectIFormalDTO;
import com.udea.siiuseguimproyectosback.domain.entity.project.ProjectIFormal;
import com.udea.siiuseguimproyectosback.domain.mapper.IEntityMapper;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IProjectIFormalMapper extends IEntityMapper<ProjectIFormalDTO, ProjectIFormal>{
	
	ProjectIFormalDTO toDTO(ProjectIFormal projectIFormal);
	
	ProjectIFormal toEntity(ProjectIFormalDTO projectIFormalDTO);

}
