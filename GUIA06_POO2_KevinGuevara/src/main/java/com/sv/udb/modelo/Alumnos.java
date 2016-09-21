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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author REGISTRO
 */
@Entity
@Table(name = "alumnos", catalog = "PARCIAL01_POO2_KevinGuevara", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alumnos.findAll", query = "SELECT a FROM Alumnos a"),
    @NamedQuery(name = "Alumnos.findByCodiAlum", query = "SELECT a FROM Alumnos a WHERE a.codiAlum = :codiAlum"),
    @NamedQuery(name = "Alumnos.findByNombAlum", query = "SELECT a FROM Alumnos a WHERE a.nombAlum = :nombAlum"),
    @NamedQuery(name = "Alumnos.findByApelAlum", query = "SELECT a FROM Alumnos a WHERE a.apelAlum = :apelAlum"),
    @NamedQuery(name = "Alumnos.findByFechNaciAlum", query = "SELECT a FROM Alumnos a WHERE a.fechNaciAlum = :fechNaciAlum"),
    @NamedQuery(name = "Alumnos.findByMailAlum", query = "SELECT a FROM Alumnos a WHERE a.mailAlum = :mailAlum"),
    @NamedQuery(name = "Alumnos.findByTeleAlum", query = "SELECT a FROM Alumnos a WHERE a.teleAlum = :teleAlum"),
    @NamedQuery(name = "Alumnos.findByDireAlum", query = "SELECT a FROM Alumnos a WHERE a.direAlum = :direAlum"),
    @NamedQuery(name = "Alumnos.findByGeneAlum", query = "SELECT a FROM Alumnos a WHERE a.geneAlum = :geneAlum")})
public class Alumnos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codi_alum")
    private Integer codiAlum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nomb_alum")
    private String nombAlum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "apel_alum")
    private String apelAlum;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fech_naci_alum")
    @Temporal(TemporalType.DATE)
    private Date fechNaciAlum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "mail_alum")
    private String mailAlum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tele_alum")
    private String teleAlum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "dire_alum")
    private String direAlum;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gene_alum")
    private Character geneAlum;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codiAlum")
    private List<GruposAlumnos> gruposAlumnosList;

    public Alumnos() {
    }

    public Alumnos(Integer codiAlum) {
        this.codiAlum = codiAlum;
    }

    public Alumnos(Integer codiAlum, String nombAlum, String apelAlum, Date fechNaciAlum, String mailAlum, String teleAlum, String direAlum, Character geneAlum) {
        this.codiAlum = codiAlum;
        this.nombAlum = nombAlum;
        this.apelAlum = apelAlum;
        this.fechNaciAlum = fechNaciAlum;
        this.mailAlum = mailAlum;
        this.teleAlum = teleAlum;
        this.direAlum = direAlum;
        this.geneAlum = geneAlum;
    }

    public Integer getCodiAlum() {
        return codiAlum;
    }

    public void setCodiAlum(Integer codiAlum) {
        this.codiAlum = codiAlum;
    }

    public String getNombAlum() {
        return nombAlum;
    }

    public void setNombAlum(String nombAlum) {
        this.nombAlum = nombAlum;
    }

    public String getApelAlum() {
        return apelAlum;
    }

    public void setApelAlum(String apelAlum) {
        this.apelAlum = apelAlum;
    }

    public Date getFechNaciAlum() {
        return fechNaciAlum;
    }

    public void setFechNaciAlum(Date fechNaciAlum) {
        this.fechNaciAlum = fechNaciAlum;
    }

    public String getMailAlum() {
        return mailAlum;
    }

    public void setMailAlum(String mailAlum) {
        this.mailAlum = mailAlum;
    }

    public String getTeleAlum() {
        return teleAlum;
    }

    public void setTeleAlum(String teleAlum) {
        this.teleAlum = teleAlum;
    }

    public String getDireAlum() {
        return direAlum;
    }

    public void setDireAlum(String direAlum) {
        this.direAlum = direAlum;
    }

    public Character getGeneAlum() {
        return geneAlum;
    }

    public void setGeneAlum(Character geneAlum) {
        this.geneAlum = geneAlum;
    }

    @XmlTransient
    public List<GruposAlumnos> getGruposAlumnosList() {
        return gruposAlumnosList;
    }

    public void setGruposAlumnosList(List<GruposAlumnos> gruposAlumnosList) {
        this.gruposAlumnosList = gruposAlumnosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codiAlum != null ? codiAlum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alumnos)) {
            return false;
        }
        Alumnos other = (Alumnos) object;
        if ((this.codiAlum == null && other.codiAlum != null) || (this.codiAlum != null && !this.codiAlum.equals(other.codiAlum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelo.Alumnos[ codiAlum=" + codiAlum + " ]";
    }
    
}
