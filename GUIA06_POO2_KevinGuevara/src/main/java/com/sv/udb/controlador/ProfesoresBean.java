/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.ejb.AlumnosFacadeLocal;
import com.sv.udb.ejb.ProfesoresFacadeLocal;
import com.sv.udb.modelo.Alumnos;
import com.sv.udb.modelo.Profesores;
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
@Named(value = "profesoresBean")
@ViewScoped
public class ProfesoresBean implements Serializable{
    @EJB
    private ProfesoresFacadeLocal FCDEProf;    
    private Profesores objeProf;
    private List<Profesores> listProf;
    private boolean guardar;
    private LOG4J log;
    public Profesores getObjeprof() {
        return objeProf;
    }

    public void setObjeprof(Profesores objeProf) {
        this.objeProf = objeProf;
    }

    public boolean isGuardar() {
        return guardar;
    }

    public List<Profesores> getListProf() {
        return listProf;
    }
    
    /**
     * Creates a new instance of AlumnosBean
     */
    
    public ProfesoresBean() {
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
        this.objeProf = new Profesores();
        this.guardar = true;        
    }
    
    public void guar()
    {
        RequestContext ctx = RequestContext.getCurrentInstance(); //Capturo el contexto de la página
        try
        {
            FCDEProf.create(this.objeProf);
            this.listProf.add(this.objeProf);
            log.info("Profesor Registrado: "+objeProf.getNombProf()+" "+objeProf.getApelProf());
            ctx.execute("setMessage('MESS_SUCC', 'Atención', 'Datos guardados')");
            this.limpForm();
        }
        catch(Exception ex)
        {
            log.error("Error al Registrar Profesor");
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
            this.listProf.remove(this.objeProf); //Limpia el objeto viejo
            FCDEProf.edit(this.objeProf);
            this.listProf.add(this.objeProf); //Agrega el objeto modificado
            log.info("Profesor Modificado: "+objeProf.getNombProf()+" "+objeProf.getApelProf());
            ctx.execute("setMessage('MESS_SUCC', 'Atención', 'Datos Modificados')");
            this.limpForm();
        }
        catch(Exception ex)
        {
            log.error("Error al Modificar Profesor");
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
            FCDEProf.remove(this.objeProf);
            this.listProf.remove(this.objeProf);
            log.info("Profesor Eliminado: "+objeProf.getNombProf()+" "+objeProf.getApelProf());
            ctx.execute("setMessage('MESS_SUCC', 'Atención', 'Datos Eliminados')");
            this.limpForm();
        }
        catch(Exception ex)
        {
            log.error("Error al Eliminar Profesor");
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
            this.listProf = FCDEProf.findAll();
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
            this.objeProf = FCDEProf.find(codi);
            this.guardar = false;
            log.info("Profesor Consultado: "+objeProf.getNombProf()+" "+objeProf.getApelProf());
            ctx.execute("setMessage('MESS_SUCC', 'Atención', 'Consultado a " + 
                    String.format("%s %s", this.objeProf.getNombProf(), this.objeProf.getApelProf ()) + "')");
        }
        catch(Exception ex)
        {
            log.error("Error al Consultar Profesor");
            ctx.execute("setMessage('MESS_ERRO', 'Atención', 'Error al consultar')");
        }
        finally
        {
            
        }
    }
}
