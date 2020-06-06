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
public class Seance_enseignant {
    private int id_seance;
    private int id_enseignant;
    
    //constructeur
    public Seance_enseignant() {
        id_seance=0;
        id_enseignant=0;
    }
    
    public Seance_enseignant(int id_seance, int id_enseignant) {
        this.id_seance=id_seance;
        this.id_enseignant=id_enseignant;
    }
    
    //getters
    public int getId_seance() {
        return this.id_seance;
    }
    public int getId_enseignant() {
        return this.id_enseignant;
    }
    
    //setters
    public void setId_seance(int id_seance) {
        this.id_seance=id_seance;
    }
    public void setId_enseignant(int id_enseignant) {
        this.id_enseignant=id_enseignant;
    }
}
