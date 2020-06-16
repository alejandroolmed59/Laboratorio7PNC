package com.olmedo.laboratorio7.Dao;

import com.olmedo.laboratorio7.Dao.EstudianteDAO;
import com.olmedo.laboratorio7.Domain.Estudiante;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class EstudianteDAOImp implements EstudianteDAO {
    @PersistenceContext(unitName = "laboratorio7")
    private EntityManager entityManager;

    @Override
    public List<Estudiante> findAll() throws DataAccessException {
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT * FROM public.estudiante");
        Query query = entityManager.createNativeQuery(sb.toString(), Estudiante.class);
        List <Estudiante> resulset = query.getResultList();
        return resulset;
    }

    @Override
    public Estudiante findOne(Integer code) throws DataAccessException {
        Estudiante estudiante = entityManager.find(Estudiante.class, code);
        return estudiante;
    }

    @Override
    @Transactional
    public void insertEstudiante(Estudiante estudiante) throws DataAccessException {
        entityManager.persist(estudiante);
    }

}
