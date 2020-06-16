package com.olmedo.laboratorio7.repositories;

import com.olmedo.laboratorio7.Domain.Estudiante;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudianteRepo extends JpaRepository<Estudiante, Integer> {
    public List<Estudiante> findByCodigoEstudiante(String cadena) throws DataAccessException;

    public List<Estudiante> findByApellidoStartingWith(String cadena) throws DataAccessException;

    @Query(nativeQuery=true, value="select  * from public.estudiante")
    public List<Estudiante> mostrarPorNombre() throws DataAccessException;;

    @Query(nativeQuery=true, value="update public.estudiante set nombre=:nombre, apellido=:apellido, carne=:carne, carrera=:carrera  where c_usuario = :c_usuario")
    public List<Estudiante> actualizarEstudiante(String nombre, String apellido, String carne, String carrera, String c_usuario) throws DataAccessException;;
}
