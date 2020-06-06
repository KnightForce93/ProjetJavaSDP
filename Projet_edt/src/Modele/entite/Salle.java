/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.entite;

/**
 *
 * @author wass1
 */
public class Salle {
    private int id;
    private String nom;
    private int capacite;
    private int id_site;
    
    //constructeur
    public Salle() {
         id=0;
         nom=null;
         capacite=0;
         id_site=0;
    }
    
    public Salle(int id, String nom, int cap, int id_s) {
        this.id=id;
        this.nom=nom;
        this.capacite=cap;
        this.id_site=id_s;
    }
    
    //getters
    public int getId() {
        return this.id;
    }
    public int getIdS() {
        return this.id_site;
    }
    public int getCapacite() {
        return this.capacite;
    }
    public String getNom() {
        return this.nom;
    }
    
    //setters
    public void setId(int id) {
        this.id=id;
    }
    public void setIdS(int id) {
        this.id_site=id;
    }
    public void setCapacite(int cap) {
        this.capacite=cap;
    }
     public void setNom(String nom) {
        this.nom=nom;
    }
}
