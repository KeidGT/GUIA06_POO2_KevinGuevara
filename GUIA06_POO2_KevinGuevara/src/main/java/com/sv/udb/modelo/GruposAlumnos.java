/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author REGISTRO
 */
@Entity
@Table(name = "grupos_alumnos", catalog = "PARCIAL01_POO2_KevinGuevara", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GruposAlumnos.findAll", query = "SELECT g FROM GruposAlumnos g"),
    @NamedQuery(name = "GruposAlumnos.findByCodiGrupAlum", query = "SELECT g FROM GruposAlumnos g WHERE g.codiGrupAlum = :codiGrupAlum"),
    @NamedQuery(name = "GruposAlumnos.findByEstaGrupAlum", query = "SELECT g FROM GruposAlumnos g WHERE g.estaGrupAlum = :estaGrupAlum")})
public class GruposAlumnos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codi_grup_alum")
    private Integer codiGrupAlum;
    @Basic(optional = false)
    @NotNull
    @Column(name = "esta_grup_alum")
    private Character estaGrupAlum;
    @JoinColumn(name = "codi_grup", referencedColumnName = "codi_grup")
    @ManyToOne(optional = false)
    private Grupos codiGrup;
    @JoinColumn(name = "codi_alum", referencedColumnName = "codi_alum")
    @ManyToOne(optional = false)
    private Alumnos codiAlum;

    public GruposAlumnos() {
    }

    public GruposAlumnos(Integer codiGrupAlum) {
        this.codiGrupAlum = codiGrupAlum;
    }

    public GruposAlumnos(Integer codiGrupAlum, Character estaGrupAlum) {
        this.codiGrupAlum = codiGrupAlum;
        this.estaGrupAlum = estaGrupAlum;
    }

    public Integer getCodiGrupAlum() {
        return codiGrupAlum;
    }

    public void setCodiGrupAlum(Integer codiGrupAlum) {
        this.codiGrupAlum = codiGrupAlum;
    }

    public Character getEstaGrupAlum() {
        return estaGrupAlum;
    }

    public void setEstaGrupAlum(Character estaGrupAlum) {
        this.estaGrupAlum = estaGrupAlum;
    }

    public Grupos getCodiGrup() {
        return codiGrup;
    }

    public void setCodiGrup(Grupos codiGrup) {
        this.codiGrup = codiGrup;
    }

    public Alumnos getCodiAlum() {
        return codiAlum;
    }

    public void setCodiAlum(Alumnos codiAlum) {
        this.codiAlum = codiAlum;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codiGrupAlum != null ? codiGrupAlum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GruposAlumnos)) {
            return false;
        }
        GruposAlumnos other = (GruposAlumnos) object;
        if ((this.codiGrupAlum == null && other.codiGrupAlum != null) || (this.codiGrupAlum != null && !this.codiGrupAlum.equals(other.codiGrupAlum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelo.GruposAlumnos[ codiGrupAlum=" + codiGrupAlum + " ]";
    }
    
}
