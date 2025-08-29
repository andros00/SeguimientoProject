package com.udea.siiuseguimproyectosback.domain.mapper.project;

import com.udea.siiuseguimproyectosback.domain.dto.project.ResearchGroupDto;
import com.udea.siiuseguimproyectosback.domain.entity.project.ResearchGroup;
import com.udea.siiuseguimproyectosback.domain.mapper.IEntityMapper;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IResearchGroupMapper extends IEntityMapper<ResearchGroupDto, ResearchGroup> {

}
