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
public class Type_cours {
    private int id;
    private String nom;
    
    /**
     * Constructeur par défaut
     *
     */
    public Type_cours() {
        id=0;
        nom=null;
    }
    
    /**
     * Constructeur avec 2 paramètres : id et nom
     *
     * @param id
     * @param nom
     */
    public Type_cours(int id, String nom) {
        this.id=id;
        this.nom=nom;
    }
    
    //getters
    public int getId() {
        return this.id;
    }
    public String getNom() {
        return this.nom;
    }
    
    //setters
    public void setId(int id) {
        this.id=id;
    }
    public void setNom(String nom) {
        this.nom=nom;
    }
}
