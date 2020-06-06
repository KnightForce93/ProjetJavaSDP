/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Modele.entite.Enseignant;
import java.sql.*;
/**
 *
 * @author wass1
 */
public class EnseignantDAO extends DAO<Enseignant>{
     public EnseignantDAO(Connexion conn) {
    super(conn);
  }
  public Enseignant find(int id){
        Enseignant enseignant = new Enseignant();      
       String requete;
       ResultSet resultat;
      
    try {
        requete= "SELECT * FROM enseignant WHERE id = " + id;
        resultat=this.connect.remplirChampsRequete(requete);
         if(resultat.first()){
            enseignant = new Enseignant(id,resultat.getInt("id_cours"));
         }
        
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return enseignant;
  }
  }


