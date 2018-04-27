/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Anjo
 */
@Entity
@Table(name = "resultat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Resultat.findAll", query = "SELECT r FROM Resultat r"),
    @NamedQuery(name = "Resultat.findByIdresultat", query = "SELECT r FROM Resultat r WHERE r.idresultat = :idresultat"),
    @NamedQuery(name = "Resultat.findByGolequip1", query = "SELECT r FROM Resultat r WHERE r.golequip1 = :golequip1"),
    @NamedQuery(name = "Resultat.findByGolequip2", query = "SELECT r FROM Resultat r WHERE r.golequip2 = :golequip2")})
public class Resultat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idresultat")
    private Integer idresultat;
    @Column(name = "golequip1")
    private Integer golequip1;
    @Column(name = "golequip2")
    private Integer golequip2;
    @JoinColumn(name = "idpartit", referencedColumnName = "idpartit")
    @ManyToOne(optional = false)
    private Partit idpartit;

    public Resultat() {
    }

    public Resultat(Integer idresultat) {
        this.idresultat = idresultat;
    }

    public Integer getIdresultat() {
        return idresultat;
    }

    public void setIdresultat(Integer idresultat) {
        this.idresultat = idresultat;
    }

    public Integer getGolequip1() {
        return golequip1;
    }

    public void setGolequip1(Integer golequip1) {
        this.golequip1 = golequip1;
    }

    public Integer getGolequip2() {
        return golequip2;
    }

    public void setGolequip2(Integer golequip2) {
        this.golequip2 = golequip2;
    }

    public Partit getIdpartit() {
        return idpartit;
    }

    public void setIdpartit(Partit idpartit) {
        this.idpartit = idpartit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idresultat != null ? idresultat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resultat)) {
            return false;
        }
        Resultat other = (Resultat) object;
        if ((this.idresultat == null && other.idresultat != null) || (this.idresultat != null && !this.idresultat.equals(other.idresultat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Resultat[ idresultat=" + idresultat + " ]";
    }
    
}
