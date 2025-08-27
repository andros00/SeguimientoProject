package com.udea.siiuseguimproyectosback.persistence.project;

import java.util.Optional;

import com.udea.siiuseguimproyectosback.domain.entity.project.ProjectIFormal;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IProjectIFormalRepository extends JpaRepository<ProjectIFormal, Long> {

	Optional<ProjectIFormal> findByProjectCode(String projectCode);
}
