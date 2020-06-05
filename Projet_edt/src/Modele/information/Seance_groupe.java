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
public class Seance_groupe {
    private int id_seance;
    private int id_groupe;
    
    //constructeur
    public Seance_groupe() {
        id_seance=0;
        id_groupe=0;
    }
    
    public Seance_groupe(int id_seance, int id_groupe) {
        this.id_seance=id_seance;
        this.id_groupe=id_groupe;
    }
    
    //getters
    public int getId_seance() {
        return this.id_seance;
    }
    public int getId_groupe() {
        return this.id_groupe;
    }
    
    //setters
    public void setId_seance(int id_seance) {
        this.id_seance=id_seance;
    }
    public void setId_groupe(int id_groupe) {
        this.id_groupe=id_groupe;
    }
}
