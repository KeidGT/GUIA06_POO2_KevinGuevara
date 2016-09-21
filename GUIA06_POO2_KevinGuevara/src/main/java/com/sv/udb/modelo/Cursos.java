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
@Table(name = "cursos", catalog = "PARCIAL01_POO2_KevinGuevara", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cursos.findAll", query = "SELECT c FROM Cursos c"),
    @NamedQuery(name = "Cursos.findByCodiCurs", query = "SELECT c FROM Cursos c WHERE c.codiCurs = :codiCurs"),
    @NamedQuery(name = "Cursos.findByNombCurs", query = "SELECT c FROM Cursos c WHERE c.nombCurs = :nombCurs"),
    @NamedQuery(name = "Cursos.findByDuraCurs", query = "SELECT c FROM Cursos c WHERE c.duraCurs = :duraCurs"),
    @NamedQuery(name = "Cursos.findByCostCurs", query = "SELECT c FROM Cursos c WHERE c.costCurs = :costCurs")})
public class Cursos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codi_curs")
    private Integer codiCurs;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nomb_curs")
    private String nombCurs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dura_curs")
    private int duraCurs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cost_curs")
    private double costCurs;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codiCurs")
    private List<Grupos> gruposList;

    public Cursos() {
    }

    public Cursos(Integer codiCurs) {
        this.codiCurs = codiCurs;
    }

    public Cursos(Integer codiCurs, String nombCurs, int duraCurs, double costCurs) {
        this.codiCurs = codiCurs;
        this.nombCurs = nombCurs;
        this.duraCurs = duraCurs;
        this.costCurs = costCurs;
    }

    public Integer getCodiCurs() {
        return codiCurs;
    }

    public void setCodiCurs(Integer codiCurs) {
        this.codiCurs = codiCurs;
    }

    public String getNombCurs() {
        return nombCurs;
    }

    public void setNombCurs(String nombCurs) {
        this.nombCurs = nombCurs;
    }

    public int getDuraCurs() {
        return duraCurs;
    }

    public void setDuraCurs(int duraCurs) {
        this.duraCurs = duraCurs;
    }

    public double getCostCurs() {
        return costCurs;
    }

    public void setCostCurs(double costCurs) {
        this.costCurs = costCurs;
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
        hash += (codiCurs != null ? codiCurs.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cursos)) {
            return false;
        }
        Cursos other = (Cursos) object;
        if ((this.codiCurs == null && other.codiCurs != null) || (this.codiCurs != null && !this.codiCurs.equals(other.codiCurs))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelo.Cursos[ codiCurs=" + codiCurs + " ]";
    }
    
}
