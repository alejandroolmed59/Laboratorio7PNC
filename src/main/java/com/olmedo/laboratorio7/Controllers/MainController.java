package com.olmedo.laboratorio7.Controllers;

import java.util.List;


import com.olmedo.laboratorio7.Dao.EstudianteDAO;
import com.olmedo.laboratorio7.Domain.Estudiante;
import com.olmedo.laboratorio7.Service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@Controller
public class MainController {
    @Autowired
    private EstudianteService estudianteService;

    @RequestMapping("/listado")
    public ModelAndView initMain() {

        ModelAndView mav = new ModelAndView();
        List<Estudiante> estudiantes = null;
        try{
           estudiantes = estudianteService.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }

        mav.addObject("estudiantes", estudiantes);
        mav.setViewName("listado");
        return mav;
    }
    @RequestMapping("/inicio")
    public ModelAndView inicio(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("estudiante",new Estudiante());
        mav.setViewName("index");
        return mav;
    }
    @RequestMapping("/form")
    public ModelAndView form(@Valid @ModelAttribute Estudiante estudiante, BindingResult result){
        System.out.println("Leggo");
        ModelAndView mav = new ModelAndView();
        if(result.hasErrors()){
            mav.setViewName("index");
            return mav;
        }else{
            try {
                if(estudiante.getCarne().isEmpty()){
                    estudianteService.actualizar(estudiante);
                }else {
                    estudianteService.save(estudiante);
                }
                Estudiante es= new Estudiante();
                mav.addObject("estudiante", es);
                mav.setViewName("index");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return mav;
    }
    @RequestMapping(value = "/deletear", method = RequestMethod.POST)
    public ModelAndView delete(@RequestParam(value = "id") int id){
        ModelAndView mav = new ModelAndView();
        List<Estudiante> estudiantes = null;
        try {
            estudianteService.delete(id);
            return auxVerLista();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mav;
    }
    @RequestMapping(value = "/editar", method = RequestMethod.POST)
    public ModelAndView edit(@RequestParam(value="id") int id){
        ModelAndView mav = new ModelAndView();
        Estudiante estudiante = estudianteService.findByID(id);
        mav.addObject("estudiante", estudiante);
        mav.setViewName("index");
        return mav;
    }

    public ModelAndView auxVerLista(){
        ModelAndView mav = new ModelAndView();
        List<Estudiante> estudiantes = null;
        try{
            estudiantes = estudianteService.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }

        mav.addObject("estudiantes", estudiantes);
        mav.setViewName("listado");
        return mav;
    }

}