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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "grupos", catalog = "PARCIAL01_POO2_KevinGuevara", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grupos.findAll", query = "SELECT g FROM Grupos g"),
    @NamedQuery(name = "Grupos.findByCodiGrup", query = "SELECT g FROM Grupos g WHERE g.codiGrup = :codiGrup"),
    @NamedQuery(name = "Grupos.findByNombGrup", query = "SELECT g FROM Grupos g WHERE g.nombGrup = :nombGrup"),
    @NamedQuery(name = "Grupos.findByFechInicGrup", query = "SELECT g FROM Grupos g WHERE g.fechInicGrup = :fechInicGrup"),
    @NamedQuery(name = "Grupos.findByFechFinaGrup", query = "SELECT g FROM Grupos g WHERE g.fechFinaGrup = :fechFinaGrup"),
    @NamedQuery(name = "Grupos.findByHoraInicGrup", query = "SELECT g FROM Grupos g WHERE g.horaInicGrup = :horaInicGrup"),
    @NamedQuery(name = "Grupos.findByHoraFinaGrup", query = "SELECT g FROM Grupos g WHERE g.horaFinaGrup = :horaFinaGrup")})
public class Grupos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codi_grup")
    private Integer codiGrup;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nomb_grup")
    private String nombGrup;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fech_inic_grup")
    @Temporal(TemporalType.DATE)
    private Date fechInicGrup;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fech_fina_grup")
    @Temporal(TemporalType.DATE)
    private Date fechFinaGrup;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "hora_inic_grup")
    private String horaInicGrup;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "hora_fina_grup")
    private String horaFinaGrup;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codiGrup")
    private List<GruposAlumnos> gruposAlumnosList;
    @JoinColumn(name = "codi_prof", referencedColumnName = "codi_prof")
    @ManyToOne(optional = false)
    private Profesores codiProf;
    @JoinColumn(name = "codi_curs", referencedColumnName = "codi_curs")
    @ManyToOne(optional = false)
    private Cursos codiCurs;

    public Grupos() {
    }

    public Grupos(Integer codiGrup) {
        this.codiGrup = codiGrup;
    }

    public Grupos(Integer codiGrup, String nombGrup, Date fechInicGrup, Date fechFinaGrup, String horaInicGrup, String horaFinaGrup) {
        this.codiGrup = codiGrup;
        this.nombGrup = nombGrup;
        this.fechInicGrup = fechInicGrup;
        this.fechFinaGrup = fechFinaGrup;
        this.horaInicGrup = horaInicGrup;
        this.horaFinaGrup = horaFinaGrup;
    }

    public Integer getCodiGrup() {
        return codiGrup;
    }

    public void setCodiGrup(Integer codiGrup) {
        this.codiGrup = codiGrup;
    }

    public String getNombGrup() {
        return nombGrup;
    }

    public void setNombGrup(String nombGrup) {
        this.nombGrup = nombGrup;
    }

    public Date getFechInicGrup() {
        return fechInicGrup;
    }

    public void setFechInicGrup(Date fechInicGrup) {
        this.fechInicGrup = fechInicGrup;
    }

    public Date getFechFinaGrup() {
        return fechFinaGrup;
    }

    public void setFechFinaGrup(Date fechFinaGrup) {
        this.fechFinaGrup = fechFinaGrup;
    }

    public String getHoraInicGrup() {
        return horaInicGrup;
    }

    public void setHoraInicGrup(String horaInicGrup) {
        this.horaInicGrup = horaInicGrup;
    }

    public String getHoraFinaGrup() {
        return horaFinaGrup;
    }

    public void setHoraFinaGrup(String horaFinaGrup) {
        this.horaFinaGrup = horaFinaGrup;
    }

    @XmlTransient
    public List<GruposAlumnos> getGruposAlumnosList() {
        return gruposAlumnosList;
    }

    public void setGruposAlumnosList(List<GruposAlumnos> gruposAlumnosList) {
        this.gruposAlumnosList = gruposAlumnosList;
    }

    public Profesores getCodiProf() {
        return codiProf;
    }

    public void setCodiProf(Profesores codiProf) {
        this.codiProf = codiProf;
    }

    public Cursos getCodiCurs() {
        return codiCurs;
    }

    public void setCodiCurs(Cursos codiCurs) {
        this.codiCurs = codiCurs;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codiGrup != null ? codiGrup.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grupos)) {
            return false;
        }
        Grupos other = (Grupos) object;
        if ((this.codiGrup == null && other.codiGrup != null) || (this.codiGrup != null && !this.codiGrup.equals(other.codiGrup))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelo.Grupos[ codiGrup=" + codiGrup + " ]";
    }
    
}
