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
public class Equip {
    
    private String nom;
    private String ciutat;
    private Integer telefon;
    private Integer punts;
    private Usuari user;

    public Equip(){
        
    }

    public Equip(String nom, String ciutat, Integer telefon, Integer punts, Usuari user) {
        this.nom = nom;
        this.ciutat = ciutat;
        this.telefon = telefon;
        this.punts = punts;
        this.user = user;
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

    @Override
    public String toString() {
        return "Equip1{" + "nom=" + nom + ", ciutat=" + ciutat + ", telefon=" + telefon + ", punts=" + punts + ", user=" + user + '}';
    }
    
}
