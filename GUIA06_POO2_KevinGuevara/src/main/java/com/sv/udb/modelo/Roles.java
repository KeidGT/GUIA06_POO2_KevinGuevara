/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Laboratorio
 */
@Entity
@Table(name = "roles", catalog = "PARCIAL01_POO2_KevinGuevara", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roles.findAll", query = "SELECT r FROM Roles r"),
    @NamedQuery(name = "Roles.findByCodiRole", query = "SELECT r FROM Roles r WHERE r.codiRole = :codiRole"),
    @NamedQuery(name = "Roles.findByDescRole", query = "SELECT r FROM Roles r WHERE r.descRole = :descRole"),
    @NamedQuery(name = "Roles.findByDireRole", query = "SELECT r FROM Roles r WHERE r.direRole = :direRole"),
    @NamedQuery(name = "Roles.findByEstaRole", query = "SELECT r FROM Roles r WHERE r.estaRole = :estaRole"),
    @NamedQuery(name = "Roles.findByFechAltaRole", query = "SELECT r FROM Roles r WHERE r.fechAltaRole = :fechAltaRole"),
    @NamedQuery(name = "Roles.findByFechBajaRole", query = "SELECT r FROM Roles r WHERE r.fechBajaRole = :fechBajaRole")})
public class Roles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codi_role")
    private Integer codiRole;
    @Size(max = 250)
    @Column(name = "desc_role")
    private String descRole;
    @Size(max = 250)
    @Column(name = "dire_role")
    private String direRole;
    @Column(name = "esta_role")
    private Integer estaRole;
    @Column(name = "fech_alta_role")
    @Temporal(TemporalType.DATE)
    private Date fechAltaRole;
    @Column(name = "fech_baja_role")
    @Temporal(TemporalType.DATE)
    private Date fechBajaRole;
    @OneToMany(mappedBy = "refeRole", fetch = FetchType.LAZY)
    private List<Roles> rolesList;
    @JoinColumn(name = "refe_role", referencedColumnName = "codi_role")
    @ManyToOne(fetch = FetchType.LAZY)
    private Roles refeRole;
    @OneToMany(mappedBy = "codiRole", fetch = FetchType.LAZY)
    private List<UsuariosRoles> usuariosRolesList;

    public Roles() {
    }

    public Roles(Integer codiRole) {
        this.codiRole = codiRole;
    }

    public Integer getCodiRole() {
        return codiRole;
    }

    public void setCodiRole(Integer codiRole) {
        this.codiRole = codiRole;
    }

    public String getDescRole() {
        return descRole;
    }

    public void setDescRole(String descRole) {
        this.descRole = descRole;
    }

    public String getDireRole() {
        return direRole;
    }

    public void setDireRole(String direRole) {
        this.direRole = direRole;
    }

    public Integer getEstaRole() {
        return estaRole;
    }

    public void setEstaRole(Integer estaRole) {
        this.estaRole = estaRole;
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

    @XmlTransient
    public List<Roles> getRolesList() {
        return rolesList;
    }

    public void setRolesList(List<Roles> rolesList) {
        this.rolesList = rolesList;
    }

    public Roles getRefeRole() {
        return refeRole;
    }

    public void setRefeRole(Roles refeRole) {
        this.refeRole = refeRole;
    }

    @XmlTransient
    public List<UsuariosRoles> getUsuariosRolesList() {
        return usuariosRolesList;
    }

    public void setUsuariosRolesList(List<UsuariosRoles> usuariosRolesList) {
        this.usuariosRolesList = usuariosRolesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codiRole != null ? codiRole.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roles)) {
            return false;
        }
        Roles other = (Roles) object;
        if ((this.codiRole == null && other.codiRole != null) || (this.codiRole != null && !this.codiRole.equals(other.codiRole))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelo.Roles[ codiRole=" + codiRole + " ]";
    }
    
}
