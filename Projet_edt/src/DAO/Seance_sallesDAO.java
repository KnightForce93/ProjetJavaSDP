/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Modele.entite.Seance_salles;
import Modele.entite.Seance;
import java.sql.*;
/**
 *
 * @author wass1
 */
public class Seance_sallesDAO extends DAO<Seance_salles>{
     public Seance_sallesDAO(Connexion conn) {
    super(conn);
  }
  public Seance_salles find(int id){
      Seance_salles seance_salles = new Seance_salles();      
       String requete;
       ResultSet resultat;
      
    try {
        requete= "SELECT * FROM seance_salles WHERE id = " + id;
        resultat=this.connect.remplirChampsRequete(requete);
         if(resultat.first()){
            seance_salles= new Seance_salles(id,resultat.getInt("id_salle"));
         }
        
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return seance_salles; 
  }
    public boolean create(Seance_salles obj) {
    return false;
  }
   
  public boolean update(Seance_salles obj) {
    return false;
  }
}
