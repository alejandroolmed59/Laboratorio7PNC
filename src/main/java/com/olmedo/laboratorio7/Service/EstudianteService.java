package com.olmedo.laboratorio7.Service;

import com.olmedo.laboratorio7.Domain.Estudiante;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface EstudianteService {
    public List<Estudiante> findAll() throws DataAccessException;
    public void save(Estudiante estudiante) throws DataAccessException;
    public Estudiante findByID(Integer code) throws DataAccessException;
    public void delete(Integer code) throws DataAccessException;
    public void actualizar(Estudiante estudiante) throws DataAccessException;
}
