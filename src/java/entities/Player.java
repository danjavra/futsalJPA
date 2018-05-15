/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Anjo
 */
public class Player {
    
    private Integer idplayer;
    private String nom;
    private String posicio;
    private Integer edat;
    private Equip equip;
    private Integer mvp;
    private Usuari user;
    
    
    public Player(){
        
    }

    public Player(Integer idplayer, String nom, String posicio, Integer edat, Equip equip, Integer mvp, Usuari user) {
        this.idplayer = idplayer;
        this.nom = nom;
        this.posicio = posicio;
        this.edat = edat;
        this.equip = equip;
        this.mvp = mvp;
        this.user = user;
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

    public Equip getEquip() {
        return equip;
    }

    public void setEquip(Equip equip) {
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
    public String toString() {
        return "Player1{" + "idplayer=" + idplayer + ", nom=" + nom + ", posicio=" + posicio + ", edat=" + edat + ", equip=" + equip + ", mvp=" + mvp + ", user=" + user + '}';
    }
    
}
