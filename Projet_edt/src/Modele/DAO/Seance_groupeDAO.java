/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.DAO;
import Modele.information.Seance;
import Modele.information.Seance_groupe;
import java.sql.*;
/**
 *
 * @author wass1
 */
public class Seance_groupeDAO extends DAO<Seance_groupe>{
     public Seance_groupeDAO(Connexion conn) {
    super(conn);
  }
  public Seance_groupe find(int id){
      Seance_groupe seance_groupe = new Seance_groupe();      
       String requete;
       ResultSet resultat;
      
    try {
        requete= "SELECT * FROM seance_groupe WHERE id = " + id;
        resultat=this.connect.remplirChampsRequete(requete);
         if(resultat.first()){
            seance_groupe= new Seance_groupe(id,resultat.getInt("id_groupe"));
         }
        
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return seance_groupe; 
  }
    public boolean create(Seance_groupe obj) {
    return false;
  }
   
  public boolean update(Seance_groupe obj) {
    return false;
  }
}
