/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.ejb;

import com.sv.udb.modelo.Roles;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Laboratorio
 */
@Stateless
public class RolesFacade extends AbstractFacade<Roles> implements RolesFacadeLocal {

    @PersistenceContext(unitName = "POOPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RolesFacade() {
        super(Roles.class);
    }
    
    @Override
    public Roles findByCodiRole(Object codi) {
        TypedQuery<Roles> q = getEntityManager().createNamedQuery("Roles.findByCodiRole", Roles.class);        
        q.setParameter("codiRole", String.valueOf(codi));
        List resu = q.getResultList();
        return resu.isEmpty() ? null : (Roles)resu.get(0);
    }
}
