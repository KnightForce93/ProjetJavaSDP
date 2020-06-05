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
public class Utilisateur {
    private int id;
    private String email;
    private String password;
    private String nom;
    private String prenom;
    private int droit;
    
    //constructeurs
    public Utilisateur() {
        id=0;
        email=null;
        password=null;
        nom=null;
        prenom=null;
        droit=0;
    }
    public Utilisateur(int id, String email, String password, String nom,String prenom, int droit) {
        this.id=id;
        this.email=email;
        this.password=password;
        this.nom=nom;
        this.prenom=prenom;
        this.droit=droit;
    }
    
    //getters
    public int getId() {
        return this.id;
    }
    public String getEmail() {
        return this.email;
    }
    public String getPassword() {
        return this.password;
    }
    public String getNom() {
        return this.nom;
    }
    public String getPrenom() {
        return this.prenom;
    }
    public int getDroit() {
        return this.droit;
    }
    
    
    //setters
    public void setId(int id) {
        this.id=id;
    }
    public void setEmail(String email) {
        this.email=email;
    }
    public void setPassword(String password) {
        this.password=password;
    }
    public void setNom(String nom) {
        this.nom=nom;
    }
    public void setPrenom(String prenom) {
        this.prenom=prenom;
    }
    public void setDroit(int droit) {
        this.droit=droit;
    }
}
