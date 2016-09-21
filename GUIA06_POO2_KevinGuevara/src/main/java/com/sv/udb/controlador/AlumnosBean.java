/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.ejb.AlumnosFacadeLocal;
import com.sv.udb.modelo.Alumnos;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.primefaces.context.RequestContext;

/**
 *
 * @author REGISTRO
 */
@Named(value = "alumnosBean")
@ViewScoped
public class AlumnosBean implements Serializable{
    @EJB
    private AlumnosFacadeLocal FCDEAlum;
    private Alumnos objeAlum;
    private boolean guardar;
    private String pool;
    private List<Alumnos> listAlum;
    private int codigo;
    
    public Alumnos getObjeAlum() {
        return objeAlum;
    }

    public void setObjeAlum(Alumnos objeAlum) {
        this.objeAlum = objeAlum;
    }

    public List<Alumnos> getListAlum() {
        return listAlum;
    }

    public void setListAlum(List<Alumnos> listAlum) {
        this.listAlum = listAlum;
    }

    public boolean isGuardar() {
        return guardar;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    /**
     * Creates a new instance of AlumnosBean
     */
    
    public AlumnosBean() {
    }
    
    @PostConstruct
    public void init()
    {
        this.objeAlum = new Alumnos();
        this.guardar = true;
        this.pool = "jpool";
        consTodo();
    }
    public void limpForm()
    {
        this.objeAlum = new Alumnos();
        this.guardar = true;        
    }
    public void guar()
    {
        RequestContext ctx = RequestContext.getCurrentInstance(); //Capturo el contexto de la página
        try
        {
            FCDEAlum.create(this.objeAlum);
            this.listAlum.add(this.objeAlum);
            this.limpForm();
            ctx.execute("setMessage('MESS_SUCC', 'Datos guardados')");
        }
        catch(Exception ex)
        {
            ctx.execute("setMessage('MESS_ERRO', 'Error al guardar ')");
            System.out.println("ERROR: " +ex);
            //tx.rollback();
            //ex.printStackTrace();
        }
        finally
        {            
        }
    }
    public void modificar()
    {
        RequestContext ctx = RequestContext.getCurrentInstance(); //Capturo el contexto de la página
        try
        {
            this.listAlum.remove(this.objeAlum); //Limpia el objeto viejo
            FCDEAlum.edit(this.objeAlum);
            this.listAlum.add(this.objeAlum); //Agrega el objeto modificado
            ctx.execute("setMessage('MESS_SUCC', 'Datos modificados')");
            consTodo();
            this.objeAlum = new Alumnos(); // Limpiar
        }
        catch(Exception ex)
        {
            ctx.execute("setMessage('MESS_ERRO', 'Error al modificar ')");
            System.out.println("ERROR: " +ex);
            //tx.rollback();
        }
    }
    public void eliminar()
    {
        RequestContext ctx = RequestContext.getCurrentInstance(); //Capturo el contexto de la página
        try
        {
            FCDEAlum.remove(this.objeAlum);
            this.listAlum.remove(this.objeAlum);
            this.limpForm();
                ctx.execute("setMessage('MESS_SUCC', 'Datos eliminados')");
                consTodo();
                this.objeAlum = new Alumnos(); // Limpiar
            
        }catch(Exception e){
            ctx.execute("setMessage('MESS_ERRO', 'Error al eliminar ')");
            
        }
    }
    public void consTodo()
    {
        try
        {
            this.listAlum = FCDEAlum.findAll();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            
        }
    }
    public void cons(){
        
        RequestContext ctx = RequestContext.getCurrentInstance(); //Capturo el contexto de la página
        //int codi = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("codiAlumPara"));
        try
        {
            this.objeAlum = FCDEAlum.find(codigo);
            this.guardar = false;
            ctx.execute("setMessage('MESS_SUCC', 'Consultado a " + 
                    String.format("%s %s", this.objeAlum.getNombAlum(), this.objeAlum.getApelAlum()) + "')");
        }
        catch(Exception ex)
        {
            ctx.execute("setMessage('MESS_ERRO', 'Error al consultar')");
        }
        finally
        {
            
        }           
    }
}
