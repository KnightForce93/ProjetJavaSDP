/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Modele.entite.Type_cours;
import java.sql.*;
/**
 *
 * @author wass1
 */
public class Type_coursDAO extends DAO<Type_cours>{
     public Type_coursDAO(Connexion conn) {
    super(conn);
  }
     /**
     * Permet de trouver l'objet dans la BDD
     *
     * @param id
     * @return type_cours
     * @throws SQLException
     */
  public Type_cours find(int id){
      Type_cours type_cours = new Type_cours();      
       String requete;
       ResultSet resultat;
      
    try {
        requete= "SELECT * FROM Type_cours WHERE id = '" + id + "'";
        resultat=this.connect.remplirChampsRequete(requete);
         if(resultat.first()){
            type_cours= new Type_cours(id,resultat.getString("nom"));
         }
        
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return type_cours; 
  }
}
