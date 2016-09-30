/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.ejb.CursosFacadeLocal;
import com.sv.udb.modelo.Cursos;
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
@Named(value = "cursosBean")
@ViewScoped
public class CursosBean implements Serializable{
    @EJB
    private CursosFacadeLocal FCDECurs;    
    private Cursos objeCurs;
    private LOG4J log;
    private List<Cursos> listCurs;
    private boolean guardar;

    public Cursos getObjeCurs() {
        return objeCurs;
    }

    public void setObjeCurs(Cursos objeCurs) {
        this.objeCurs = objeCurs;
    }

    public boolean isGuardar() {
        return guardar;
    }

    public List<Cursos> getListCurs() {
        return listCurs;
    }
    
    /**
     * Creates a new instance of AlumnosBean
     */
    
    public CursosBean() {
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
        this.objeCurs = new Cursos();
        this.guardar = true;        
    }
    
    public void guar()
    {
        RequestContext ctx = RequestContext.getCurrentInstance(); //Capturo el contexto de la página
        try
        {
            FCDECurs.create(this.objeCurs);
            this.listCurs.add(this.objeCurs);
            this.limpForm();
            log.info("Curso Registrado: "+objeCurs.getNombCurs());
            ctx.execute("setMessage('MESS_SUCC', 'Atención', 'Datos guardados')");
        }
        catch(Exception ex)
        {
            log.error("Error al Registrar Curso");
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
            this.listCurs.remove(this.objeCurs); //Limpia el objeto viejo
            FCDECurs.edit(this.objeCurs);
            this.listCurs.add(this.objeCurs); //Agrega el objeto modificado
            log.info("Curso Modificado: "+objeCurs.getNombCurs());
            ctx.execute("setMessage('MESS_SUCC', 'Atención', 'Datos Modificados')");
        }
        catch(Exception ex)
        {
            log.error("Error al Modificar Curso");
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
            FCDECurs.remove(this.objeCurs);
            this.listCurs.remove(this.objeCurs);
            this.limpForm();
            log.info("Curso Eliminado: "+objeCurs.getNombCurs());
            ctx.execute("setMessage('MESS_SUCC', 'Atención', 'Datos Eliminados')");
        }
        catch(Exception ex)
        {
            log.error("Error al Eliminar Curso");
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
            this.listCurs = FCDECurs.findAll();
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
            this.objeCurs = FCDECurs.find(codi);
            this.guardar = false;
            log.info("Curso Consultado: "+objeCurs.getNombCurs());
            ctx.execute("setMessage('MESS_SUCC', 'Atención', 'Consultado a " + this.objeCurs.getNombCurs() + "')");
        }
        catch(Exception ex)
        {
            log.error("Error al Consultar Curso");
            ctx.execute("setMessage('MESS_ERRO', 'Atención', 'Error al consultar')");
        }
        finally
        {
            
        }
    }
}
