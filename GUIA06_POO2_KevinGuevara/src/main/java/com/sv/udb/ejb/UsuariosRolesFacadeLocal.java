/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.ejb;

import com.sv.udb.modelo.UsuariosRoles;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Laboratorio
 */
@Local
public interface UsuariosRolesFacadeLocal {

    void create(UsuariosRoles usuariosRoles);

    void edit(UsuariosRoles usuariosRoles);

    void remove(UsuariosRoles usuariosRoles);

    UsuariosRoles find(Object id);

    List<UsuariosRoles> findAll();

    List<UsuariosRoles> findRange(int[] range);

    int count();
    
}
