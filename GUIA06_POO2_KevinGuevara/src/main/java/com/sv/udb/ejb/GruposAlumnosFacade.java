/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.ejb;

import com.sv.udb.modelo.GruposAlumnos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author AdminDesa
 */
@Stateless
public class GruposAlumnosFacade extends AbstractFacade<GruposAlumnos> implements GruposAlumnosFacadeLocal {
    @PersistenceContext(unitName = "POOPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GruposAlumnosFacade() {
        super(GruposAlumnos.class);
    }
    
}
