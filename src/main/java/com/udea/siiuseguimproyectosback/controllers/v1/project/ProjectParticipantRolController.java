package com.udea.siiuseguimproyectosback.controllers.v1.project;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.udea.siiuseguimproyectosback.core.security.user.Session;
import com.udea.siiuseguimproyectosback.domain.dto.project.ProjectParticipantDTO;
import com.udea.siiuseguimproyectosback.domain.dto.project.ProjectParticipantRolDTO;
import com.udea.siiuseguimproyectosback.domain.dto.user.UserSessionDTO;
import com.udea.siiuseguimproyectosback.services.project.participant.IProjectParticipantService;
import com.udea.siiuseguimproyectosback.services.project.participantRol.IProjectParticipantRolService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/v1/proyecto/participante/rol")
@Tag(name = "Participant Role Management", description = "Operations for managing Participant role")
public class ProjectParticipantRolController {

	private final IProjectParticipantRolService participantRolService;
	private final Session session;
	private final HttpServletRequest request;

	public ProjectParticipantRolController(IProjectParticipantRolService participantRolService, Session session,
			HttpServletRequest request) {
		this.participantRolService = participantRolService;
		this.session = session;
		this.request = request;
	}

	@Operation(summary = "Get all roles", description = "Retrieves all roles associated with the current user", responses = {
			@ApiResponse(responseCode = "200", description = "List of roles retrieved", content = @Content(schema = @Schema(implementation = ProjectParticipantDTO.class))),
			@ApiResponse(responseCode = "204", description = "No roles found", content = @Content) })
	@GetMapping
	public ResponseEntity<List<ProjectParticipantRolDTO>> getAllParticipantRoles() {
		// UserSessionDTO user = session.getCurrentUser(request);
		UserSessionDTO user = new UserSessionDTO();
		user.setDocumentNumber("43731881");

		return ResponseEntity.ok(participantRolService.findAll(user.getDocumentNumber()));
	}

	@Operation(summary = "Get roles by ID", description = "Retrieves details of a roles by its ID", responses = {
			@ApiResponse(responseCode = "200", description = "roles retrieved", content = @Content(schema = @Schema(implementation = ProjectParticipantDTO.class))),
			@ApiResponse(responseCode = "404", description = "roles not found", content = @Content) })
	@GetMapping("/{id}")
	public ResponseEntity<ProjectParticipantRolDTO> getParticipantById(@PathVariable Long id) {
		// UserSessionDTO user = session.getCurrentUser(request);
		UserSessionDTO user = new UserSessionDTO();
		user.setDocumentNumber("43731881");

		return participantRolService.findById(id, user.getDocumentNumber()).map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

}
