/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.DAO;
import Modele.information.Seance;
import java.sql.*;
/**
 *
 * @author wass1
 */
public class SeanceDAO extends DAO<Seance>{
     public SeanceDAO(Connexion conn) {
    super(conn);
  }
  public Seance find(int id){
      Seance seance = new Seance();      
       String requete;
       ResultSet resultat;
      
    try {
        requete= "SELECT * FROM seance WHERE id = " + id;
        resultat=this.connect.remplirChampsRequete(requete);
         if(resultat.first()){
            seance = new Seance(id,resultat.getInt("semaine"),resultat.getString("date"),resultat.getString("heure_debut"),resultat.getString("heure_fin"),resultat.getInt("etat"),resultat.getInt("id_cours"),resultat.getInt("id_type"));
         }
        
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return seance; 
  }
    public boolean create(Seance obj) {
    return false;
  }
   
  public boolean update(Seance obj) {
    return false;
  }
}
