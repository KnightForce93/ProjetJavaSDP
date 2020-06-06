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
public class Seance_salles {
    private int id_seance;
    private int id_salle;
    
    //constructeur
    public Seance_salles() {
        id_seance=0;
        id_salle=0;
    }
    
    public Seance_salles(int id_seance, int id_salle) {
        this.id_seance=id_seance;
        this.id_salle=id_salle;
    }
    
    //getters
    public int getId_seance() {
        return this.id_seance;
    }
    public int getId_salle() {
        return this.id_salle;
    }
    
    //setters
    public void setId_seance(int id_seance) {
        this.id_seance=id_seance;
    }
    public void setId_salle(int id_salle) {
        this.id_salle=id_salle;
    }
}
