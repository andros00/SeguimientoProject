package com.udea.siiuseguimproyectosback.persistence.project;

import java.util.List;

import com.udea.siiuseguimproyectosback.domain.entity.project.ProjectParticipant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IProjectParticipantRepository extends JpaRepository<ProjectParticipant, Long> {

	@Query(value = "SELECT * FROM SIIU_PARTICIPANTE_PROYECTO p WHERE p.PROYECTO = :projectCode",nativeQuery = true)
	List<ProjectParticipant> findByProjectCode(@Param("projectCode") String projectCode);
}
