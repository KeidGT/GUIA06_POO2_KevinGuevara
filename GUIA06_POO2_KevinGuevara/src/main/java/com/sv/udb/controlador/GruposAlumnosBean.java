/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.ejb.GruposAlumnosFacadeLocal;
import com.sv.udb.modelo.GruposAlumnos;
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
@Named(value = "gruposAlumnosBean")
@ViewScoped
public class GruposAlumnosBean implements Serializable{
    @EJB
    private GruposAlumnosFacadeLocal FCDEGruposAlumnos;    
    private GruposAlumnos objeGrupAlum;
    private List<GruposAlumnos> listGrupAlum;
    private boolean guardar;
    private LOG4J log;
    /**
     * Creates a new instance of GruposAlumnosBean
     */

    public GruposAlumnos getObjeGrupAlum() {
        return objeGrupAlum;
    }

    public void setObjeGrupAlum(GruposAlumnos objeGrupAlum) {
        this.objeGrupAlum = objeGrupAlum;
    }

    public List<GruposAlumnos> getListGrupAlum() {
        return listGrupAlum;
    }

    public void setListGrupAlum(List<GruposAlumnos> listGrupAlum) {
        this.listGrupAlum = listGrupAlum;
    }

    public boolean isGuardar() {
        return guardar;
    }

    public void setGuardar(boolean guardar) {
        this.guardar = guardar;
    }
    public GruposAlumnosBean() {
        
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
        this.objeGrupAlum = new GruposAlumnos();
        this.guardar = true;        
    }
    
    public void guar()
    {
        RequestContext ctx = RequestContext.getCurrentInstance(); //Capturo el contexto de la página
        try
        {
            FCDEGruposAlumnos.create(this.objeGrupAlum);
            this.listGrupAlum.add(this.objeGrupAlum);
            this.limpForm();
            log.info("Alumno "+objeGrupAlum.getCodiAlum().getNombAlum()+" "+objeGrupAlum.getCodiAlum().getApelAlum()+" Asignado en el Grupo "+ " "+objeGrupAlum.getCodiGrup().getNombGrup()+", Registro Realizado");
            ctx.execute("setMessage('MESS_SUCC', 'Atención', 'Datos guardados')");
        }
        catch(Exception ex)
        {
            ctx.execute("setMessage('MESS_ERRO', 'Atención', 'Error al guardar ')");
            log.error("Error al Registrar Alumno en Grupo");
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
            this.listGrupAlum.remove(this.objeGrupAlum); //Limpia el objeto viejo
            FCDEGruposAlumnos.edit(this.objeGrupAlum);
            this.listGrupAlum.add(this.objeGrupAlum); //Agrega el objeto modificado
            ctx.execute("setMessage('MESS_SUCC', 'Atención', 'Datos Modificados')");
            log.info("Alumno "+objeGrupAlum.getCodiAlum().getNombAlum()+" "+objeGrupAlum.getCodiAlum().getApelAlum()+" Asignado en el Grupo "+ " "+objeGrupAlum.getCodiGrup().getNombGrup()+", Registro Modificado");
        }
        catch(Exception ex)
        {
            ctx.execute("setMessage('MESS_ERRO', 'Atención', 'Error al modificar ')");
            log.error("Error al Modificar Alumno en Grupo");
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
            FCDEGruposAlumnos.remove(this.objeGrupAlum);
            this.listGrupAlum.remove(this.objeGrupAlum);
            this.limpForm();
            ctx.execute("setMessage('MESS_SUCC', 'Atención', 'Datos Eliminados')");
            log.info("Alumno "+objeGrupAlum.getCodiAlum().getNombAlum()+" "+objeGrupAlum.getCodiAlum().getApelAlum()+" Asignado en el Grupo "+ " "+objeGrupAlum.getCodiGrup().getNombGrup()+", Registro Eliminado");
        }
        catch(Exception ex)
        {
            ctx.execute("setMessage('MESS_ERRO', 'Atención', 'Error al eliminar')");
            log.error("Error al Eliminar Alumno en Grupo");
        }
        finally
        {
            
        }
    }
    
    public void consTodo()
    {
        try
        {
            this.listGrupAlum = FCDEGruposAlumnos.findAll();
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
        int codi = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("codiGrupAlumPara"));
        try
        {
            this.objeGrupAlum = FCDEGruposAlumnos.find(codi);
            this.guardar = false;
            ctx.execute("setMessage('MESS_SUCC', 'Atención', 'Consultado')");
            log.info("Alumno "+objeGrupAlum.getCodiAlum().getNombAlum()+" "+objeGrupAlum.getCodiAlum().getApelAlum()+" Asignado en el Grupo "+ " "+objeGrupAlum.getCodiGrup().getNombGrup()+", Registro Consultado");
        }
        catch(Exception ex)
        {
            ctx.execute("setMessage('MESS_ERRO', 'Atención', 'Error al consultar')");
            log.error("Error al Consultar Alumno asignado a Grupo");
        }
        finally
        {
            
        }
    }
    
}
