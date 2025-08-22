package com.udea.siiuseguimproyectosback.services.project.iformal;

import java.util.List;
import java.util.Optional;

import com.udea.siiuseguimproyectosback.domain.dto.project.ProjectIFormalDTO;

public interface IProjectIFormalService {
	/**
	 * Creates a new ProjectIFormal.
	 *
	 * @param dto the ProjectIFormalDTO to be created
	 * @return the created ProjectIFormalDTO
	 */
	ProjectIFormalDTO create(ProjectIFormalDTO dto);

	/**
	 * Finds a ProjectIFormal by its id.
	 *
	 * @param id the ID of the ProjectIFormal
	 * @return an Optional containing the ProjectIFormalDTO if found, otherwise
	 *         empty
	 */
	Optional<ProjectIFormalDTO> findById(Long id);

	/**
	 * Retrieves all ProjectIFormal records.
	 *
	 * @return a list of ProjectIFormalDTOs
	 */
	List<ProjectIFormalDTO> findAll();

	/**
	 * Updates an existing ProjectIFormal.
	 *
	 * @param id  the ID of the ProjectIFormal to update
	 * @param dto the ProjectIFormalDTO containing updated information
	 * @return an Optional containing the updated ProjectIFormalDTO if update was
	 *         successful
	 */
	Optional<ProjectIFormalDTO> update(Long id, ProjectIFormalDTO dto);

	/**
	 * Deletes a ProjectIFormal by its id.
	 *
	 * @param id the ID of the ProjectIFormal to delete
	 * @return true if deletion was successful, false otherwise
	 */
	boolean delete(Long id);
}
