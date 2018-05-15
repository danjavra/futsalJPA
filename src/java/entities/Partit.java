/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.time.LocalDate;

/**
 *
 * @author Anjo
 */

public class Partit {
    
    private Integer idpartit;
    private String equip1;
    private String equip2;
    private LocalDate fecha;
    

    public Partit(){

    }

    public Partit(Integer idpartit, String equip1, String equip2, LocalDate fecha) {
        this.idpartit = idpartit;
        this.equip1 = equip1;
        this.equip2 = equip2;
        this.fecha = fecha;
    }

    public Integer getIdpartit() {
        return idpartit;
    }

    public void setIdpartit(Integer idpartit) {
        this.idpartit = idpartit;
    }

    public String getEquip1() {
        return equip1;
    }

    public void setEquip1(String equip1) {
        this.equip1 = equip1;
    }

    public String getEquip2() {
        return equip2;
    }

    public void setEquip2(String equip2) {
        this.equip2 = equip2;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Partit1{" + "idpartit=" + idpartit + ", equip1=" + equip1 + ", equip2=" + equip2 + ", fecha=" + fecha + '}';
    }
    
    
    
}
