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
public class Etudiant {
    private int id_utilisateur;
    private int numero;
    private int id_groupe;
    
    //constructeur
    public Etudiant() {
         id_utilisateur=0;
         numero=0;
         id_groupe=0;
    }
    
    public Etudiant(int id_u, int num, int id_g) {
        this.id_utilisateur=id_u;
        this.numero=num;
        this.id_groupe=id_g;
    }
    
    //getters
    public int getIdU() {
        return this.id_utilisateur;
    }
    public int getIdG() {
        return this.id_groupe;
    }
    public int getNum() {
        return this.numero;
    }
    
    //setters
    public void setIdU(int id) {
        this.id_utilisateur=id;
    }
    public void setIdG(int id) {
        this.id_groupe=id;
    }
     public void setNum(int num) {
        this.numero=num;
    }
}
