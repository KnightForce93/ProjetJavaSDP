/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Modele.entite.Cours;
import java.sql.*;
/**
 *
 * @author wass1
 */
public class CoursDAO extends DAO<Cours> {
  
    /**
     * Constructeur avec 1 paramètres : conn 
     *
     * @param conn
     */
    public CoursDAO(Connexion conn) {
    super(conn);
  }
  /**
     * Méthode qui permet de trouver l'objet dans la BDD
     *
     * @param id
     * @return cours
     * @throws SQLException
     */
  public Cours find(int id){
       Cours cours = new Cours();      
       String requete;
       ResultSet resultat;
      
    try {
        requete= "SELECT nom FROM Cours WHERE id = '" + id + "'";
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

