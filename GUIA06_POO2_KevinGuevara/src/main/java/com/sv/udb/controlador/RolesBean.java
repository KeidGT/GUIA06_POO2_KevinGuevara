/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.ejb.RolesFacadeLocal;
import com.sv.udb.modelo.Roles;
import com.sv.udb.utils.LOG4J;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author REGISTRO
 */
@Named(value = "rolesBean")
@ViewScoped
public class RolesBean implements Serializable{
    @EJB
    private RolesFacadeLocal FCDERole;    
    private Roles objeRole;
    private LOG4J log;
    private List<Roles> listRole;
    private boolean guardar;

    public Roles getObjeRole() {
        return objeRole;
    }

    public void setObjeRole(Roles objeRole) {
        this.objeRole = objeRole;
    }

    public boolean isGuardar() {
        return guardar;
    }

    public List<Roles> getListRole() {
        return listRole;
    }
    
    public RolesBean() {
    }
    
    @PostConstruct
    public void init()
    {
        this.limpForm();
        this.consTodo();
        log = new LOG4J();
    }
    
    public void limpForm()
    {
        this.objeRole = new Roles();
        this.guardar = true;        
    }
    
    public void guar()
    {
        RequestContext ctx = RequestContext.getCurrentInstance(); //Capturo el contexto de la página
        try
        {
            FCDERole.create(this.objeRole);
            this.listRole.add(this.objeRole);
            log.info("Roles Registrado: "+objeRole.getDescRole());
            ctx.execute("setMessage('MESS_SUCC', 'Atención', 'Datos guardados')");
            this.limpForm();
        }
        catch(Exception ex)
        {
            log.error("Error al Registrar Roles");
            ctx.execute("setMessage('MESS_ERRO', 'Atención', 'Error al guardar ')");
        }
        finally
        {
            
        }
    }
    
    public void modi()
    {
        RequestContext ctx = RequestContext.getCurrentInstance(); //Capturo el contexto de la página
        try
        {
            this.listRole.remove(this.objeRole); //Limpia el objeto viejo
            FCDERole.edit(this.objeRole);
            this.listRole.add(this.objeRole); //Agrega el objeto modificado
            log.info("Roles Modificado: "+objeRole.getDescRole());
            ctx.execute("setMessage('MESS_SUCC', 'Atención', 'Datos Modificados')");
            this.limpForm();
        }
        catch(Exception ex)
        {
            log.error("Error al Modificar Alumno");
            ctx.execute("setMessage('MESS_ERRO', 'Atención', 'Error al modificar ')");
        }
        finally
        {
            
        }
    }
    
    public void elim()
    {
        RequestContext ctx = RequestContext.getCurrentInstance(); //Capturo el contexto de la página
        try
        {
            FCDERole.remove(this.objeRole);
            this.listRole.remove(this.objeRole);
            log.info("Roles Eliminado: "+objeRole.getDescRole());
            ctx.execute("setMessage('MESS_SUCC', 'Atención', 'Datos Eliminados')");
            this.limpForm();
        }
        catch(Exception ex)
        {
            log.error("Error al Eliminar Alumno");
            ctx.execute("setMessage('MESS_ERRO', 'Atención', 'Error al eliminar')");
        }
        finally
        {
            
        }
    }
    
    public void consTodo()
    {
        try
        {
            this.listRole = FCDERole.findAll();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            
        }
    }
    
    public void cons()
    {
        RequestContext ctx = RequestContext.getCurrentInstance(); //Capturo el contexto de la página
        int codi = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("codiObjePara"));
        try
        {
            this.objeRole = FCDERole.find(codi);
            this.guardar = false;
            log.info("Alumno Consultado: " + this.objeRole.getDescRole());
            ctx.execute("setMessage('MESS_SUCC', 'Atención', 'Consultado a " +this.objeRole.getDescRole() + "')");
        }
        catch(Exception ex)
        {
            log.error("Error al Consultar Alumno");
            ctx.execute("setMessage('MESS_ERRO', 'Atención', 'Error al consultar')");
        }
        finally
        {
            
        }
    }
}
