package com.udea.siiuseguimproyectosback.persistence.project;

import com.udea.siiuseguimproyectosback.domain.entity.project.ResearchGroup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IResearchGroupRepository extends JpaRepository<ResearchGroup, Long> {
}