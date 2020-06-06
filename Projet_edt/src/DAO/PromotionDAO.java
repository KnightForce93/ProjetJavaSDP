/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Modele.entite.Promotion;
import java.sql.*;
/**
 *
 * @author wass1
 */
public class PromotionDAO extends DAO<Promotion>{
     public PromotionDAO(Connexion conn) {
    super(conn);
  }
     /**
     * Permet de trouver l'objet dans la BDD
     *
     * @param id
     * @return promotion
     * @throws SQLException
     */
  public Promotion find(int id){
      Promotion promotion = new Promotion();      
       String requete;
       ResultSet resultat;
      
    try {
        requete= "SELECT * FROM Promotion WHERE id = " + id;
        resultat=this.connect.remplirChampsRequete(requete);
         if(resultat.first()){
            promotion = new Promotion(id,resultat.getString("nom"));
         }
        
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return promotion; 
  }
}
