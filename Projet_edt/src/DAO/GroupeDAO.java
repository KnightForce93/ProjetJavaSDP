/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Modele.entite.Groupe;
import java.sql.*;
/**
 *
 * @author wass1
 */
public class GroupeDAO extends DAO<Groupe>{
     public GroupeDAO(Connexion conn) {
    super(conn);
  }
     /**
     * Permet de trouver l'objet dans la BDD
     *
     * @param id
     * @return groupe
     * @throws SQLException
     */
  public Groupe find(int id){
       Groupe groupe = new Groupe();      
       String requete;
       ResultSet resultat;
       
    try {
        requete= "SELECT * FROM Groupe WHERE id = " + id;
        resultat=this.connect.remplirChampsRequete(requete);
         if(resultat.first()){
            groupe = new Groupe(id,resultat.getString("nom"),resultat.getInt("id_promotion"));
         }
        
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return groupe; 
  }
}
