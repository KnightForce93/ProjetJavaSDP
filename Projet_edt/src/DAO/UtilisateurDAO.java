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
     /**
     * Permet de trouver l'objet dans la BDD
     *
     * @param id
     * @return utilisateur
     * @throws SQLException
     */
  public Utilisateur find(int id){
       Utilisateur utilisateur = new Utilisateur();      
       String requete;
       ResultSet resultat;
      
    try {
        requete= "SELECT * FROM Utilisateur WHERE id = '" + id + "'";
        resultat=this.connect.remplirChampsRequete(requete);
         if(resultat.first()){
            utilisateur = new Utilisateur(id,resultat.getString("email"),resultat.getString("passwd"), resultat.getString("nom"),resultat.getString("prenom"),resultat.getInt("droit"));
         }
        
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return utilisateur; 
  }
    public Utilisateur finds(String email, String mdp){
      Utilisateur utilisateur = new Utilisateur();      
       String requete;
       ResultSet resultat;
      
    try {
        
        requete="SELECT * FROM utilisateur WHERE email='"+email+"' AND passwd='"+mdp+"'";
        resultat=this.connect.remplirChampsRequete(requete);
        
         while(resultat.next()){
            utilisateur = new Utilisateur(resultat.getInt("id"),resultat.getString("email"),resultat.getString("passwd"), resultat.getString("nom"),resultat.getString("prenom"),resultat.getInt("droit"));
         }
        
    } catch (SQLException e) {
      e.printStackTrace();
    }
    System.out.println("user id="+utilisateur.getId());
    return utilisateur; 
  }
}
