/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.ejb;

import com.sv.udb.modelo.Profesores;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AdminDesa
 */
@Local
public interface ProfesoresFacadeLocal {

    void create(Profesores profesores);

    void edit(Profesores profesores);

    void remove(Profesores profesores);

    Profesores find(Object id);

    List<Profesores> findAll();

    List<Profesores> findRange(int[] range);

    int count();
    
}
