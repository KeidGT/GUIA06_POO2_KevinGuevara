/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.utils;

import org.apache.log4j.*;

/**
 *
 * @author Kevin
 */
public class LOG4J {
    
    private static Logger log = Logger.getLogger(LOG4J.class);
    public LOG4J() {
        try{
            PropertyConfigurator.configure(this.getClass().getClassLoader().getResource("/log4j.properties").getPath());;
            
        }
        catch(Exception e)
        {
            System.out.println("Error con LOG: "+e);
        }
        
    }
    //El mas básico, equivalente a un System.out.println
    public void trace(String mens){
        try{
            log.trace(mens);
        }
        catch(Exception e)
        {
            System.out.println("Error con LOG: "+e);
        }
        
    }
    //Muy util para procesos, para valores, variables
    public void debug(String mens){
        try{
            log.debug(mens);
        }
        catch(Exception e)
        {
            System.out.println("Error con LOG: "+e);
        }
        
    }
    //Información que puede ser importante
    public void info(String mens){
        try{
            log.info(mens);
            System.out.println("LOG Generado");
        }
        catch(Exception e)
        {
            System.out.println("Error con LOG: "+e);
        }
    }
    //Fallos no críticos
    public void warm(String mens){
        try{
            log.warn(mens);
        }
        catch(Exception e)
        {
            System.out.println("Error con LOG: "+e);
        }
    }
    //Errores importantes, que no obligan a cerrar la aplicación
    public void error(String mens){
        try{
            log.error(mens);
        }
        catch(Exception e)
        {
            System.out.println("Error con LOG: "+e);
        }
    }
    //Errores importantes que obligan a cerrar la aplicación
    public void fatal(String mens){
        try{
            log.fatal(mens);
        }
        catch(Exception e)
        {
            System.out.println("Error con LOG: "+e);
        }
    }
    
}
