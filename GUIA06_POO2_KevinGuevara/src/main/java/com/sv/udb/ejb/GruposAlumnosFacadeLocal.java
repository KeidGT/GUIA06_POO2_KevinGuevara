/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.ejb;

import com.sv.udb.modelo.GruposAlumnos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Kevin
 */
@Local
public interface GruposAlumnosFacadeLocal {

    void create(GruposAlumnos gruposAlumnos);

    void edit(GruposAlumnos gruposAlumnos);

    void remove(GruposAlumnos gruposAlumnos);

    GruposAlumnos find(Object id);

    List<GruposAlumnos> findAll();

    List<GruposAlumnos> findRange(int[] range);

    int count();
    
}
