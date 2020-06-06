/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Modele.entite.Seance_salles;
import Modele.entite.Seance;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author wass1
 */
public class Seance_sallesDAO extends DAO<Seance_salles>{
     public Seance_sallesDAO(Connexion conn) {
    super(conn);
  }
  public Seance_salles find(int id){
      Seance_salles seance_salles = new Seance_salles();      
       String requete;
       ResultSet resultat;
       ArrayList<Integer> liste;
       liste = new ArrayList<>();
    try {
        requete= "SELECT * FROM seance_salles WHERE id = " + id;
        resultat=this.connect.remplirChampsRequete(requete);
         while (resultat.next()) {
           liste.add(resultat.getInt("id_salle"));
        }
         if(resultat.first()){
            seance_salles= new Seance_salles(id,liste);
         }
        
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return seance_salles; 
  }
  
   public ArrayList<Integer> findS(int id_s, int sem){    
       String requete;
       ResultSet resultat;
       ArrayList<Integer> liste;
       liste = new ArrayList<>();
    try {
        requete= "SELECT id_seance FROM seance_salles, seance WHERE seance_salles.id_seance=seance.id";
        requete=" AND seance_salles.id_salle = " + id_s+" AND seance.semaine = "+ sem;
        resultat=this.connect.remplirChampsRequete(requete);
         
        while (resultat.next()) {
            liste.add(resultat.getInt("id_seance"));
        }
   
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return liste; 
  }
   
    public boolean create(Seance_salles obj) {
    return false;
  }
   
  public boolean update(Seance_salles obj) {
    return false;
  }
}
