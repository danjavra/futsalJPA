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
@Table(name = "usuari")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuari.findAll", query = "SELECT u FROM Usuari u"),
    @NamedQuery(name = "Usuari.findByUsername", query = "SELECT u FROM Usuari u WHERE u.username = :username"),
    @NamedQuery(name = "Usuari.findByContrasenya", query = "SELECT u FROM Usuari u WHERE u.contrasenya = :contrasenya"),
    @NamedQuery(name = "Usuari.findByTipo", query = "SELECT u FROM Usuari u WHERE u.tipo = :tipo")})
public class Usuari implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "username")
    private String username;
    @Size(max = 8)
    @Column(name = "contrasenya")
    private String contrasenya;
    @Column(name = "tipo")
    private Integer tipo;
    @OneToMany(mappedBy = "user")
    private Collection<Equip> equipCollection;
    @OneToMany(mappedBy = "user")
    private Collection<Player> playerCollection;

    public Usuari() {
    }

    public Usuari(String username) {
        this.username = username;
    }

    public Usuari(String username, String contrasenya, Integer tipo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public Collection<Equip> getEquipCollection() {
        return equipCollection;
    }

    public void setEquipCollection(Collection<Equip> equipCollection) {
        this.equipCollection = equipCollection;
    }

    @XmlTransient
    public Collection<Player> getPlayerCollection() {
        return playerCollection;
    }

    public void setPlayerCollection(Collection<Player> playerCollection) {
        this.playerCollection = playerCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuari)) {
            return false;
        }
        Usuari other = (Usuari) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Usuari[ username=" + username + " ]";
    }
    
}
