package com.udea.siiuseguimproyectosback.controllers.v1.project;

import java.util.List;

import com.udea.siiuseguimproyectosback.domain.dto.project.ResearchGroupDto;
import com.udea.siiuseguimproyectosback.domain.dto.user.UserSessionDTO;
import com.udea.siiuseguimproyectosback.services.project.groupservice.IResearchGroupService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/v1/proyecto/grupo-investigacion")
@Tag(name = "ResearchGroup Management", description = "Operations for managing ResearchGroup")
public class ResearchGroupController {

	private final IResearchGroupService service;

	public ResearchGroupController(IResearchGroupService service) {
		this.service = service;
	}

//	@PostMapping
//    public ResearchGroupDto create(@RequestBody ResearchGroupDto dto) {
//        return service.save(dto);
//    }

	@GetMapping("/{id}")
	public ResponseEntity<ResearchGroupDto> getById(@PathVariable Long id) {
		// UserSessionDTO user = session.getCurrentUser(request);
		UserSessionDTO user = new UserSessionDTO();
		user.setDocumentNumber("43731881");

		return service.findById(id, user.getDocumentNumber()).map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.noContent().build());
	}

	@GetMapping
	public ResponseEntity<List<ResearchGroupDto>> getAll() {
		// UserSessionDTO user = session.getCurrentUser(request);
		UserSessionDTO user = new UserSessionDTO();
		user.setDocumentNumber("43731881");
		return ResponseEntity.ok(service.findAll());
	}

//    @PutMapping("/{id}")
//    public ResearchGroupDto update(@PathVariable Long id, @RequestBody ResearchGroupDto dto) {
//        return service.update(id, dto);
//    }
//
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable Long id) {
//        service.delete(id);
//    }

}