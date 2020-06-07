/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.entite;
import java.util.ArrayList;
/**
 *
 * @author wass1
 */
public class Seance_salles {
    private int id_seance;
    private ArrayList<Integer> id_salle;
    
    /**
     * Constructeur par défaut
     *
     */
    public Seance_salles() {
        id_seance=0;
        id_salle=new ArrayList<Integer>();
    }
    
    /**
     * Constructeur avec 2 paramètres : id_seance et id_salle
     *
     * @param id_seance
     * @param id_salle
     */
    public Seance_salles(int id_seance, ArrayList<Integer> id_salle) {
        this.id_seance=id_seance;
        this.id_salle=id_salle;
    }
    
    //getters
    public int getId_seance() {
        return this.id_seance;
    }
    public ArrayList<Integer> getId_salle() {
        return this.id_salle;
    }
    
    //setters
    public void setId_seance(int id_seance) {
        this.id_seance=id_seance;
    }
    public void setId_salle(ArrayList<Integer> id_salle) {
        this.id_salle=id_salle;
    }
}
