package com.springboot.app.permisos.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.springboot.app.commons.models.entity.Permiso;

@Repository
public interface PermisoRepository extends PagingAndSortingRepository<Permiso, Integer> {
	
	@Query(value = "select c.idTipo from TipoPermiso c where c.idTipo =?1")
	Integer consultaExistencia(Integer id);
	

}
