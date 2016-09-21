/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.ejb;

import com.sv.udb.modelo.Grupos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Kevin
 */
@Local
public interface GruposFacadeLocal {

    void create(Grupos grupos);

    void edit(Grupos grupos);

    void remove(Grupos grupos);

    Grupos find(Object id);

    List<Grupos> findAll();

    List<Grupos> findRange(int[] range);

    int count();
    
}
