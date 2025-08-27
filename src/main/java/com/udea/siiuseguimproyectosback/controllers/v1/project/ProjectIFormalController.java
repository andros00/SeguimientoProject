package com.udea.siiuseguimproyectosback.controllers.v1.project;

import java.util.List;

import com.udea.siiuseguimproyectosback.domain.dto.project.ProjectIFormalDTO;
import com.udea.siiuseguimproyectosback.services.project.iformal.IProjectIFormalService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/v1/proyecto/inicio-formal")
@Tag(name = "Project IFormal Management", description = "CRUD operations for Project IFormal")
public class ProjectIFormalController {

	private final IProjectIFormalService iFormalService;

	public ProjectIFormalController(IProjectIFormalService iFormalService) {
		this.iFormalService = iFormalService;
	}

	@Operation(summary = "Create a new project formal")
	@ApiResponse(responseCode = "201", description = "Project formal created")
	@PostMapping
	public ResponseEntity<ProjectIFormalDTO> create(@RequestBody ProjectIFormalDTO iFormal) {
		ProjectIFormalDTO created = iFormalService.create(iFormal);
		return ResponseEntity.status(HttpStatus.CREATED).body(created);
	}

	@Operation(summary = "Get all project formal")
	@ApiResponse(responseCode = "200", description = "List of project formal retrieved")
	@GetMapping
	public ResponseEntity<List<ProjectIFormalDTO>> findAll() {
		List<ProjectIFormalDTO> iFormals = iFormalService.findAll();
		return iFormals.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(iFormals);
	}

	@Operation(summary = "Get project iformal by ID")
	@ApiResponse(responseCode = "200", description = "Project iformal found")
	@GetMapping("/{id}")
	public ResponseEntity<ProjectIFormalDTO> findById(@PathVariable Long id) {
		return iFormalService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@Operation(summary = "Update a project iformal")
	@ApiResponse(responseCode = "200", description = "Project iformal updated")
	@PutMapping("/{id}")
	public ResponseEntity<ProjectIFormalDTO> update(@PathVariable Long id, @RequestBody ProjectIFormalDTO iFormal) {
		return iFormalService.update(id, iFormal).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@Operation(summary = "Delete a project iformal by ID")
	@ApiResponse(responseCode = "204", description = "Project iformal deleted")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		return iFormalService.delete(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
	}
	
    @GetMapping("/code/{projectCode}")
    public ResponseEntity<ProjectIFormalDTO> getByProjectCode(@PathVariable String projectCode) {
       return  iFormalService.findByProjectCode(projectCode).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
