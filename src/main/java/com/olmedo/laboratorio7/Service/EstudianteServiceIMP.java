package com.olmedo.laboratorio7.Service;


import com.olmedo.laboratorio7.Domain.Estudiante;
import com.olmedo.laboratorio7.repositories.EstudianteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteServiceIMP implements EstudianteService {

    @Autowired
    EstudianteRepo estudianteRepo;

    @Override
    public List<Estudiante> findAll() throws DataAccessException {
        return estudianteRepo.findAll();
    }

    @Override
    public void save(Estudiante estudiante) throws DataAccessException {
        estudianteRepo.save(estudiante);
    }

    @Override
    public Estudiante findByID(Integer code) throws DataAccessException {
        return estudianteRepo.getOne(code);
    }

    @Override
    public void delete(Integer code) throws DataAccessException {
        estudianteRepo.deleteById(code);
    }

    @Override
    public void actualizar(Estudiante estudiante) throws DataAccessException {
        estudianteRepo.actualizarEstudiante(estudiante.getNombre(), estudiante.getApellido(), estudiante.getCarne(), estudiante.getCarrera(), estudiante.getCodigoEstudiante().toString());
    }
}
