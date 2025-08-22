package com.udea.siiuseguimproyectosback.controllers.v1.project;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.udea.siiuseguimproyectosback.core.security.user.Session;
import com.udea.siiuseguimproyectosback.domain.dto.project.ProjectParticipantDTO;
import com.udea.siiuseguimproyectosback.domain.dto.user.UserSessionDTO;
import com.udea.siiuseguimproyectosback.services.project.participant.IProjectParticipantService;

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
@RequestMapping("/v1/proyecto/participante")
@Tag(name = "Participant Management", description = "Operations for managing Participant")
public class ProjectParticipantController {

	private final IProjectParticipantService participantService;
	private final Session session;
	private final HttpServletRequest request;

	public ProjectParticipantController(IProjectParticipantService participantService, Session session,
			HttpServletRequest request) {
		this.participantService = participantService;
		this.session = session;
		this.request = request;
	}

	@Operation(summary = "Get participants by project code", description = "Retrieves all participants associated with a given project code", responses = {
			@ApiResponse(responseCode = "200", description = "List of participants retrieved", content = @Content(schema = @Schema(implementation = ProjectParticipantDTO.class))),
			@ApiResponse(responseCode = "204", description = "No participants found for the given project code", content = @Content) })
	@GetMapping("/by-project/{projectCode}")
	public ResponseEntity<List<ProjectParticipantDTO>> getParticipantsByProjectCode(@PathVariable String projectCode) {
		// UserSessionDTO user = session.getCurrentUser(request);
		UserSessionDTO user = new UserSessionDTO();
		user.setDocumentNumber("43731881");

		return participantService.findByProjectCode(projectCode, user.getDocumentNumber()).map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.noContent().build());
	}

//	
//	
//	// CREATE
//	@Operation(summary = "Create a new participant", description = "Registers a new participant for a project", responses = {
//			@ApiResponse(responseCode = "201", description = "Participant created successfully", content = @Content(schema = @Schema(implementation = ProjectParticipantDTO.class))),
//			@ApiResponse(responseCode = "400", description = "Invalid input data", content = @Content) })
//	@PostMapping
//	public ResponseEntity<ProjectParticipantDTO> createParticipant(@RequestBody ProjectParticipantDTO dto) {
//		// UserSessionDTO user = session.getCurrentUser(request);
//		UserSessionDTO user = new UserSessionDTO();
//		user.setDocumentNumber("43731881");
//
//		return Optional.ofNullable(participantService.create(dto, user.getDocumentNumber()))
//				.map(p -> ResponseEntity.status(HttpStatus.CREATED).body(p))
//				.orElseGet(() -> ResponseEntity.badRequest().build());
//	}
//
//	// READ ALL
//	@Operation(summary = "Get all participants", description = "Retrieves all participants associated with the current user", responses = {
//			@ApiResponse(responseCode = "200", description = "List of participants retrieved", content = @Content(schema = @Schema(implementation = ProjectParticipantDTO.class))),
//			@ApiResponse(responseCode = "204", description = "No participants found", content = @Content) })
//	@GetMapping
//	public ResponseEntity<List<ProjectParticipantDTO>> getAllParticipants() {
//		// UserSessionDTO user = session.getCurrentUser(request);
//		UserSessionDTO user = new UserSessionDTO();
//		user.setDocumentNumber("43731881");
//
//		return participantService.findAll(user.getDocumentNumber()).map(ResponseEntity::ok)
//				.orElseGet(() -> ResponseEntity.noContent().build());
//	}
//
//	// READ BY ID
//	@Operation(summary = "Get participant by ID", description = "Retrieves details of a participant by its ID", responses = {
//			@ApiResponse(responseCode = "200", description = "Participant retrieved", content = @Content(schema = @Schema(implementation = ProjectParticipantDTO.class))),
//			@ApiResponse(responseCode = "404", description = "Participant not found", content = @Content) })
//	@GetMapping("/{id}")
//	public ResponseEntity<ProjectParticipantDTO> getParticipantById(@PathVariable Long id) {
//		// UserSessionDTO user = session.getCurrentUser(request);
//		UserSessionDTO user = new UserSessionDTO();
//		user.setDocumentNumber("43731881");
//
//		return participantService.findById(id, user.getDocumentNumber()).map(ResponseEntity::ok)
//				.orElseGet(() -> ResponseEntity.notFound().build());
//	}
//
//	// UPDATE
//	@Operation(summary = "Update a participant", description = "Updates the information of an existing participant", responses = {
//			@ApiResponse(responseCode = "200", description = "Participant updated successfully", content = @Content(schema = @Schema(implementation = ProjectParticipantDTO.class))),
//			@ApiResponse(responseCode = "404", description = "Participant not found", content = @Content) })
//	@PutMapping("/{id}")
//	public ResponseEntity<ProjectParticipantDTO> updateParticipant(@PathVariable Long id,
//			@RequestBody ProjectParticipantDTO dto) {
//		// UserSessionDTO user = session.getCurrentUser(request);
//		UserSessionDTO user = new UserSessionDTO();
//		user.setDocumentNumber("43731881");
//
//		return participantService.update(id, dto, user.getDocumentNumber()).map(ResponseEntity::ok)
//				.orElseGet(() -> ResponseEntity.notFound().build());
//	}
//
//	// DELETE
//	@Operation(summary = "Delete a participant", description = "Deletes a participant by its ID", responses = {
//			@ApiResponse(responseCode = "204", description = "Participant deleted successfully", content = @Content),
//			@ApiResponse(responseCode = "404", description = "Participant not found", content = @Content) })
//	@DeleteMapping("/{id}")
//	public ResponseEntity<Void> deleteParticipant(@PathVariable Long id) {
//		// UserSessionDTO user = session.getCurrentUser(request);
//		UserSessionDTO user = new UserSessionDTO();
//		user.setDocumentNumber("43731881");
//
//		return participantService.delete(id, user.getDocumentNumber()) ? ResponseEntity.noContent().build()
//				: ResponseEntity.notFound().build();
//	}

}
