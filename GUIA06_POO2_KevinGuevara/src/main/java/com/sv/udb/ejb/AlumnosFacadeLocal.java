/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.ejb;

import com.sv.udb.modelo.Alumnos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AdminDesa
 */
@Local
public interface AlumnosFacadeLocal {

    void create(Alumnos alumnos);

    void edit(Alumnos alumnos);

    void remove(Alumnos alumnos);

    Alumnos find(Object id);

    List<Alumnos> findAll();

    List<Alumnos> findRange(int[] range);

    int count();
    
}
