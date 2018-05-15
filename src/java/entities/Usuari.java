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
public class Usuari {

    private String username;
    private String contrasenya;
    private Integer tipo;

    public Usuari(){
        
    }

    public Usuari(String username, String contrasenya, Integer tipo) {
        this.username = username;
        this.contrasenya = contrasenya;
        this.tipo = tipo;
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

    @Override
    public String toString() {
        return "Usuari1{" + "username=" + username + ", contrasenya=" + contrasenya + ", tipo=" + tipo + '}';
    }
    
    
}
