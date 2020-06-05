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
public class Enseignant {
    private int id_utilisateur;
    private int id_cours;
    
    //constructeur
    public Enseignant() {
         id_utilisateur=0;
        id_cours=0;
    }
    
    public Enseignant(int id_u, int id_c) {
        this.id_utilisateur=id_u;
        this.id_cours=id_c;
    }
    
    //getters
    public int getIdU() {
        return this.id_utilisateur;
    }
    public int getIdC() {
        return this.id_cours;
    }
    
    //setters
    public void setIdU(int id) {
        this.id_utilisateur=id;
    }
    public void setIdC(int id) {
        this.id_cours=id;
    }
}
