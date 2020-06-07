/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Modele.entite.Salle;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author wass1
 */
public class SalleDAO extends DAO<Salle>{
    
    /**
     * Constructeur avec 1 paramètres : conn 
     *
     * @param conn
     */
    public SalleDAO(Connexion conn) {
        super(conn);
  }
     /**
     * Méthode qui permet de trouver l'objet dans la BDD
     *
     * @param id
     * @return salle
     * @throws SQLException
     */
  public Salle find(int id){
      Salle salle = new Salle();      
       String requete;
       ResultSet resultat;
      
    try {
        requete= "SELECT * FROM Salle WHERE id = '" + id + "'";
        resultat=this.connect.remplirChampsRequete(requete);
         if(resultat.first()){
            salle= new Salle(id,resultat.getString("nom"),resultat.getInt("capacite"),resultat.getInt("id_site"));
         }
        
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return salle; 
  }
  /**
     * Méthode qui permet de trouver toutes les salles dans la BDD
     *
     * @return liste : tous les id des salles
     * @throws SQLException
     */
  public ArrayList<Integer> findAll(){    
       String requete;
       ResultSet resultat;
       ArrayList<Integer> liste;
       liste = new ArrayList<>();
    try {
        requete= "SELECT * FROM Salle ";
        resultat=this.connect.remplirChampsRequete(requete);
         
        while (resultat.next()) {
            
            liste.add(resultat.getInt("id"));
        }
   
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return liste; 
  }
  
}
