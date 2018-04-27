/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Anjo
 */
@Entity
@Table(name = "partit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Partit.findAll", query = "SELECT p FROM Partit p"),
    @NamedQuery(name = "Partit.findByIdpartit", query = "SELECT p FROM Partit p WHERE p.idpartit = :idpartit"),
    @NamedQuery(name = "Partit.findByFecha", query = "SELECT p FROM Partit p WHERE p.fecha = :fecha")})
public class Partit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpartit")
    private Integer idpartit;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "equip1", referencedColumnName = "nom")
    @ManyToOne
    private Equip equip1;
    @JoinColumn(name = "equip2", referencedColumnName = "nom")
    @ManyToOne
    private Equip equip2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpartit")
    private Collection<Resultat> resultatCollection;

    public Partit() {
    }

    public Partit(Integer idpartit) {
        this.idpartit = idpartit;
    }

    public Integer getIdpartit() {
        return idpartit;
    }

    public void setIdpartit(Integer idpartit) {
        this.idpartit = idpartit;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Equip getEquip1() {
        return equip1;
    }

    public void setEquip1(Equip equip1) {
        this.equip1 = equip1;
    }

    public Equip getEquip2() {
        return equip2;
    }

    public void setEquip2(Equip equip2) {
        this.equip2 = equip2;
    }

    @XmlTransient
    public Collection<Resultat> getResultatCollection() {
        return resultatCollection;
    }

    public void setResultatCollection(Collection<Resultat> resultatCollection) {
        this.resultatCollection = resultatCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpartit != null ? idpartit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Partit)) {
            return false;
        }
        Partit other = (Partit) object;
        if ((this.idpartit == null && other.idpartit != null) || (this.idpartit != null && !this.idpartit.equals(other.idpartit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Partit[ idpartit=" + idpartit + " ]";
    }
    
}
