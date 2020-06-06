/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Modele.entite.Utilisateur;
import java.sql.*;
/**
 *
 * @author wass1
 */
public class UtilisateurDAO extends DAO<Utilisateur>{
     public UtilisateurDAO(Connexion conn) {
    super(conn);
  }
  public Utilisateur find(int id){
      Utilisateur utilisateur = new Utilisateur();      
       String requete;
       ResultSet resultat;
      
    try {
        requete= "SELECT * FROM utilisateur WHERE id = " + id;
        resultat=this.connect.remplirChampsRequete(requete);
         if(resultat.first()){
            utilisateur = new Utilisateur(id,resultat.getString("email"),resultat.getString("password"), resultat.getString("nom"),resultat.getString("prenom"),resultat.getInt("droit"));
         }
        
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return utilisateur; 
  }
}
