/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Modele.entite.Seance_enseignant;
import java.sql.*;
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
      
    try {
        requete= "SELECT * FROM seance_enseignant WHERE id = " + id;
        resultat=this.connect.remplirChampsRequete(requete);
         if(resultat.first()){
            seance_enseignant= new Seance_enseignant(id,resultat.getInt("id_enseignant"));
        
    }
    }catch (SQLException e) {
      e.printStackTrace();
    }
    return seance_enseignant; 
  
  }
    public boolean create(Seance_enseignant obj) {
    return false;
  }
   
  public boolean update(Seance_enseignant obj) {
    return false;
  }
}
