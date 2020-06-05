/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.DAO;
import Modele.information.Site;
import java.sql.*;
/**
 *
 * @author wass1
 */
public class SiteDAO extends DAO<Site>{
     public SiteDAO(Connexion conn) {
    super(conn);
  }
  public Site find(int id){
      Site site = new Site();      
       String requete;
       ResultSet resultat;
      
    try {
        requete= "SELECT * FROM site WHERE id = " + id;
        resultat=this.connect.remplirChampsRequete(requete);
         if(resultat.first()){
            site = new Site(id,resultat.getString("nom"));
         }
        
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return site; 
  }
}
