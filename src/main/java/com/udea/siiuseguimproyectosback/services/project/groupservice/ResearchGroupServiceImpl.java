package com.udea.siiuseguimproyectosback.services.project.groupservice;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.udea.siiuseguimproyectosback.domain.dto.project.ResearchGroupDto;
import com.udea.siiuseguimproyectosback.domain.mapper.project.IResearchGroupMapper;
import com.udea.siiuseguimproyectosback.persistence.project.IResearchGroupRepository;

import org.springframework.stereotype.Service;

@Service
public class ResearchGroupServiceImpl implements IResearchGroupService {

	private final IResearchGroupRepository repository;
	
	

//	    @Override
//	    public ResearchGroupDto save(ResearchGroupDto dto) {
//	        ResearchGroup entity = ResearchGroupMapper.toEntity(dto);
//	        return ResearchGroupMapper.toDto(repository.save(entity));
//	    }

	@Override
	public Optional<ResearchGroupDto> findById(Long id, String user) {
		return repository.findById(id).map(IResearchGroupMapper::toDTO)
				.orElseThrow(() -> new RuntimeException("ResearchGroup not found with id: " + id));
	}

	@Override
	public List<ResearchGroupDto> findAll() {
		return repository.findAll().stream().map(IResearchGroupMapper::toDTO).collect(Collectors.toList());
	}
//
//	    @Override
//	    public ResearchGroupDto update(Long id, ResearchGroupDto dto) {
//	        ResearchGroup entity = repository.findById(id)
//	                .orElseThrow(() -> new RuntimeException("ResearchGroup not found with id: " + id));
//	        entity.setFullName(dto.getFullName());
//	        entity.setShortName(dto.getShortName());
//	        entity.setEmail(dto.getEmail());
//	        entity.setPhone(dto.getPhone());
//	        entity.setWebsite(dto.getWebsite());
//	        // Update other fields as needed...
//	        return ResearchGroupMapper.toDto(repository.save(entity));
//	    }
//
//	    @Override
//	    public void delete(Long id) {
//	        repository.deleteById(id);
//	    }
}
