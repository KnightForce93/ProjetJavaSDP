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
public class Seance {
    private int id;
    private int semaine;
    private String date;
    private String heure_debut;
    private String heure_fin;
    private int etat;
    private int id_cours;
    private int id_type;
    
    /**
     * Constructeur par défaut
     *
     */
    public Seance() {
        id=0;
        semaine=0;
        date=null;
        heure_debut=null;
        heure_fin=null;
        etat=0;
        id_cours=0;
        id_type=0;
    }
    
    /**
     * Constructeur avec 8 paramètres : id, sem, date, heure_d, heure_f, etat, id_c et id_t
     *
     * @param id
     * @param sem
     * @param date
     * @param heure_d
     * @param heure_f
     * @param etat
     * @param id_c
     * @param id_t
     */
    public Seance(int id, int sem, String date, String heure_d, String heure_f, int etat,int id_c,int id_t) {
        this.id=id;
        this.semaine=sem;
        this.date=date;
        this.heure_debut=heure_d;
        this.heure_fin=heure_f;
        this.etat=etat;
        this.id_cours=id_c;
        this.id_type=id_t;
    }
    
    //getters
    public int getId() {
        return this.id;
    }
    public int getSem() {
        return this.semaine;
    }
    public String getDate() {
        return this.date;
    }
    public String getHD() {
        return this.heure_debut;
    }
    public String getHF() {
        return this.heure_fin;
    }
    public int getEtat() {
        return this.etat;
    }
    public int getIdC() {
        return this.id_cours;
    }
    public int getIdT() {
        return this.id_type;
    }
    
    
    //setters
    public void setId(int id) {
        this.id=id;
    }
    public void setSem(int sem) {
        this.semaine=sem;
    }
    public void setDate(String date) {
        this.date=date;
    }
    public void setHD(String hd) {
        this.heure_debut=hd;
    }
    public void setHF(String hf) {
        this.heure_fin=hf;
    }
    public void setEtat(int etat) {
        this.etat=etat;
    }
    public void setIdC(int id) {
        this.id_cours=id;
    }
    public void setIdT(int id) {
        this.id_type=id;
    }
}
