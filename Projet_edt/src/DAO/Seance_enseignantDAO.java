/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Modele.entite.Seance_enseignant;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author wass1
 */
public class Seance_enseignantDAO extends DAO< Seance_enseignant>{
     public  Seance_enseignantDAO(Connexion conn) {
    super(conn);
  }
  public  Seance_enseignant find(int id){
       Seance_enseignant seance_enseignant = new Seance_enseignant();      
       String requete;
       ResultSet resultat;
       ArrayList<Integer> liste= new ArrayList<Integer>();
      
    try {
        requete= "SELECT * FROM seance_enseignant WHERE id = " + id;
        resultat=this.connect.remplirChampsRequete(requete);
         while (resultat.next()) {
           liste.add(resultat.getInt("id_enseignant"));
        }
         if(resultat.first()){
           seance_enseignant= new Seance_enseignant(id,liste);
    }
    }catch (SQLException e) {
      e.printStackTrace();
    }
    return seance_enseignant; 
  
  }
   public ArrayList<Integer> findS(int id_e, int sem){    
       String requete;
       ResultSet resultat;
       ArrayList<Integer> liste;
       liste = new ArrayList<>();
    try {
        requete= "SELECT id_seance FROM seance_enseignant, seance WHERE seance_enseignant.id_seance=seance.id";
        requete=" AND seance_groupeenseignant.id_enseignant = " + id_e+" AND seance.semaine = "+ sem;
        resultat=this.connect.remplirChampsRequete(requete);
         
        while (resultat.next()) {
            liste.add(resultat.getInt("id_seance"));
        }
   
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return liste; 
  }
   
    public boolean create(Seance_enseignant obj) {
    return false;
  }
   
  public boolean update(Seance_enseignant obj) {
    return false;
  }
}
