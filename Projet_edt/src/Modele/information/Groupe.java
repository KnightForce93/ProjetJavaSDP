/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.information;

/**
 *
 * @author wass1
 */
public class Groupe {
    private int id;
    private String nom;
    private int id_promotion;
    
    //constructeur
    public Groupe() {
         id=0;
         nom=null;
         id_promotion=0;
    }
    
    public Groupe(int id, String nom, int id_p) {
        this.id=id;
        this.nom=nom;
        this.id_promotion=id_p;
    }
    
    //getters
    public int getId() {
        return this.id;
    }
    public int getIdP() {
        return this.id_promotion;
    }
    public String getNom() {
        return this.nom;
    }
    
    //setters
    public void setId(int id) {
        this.id=id;
    }
    public void setIdP(int id) {
        this.id_promotion=id;
    }
     public void setNom(String nom) {
        this.nom=nom;
    }
}
