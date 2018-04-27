/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author Anjo
 */
@Entity
@Table(name = "equip")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equip.findAll", query = "SELECT e FROM Equip e"),
    @NamedQuery(name = "Equip.findByNom", query = "SELECT e FROM Equip e WHERE e.nom = :nom"),
    @NamedQuery(name = "Equip.findByCiutat", query = "SELECT e FROM Equip e WHERE e.ciutat = :ciutat"),
    @NamedQuery(name = "Equip.findByTelefon", query = "SELECT e FROM Equip e WHERE e.telefon = :telefon"),
    @NamedQuery(name = "Equip.findByPunts", query = "SELECT e FROM Equip e WHERE e.punts = :punts")})
public class Equip implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nom")
    private String nom;
    @Size(max = 20)
    @Column(name = "ciutat")
    private String ciutat;
    @Column(name = "telefon")
    private Integer telefon;
    @Column(name = "punts")
    private Integer punts;
    @JoinColumn(name = "user", referencedColumnName = "username")
    @ManyToOne
    private Usuari user;
    @OneToMany(mappedBy = "equip1")
    private Collection<Partit> partitCollection;
    @OneToMany(mappedBy = "equip2")
    private Collection<Partit> partitCollection1;

    public Equip() {
    }

    public Equip(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCiutat() {
        return ciutat;
    }

    public void setCiutat(String ciutat) {
        this.ciutat = ciutat;
    }

    public Integer getTelefon() {
        return telefon;
    }

    public void setTelefon(Integer telefon) {
        this.telefon = telefon;
    }

    public Integer getPunts() {
        return punts;
    }

    public void setPunts(Integer punts) {
        this.punts = punts;
    }

    public Usuari getUser() {
        return user;
    }

    public void setUser(Usuari user) {
        this.user = user;
    }

    @XmlTransient
    public Collection<Partit> getPartitCollection() {
        return partitCollection;
    }

    public void setPartitCollection(Collection<Partit> partitCollection) {
        this.partitCollection = partitCollection;
    }

    @XmlTransient
    public Collection<Partit> getPartitCollection1() {
        return partitCollection1;
    }

    public void setPartitCollection1(Collection<Partit> partitCollection1) {
        this.partitCollection1 = partitCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nom != null ? nom.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equip)) {
            return false;
        }
        Equip other = (Equip) object;
        if ((this.nom == null && other.nom != null) || (this.nom != null && !this.nom.equals(other.nom))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Equip[ nom=" + nom + " ]";
    }
    
}
