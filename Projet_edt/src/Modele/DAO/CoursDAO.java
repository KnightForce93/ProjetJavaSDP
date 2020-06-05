/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.DAO;
import Modele.information.Cours;
import java.sql.*;
/**
 *
 * @author wass1
 */
public class CoursDAO extends DAO<Cours> {
  public CoursDAO(Connexion conn) {
    super(conn);
  }
  public Cours find(int id){
       Cours cours = new Cours();      
       String requete;
       ResultSet resultat;
      
    try {
        requete= "SELECT nom FROM cours WHERE id = " + id;
        resultat=this.connect.remplirChampsRequete(requete);
         if(resultat.first()){
            cours = new Cours(id,resultat.getString("nom"));
         }
        
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return cours;
  }
  }

