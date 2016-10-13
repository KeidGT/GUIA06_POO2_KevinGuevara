/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Laboratorio
 */
@Entity
@Table(name = "usuarios_roles", catalog = "PARCIAL01_POO2_KevinGuevara", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuariosRoles.findAll", query = "SELECT u FROM UsuariosRoles u"),
    @NamedQuery(name = "UsuariosRoles.findByCodiUsuaRole", query = "SELECT u FROM UsuariosRoles u WHERE u.codiUsuaRole = :codiUsuaRole"),
    @NamedQuery(name = "UsuariosRoles.findByEstaUsuaRole", query = "SELECT u FROM UsuariosRoles u WHERE u.estaUsuaRole = :estaUsuaRole"),
    @NamedQuery(name = "UsuariosRoles.findByFechAltaRole", query = "SELECT u FROM UsuariosRoles u WHERE u.fechAltaRole = :fechAltaRole"),
    @NamedQuery(name = "UsuariosRoles.findByFechBajaRole", query = "SELECT u FROM UsuariosRoles u WHERE u.fechBajaRole = :fechBajaRole")})
public class UsuariosRoles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codi_usua_role")
    private Integer codiUsuaRole;
    @Column(name = "esta_usua_role")
    private Integer estaUsuaRole;
    @Column(name = "fech_alta_role")
    @Temporal(TemporalType.DATE)
    private Date fechAltaRole;
    @Column(name = "fech_baja_role")
    @Temporal(TemporalType.DATE)
    private Date fechBajaRole;
    @JoinColumn(name = "codi_usua", referencedColumnName = "codi_usua")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuarios codiUsua;
    @JoinColumn(name = "codi_role", referencedColumnName = "codi_role")
    @ManyToOne(fetch = FetchType.LAZY)
    private Roles codiRole;

    public UsuariosRoles() {
    }

    public UsuariosRoles(Integer codiUsuaRole) {
        this.codiUsuaRole = codiUsuaRole;
    }

    public Integer getCodiUsuaRole() {
        return codiUsuaRole;
    }

    public void setCodiUsuaRole(Integer codiUsuaRole) {
        this.codiUsuaRole = codiUsuaRole;
    }

    public Integer getEstaUsuaRole() {
        return estaUsuaRole;
    }

    public void setEstaUsuaRole(Integer estaUsuaRole) {
        this.estaUsuaRole = estaUsuaRole;
    }

    public Date getFechAltaRole() {
        return fechAltaRole;
    }

    public void setFechAltaRole(Date fechAltaRole) {
        this.fechAltaRole = fechAltaRole;
    }

    public Date getFechBajaRole() {
        return fechBajaRole;
    }

    public void setFechBajaRole(Date fechBajaRole) {
        this.fechBajaRole = fechBajaRole;
    }

    public Usuarios getCodiUsua() {
        return codiUsua;
    }

    public void setCodiUsua(Usuarios codiUsua) {
        this.codiUsua = codiUsua;
    }

    public Roles getCodiRole() {
        return codiRole;
    }

    public void setCodiRole(Roles codiRole) {
        this.codiRole = codiRole;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codiUsuaRole != null ? codiUsuaRole.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuariosRoles)) {
            return false;
        }
        UsuariosRoles other = (UsuariosRoles) object;
        if ((this.codiUsuaRole == null && other.codiUsuaRole != null) || (this.codiUsuaRole != null && !this.codiUsuaRole.equals(other.codiUsuaRole))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelo.UsuariosRoles[ codiUsuaRole=" + codiUsuaRole + " ]";
    }
    
}
