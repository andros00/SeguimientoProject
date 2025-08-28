package com.udea.siiuseguimproyectosback.persistence.project;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import com.udea.siiuseguimproyectosback.domain.dto.project.VinculoEstudianteDTO;
import com.udea.siiuseguimproyectosback.domain.entity.project.VinculoEstudiante;

import org.springframework.stereotype.Repository;

@Repository
public class ProcedureVinculoEstudianteRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public VinculoEstudianteDTO leerVinculoEstudiante(String identificacion) {
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("SIIU_LEER_VINCULO_ESTUDIANTE");

		// Parámetro IN
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, identificacion);

		// Parámetro OUT (cursor)
		query.registerStoredProcedureParameter(2, VinculoEstudiante.class, ParameterMode.REF_CURSOR);

		query.execute();

		List<Object[]> results = query.getResultList();
		List<VinculoEstudianteDTO> response = new ArrayList<>();

		for (Object[] row : results) {
			VinculoEstudianteDTO dto = new VinculoEstudianteDTO();
			System.out.println("****1::::"+row[0]);
			dto.setIdentificacion((String) row[0]);
			System.out.println("****2::::"+row[1]);
			dto.setSelectorPersona((String) row[1]);
			System.out.println("****3::::"+row[2]);
			dto.setCodigoFacultad((String) row[2]);
			System.out.println("****4::::"+row[3]);
			dto.setNombreFacultad((String) row[3]);
			System.out.println("****5::::"+row[4]);
			dto.setCodigoPrograma((String) row[4]);
			System.out.println("****6::::"+row[5]);
			dto.setNombrePrograma((String) row[5]);
			System.out.println("****7::::"+row[6]);
			dto.setCodigoTipo((String) row[6]);
			System.out.println("****8::::"+row[7]);
			dto.setNombreTipoPrograma((String) row[7]);
			System.out.println("****9::::"+row[9]);
			dto.setPorcentajeCompletado(row[8] != null ? Double.valueOf(row[8].toString().replace(",", ".")) : null);
			response.add(dto);
		}

		return response.get(0);
	}

}
