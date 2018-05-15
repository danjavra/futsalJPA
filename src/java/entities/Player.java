/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Anjo
 */
@Entity
@Table(name = "player")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Player.findAll", query = "SELECT p FROM Player p"),
    @NamedQuery(name = "Player.findByIdplayer", query = "SELECT p FROM Player p WHERE p.idplayer = :idplayer"),
    @NamedQuery(name = "Player.findByNom", query = "SELECT p FROM Player p WHERE p.nom = :nom"),
    @NamedQuery(name = "Player.findByPosicio", query = "SELECT p FROM Player p WHERE p.posicio = :posicio"),
    @NamedQuery(name = "Player.findByEdat", query = "SELECT p FROM Player p WHERE p.edat = :edat"),
    @NamedQuery(name = "Player.findByEquip", query = "SELECT p FROM Player p WHERE p.equip = :equip"),
    @NamedQuery(name = "Player.findByMvp", query = "SELECT p FROM Player p WHERE p.mvp = :mvp")})
public class Player implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idplayer")
    private Integer idplayer;
    @Size(max = 20)
    @Column(name = "nom")
    private String nom;
    @Size(max = 20)
    @Column(name = "posicio")
    private String posicio;
    @Column(name = "edat")
    @Temporal(TemporalType.DATE)
    private Integer edat;
    @Size(max = 20)
    @Column(name = "equip")
    private String equip;
    @Column(name = "mvp")
    private Integer mvp;
    @JoinColumn(name = "user", referencedColumnName = "username")
    @ManyToOne
    private Usuari user;

    public Player() {
    }

    public Player(Integer idplayer) {
        this.idplayer = idplayer;
    }

    public Integer getIdplayer() {
        return idplayer;
    }

    public void setIdplayer(Integer idplayer) {
        this.idplayer = idplayer;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPosicio() {
        return posicio;
    }

    public void setPosicio(String posicio) {
        this.posicio = posicio;
    }

    public Integer getEdat() {
        return edat;
    }

    public void setEdat(Integer edat) {
        this.edat = edat;
    }

    public String getEquip() {
        return equip;
    }

    public void setEquip(String equip) {
        this.equip = equip;
    }

    public Integer getMvp() {
        return mvp;
    }

    public void setMvp(Integer mvp) {
        this.mvp = mvp;
    }

    public Usuari getUser() {
        return user;
    }

    public void setUser(Usuari user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idplayer != null ? idplayer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Player)) {
            return false;
        }
        Player other = (Player) object;
        if ((this.idplayer == null && other.idplayer != null) || (this.idplayer != null && !this.idplayer.equals(other.idplayer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Player[ idplayer=" + idplayer + " ]";
    }
    
}
