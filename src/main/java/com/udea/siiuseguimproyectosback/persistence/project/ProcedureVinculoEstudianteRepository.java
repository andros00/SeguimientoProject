package com.udea.siiuseguimproyectosback.persistence.project;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import com.udea.siiuseguimproyectosback.domain.dto.project.VinculoEstudianteDTO;

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
		query.registerStoredProcedureParameter(2, void.class, ParameterMode.REF_CURSOR);

		query.execute();

		List<Object[]> results = query.getResultList();
		List<VinculoEstudianteDTO> response = new ArrayList<>();

		for (Object[] row : results) {
			VinculoEstudianteDTO dto = new VinculoEstudianteDTO();
			dto.setIdentificacion((String) row[0]);
			dto.setSelectorPersona((String) row[1]);
			dto.setCodigoFacultad((String) row[2]);
			dto.setNombreFacultad((String) row[3]);
			dto.setCodigoPrograma((String) row[4]);
			dto.setNombrePrograma((String) row[5]);
			dto.setCodigoTipo((String) row[6]);
			dto.setNombreTipoPrograma((String) row[7]);
			dto.setPorcentajeCompletado(row[8] != null ? Double.valueOf(row[8].toString().replace(",", ".")) : null);
			response.add(dto);
		}

		return response.get(0);
	}

}
