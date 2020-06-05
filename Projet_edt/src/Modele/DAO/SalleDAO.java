/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.DAO;
import Modele.information.Salle;
import java.sql.*;
/**
 *
 * @author wass1
 */
public class SalleDAO extends DAO<Salle>{
     public SalleDAO(Connexion conn) {
    super(conn);
  }
  public Salle find(int id){
      Salle salle = new Salle();      
       String requete;
       ResultSet resultat;
      
    try {
        requete= "SELECT * FROM salle WHERE id = " + id;
        resultat=this.connect.remplirChampsRequete(requete);
         if(resultat.first()){
            salle= new Salle(id,resultat.getString("nom"),resultat.getInt("capacite"),resultat.getInt("id_site"));
         }
        
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return salle; 
  }
}
