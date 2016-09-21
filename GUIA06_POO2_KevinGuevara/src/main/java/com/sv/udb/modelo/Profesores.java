/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author REGISTRO
 */
@Entity
@Table(name = "profesores", catalog = "PARCIAL01_POO2_KevinGuevara", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profesores.findAll", query = "SELECT p FROM Profesores p"),
    @NamedQuery(name = "Profesores.findByCodiProf", query = "SELECT p FROM Profesores p WHERE p.codiProf = :codiProf"),
    @NamedQuery(name = "Profesores.findByNombProf", query = "SELECT p FROM Profesores p WHERE p.nombProf = :nombProf"),
    @NamedQuery(name = "Profesores.findByApelProf", query = "SELECT p FROM Profesores p WHERE p.apelProf = :apelProf"),
    @NamedQuery(name = "Profesores.findByMailProf", query = "SELECT p FROM Profesores p WHERE p.mailProf = :mailProf"),
    @NamedQuery(name = "Profesores.findByTeleProf", query = "SELECT p FROM Profesores p WHERE p.teleProf = :teleProf"),
    @NamedQuery(name = "Profesores.findByDirePro", query = "SELECT p FROM Profesores p WHERE p.direPro = :direPro")})
public class Profesores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codi_prof")
    private Integer codiProf;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nomb_prof")
    private String nombProf;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "apel_prof")
    private String apelProf;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "mail_prof")
    private String mailProf;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tele_prof")
    private String teleProf;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "dire_pro")
    private String direPro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codiProf")
    private List<Grupos> gruposList;

    public Profesores() {
    }

    public Profesores(Integer codiProf) {
        this.codiProf = codiProf;
    }

    public Profesores(Integer codiProf, String nombProf, String apelProf, String mailProf, String teleProf, String direPro) {
        this.codiProf = codiProf;
        this.nombProf = nombProf;
        this.apelProf = apelProf;
        this.mailProf = mailProf;
        this.teleProf = teleProf;
        this.direPro = direPro;
    }

    public Integer getCodiProf() {
        return codiProf;
    }

    public void setCodiProf(Integer codiProf) {
        this.codiProf = codiProf;
    }

    public String getNombProf() {
        return nombProf;
    }

    public void setNombProf(String nombProf) {
        this.nombProf = nombProf;
    }

    public String getApelProf() {
        return apelProf;
    }

    public void setApelProf(String apelProf) {
        this.apelProf = apelProf;
    }

    public String getMailProf() {
        return mailProf;
    }

    public void setMailProf(String mailProf) {
        this.mailProf = mailProf;
    }

    public String getTeleProf() {
        return teleProf;
    }

    public void setTeleProf(String teleProf) {
        this.teleProf = teleProf;
    }

    public String getDirePro() {
        return direPro;
    }

    public void setDirePro(String direPro) {
        this.direPro = direPro;
    }

    @XmlTransient
    public List<Grupos> getGruposList() {
        return gruposList;
    }

    public void setGruposList(List<Grupos> gruposList) {
        this.gruposList = gruposList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codiProf != null ? codiProf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesores)) {
            return false;
        }
        Profesores other = (Profesores) object;
        if ((this.codiProf == null && other.codiProf != null) || (this.codiProf != null && !this.codiProf.equals(other.codiProf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelo.Profesores[ codiProf=" + codiProf + " ]";
    }
    
}
