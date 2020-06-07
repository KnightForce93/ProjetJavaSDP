/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Modele.entite.Enseignant;
import java.sql.*;
/**
 *
 * @author wass1
 */
public class EnseignantDAO extends DAO<Enseignant>{
     
    /**
     * Constructeur avec 1 paramètres : conn 
     *
     * @param conn
     */
    public EnseignantDAO(Connexion conn) {
        super(conn);
  }
     /**
     * Méthode qui permet de trouver l'objet dans la BDD
     *
     * @param id
     * @return enseignant
     * @throws SQLException
     */
  public Enseignant find(int id){
        Enseignant enseignant = new Enseignant();      
       String requete;
       ResultSet resultat;
      
    try {
        requete= "SELECT * FROM Enseignant WHERE id_utilisateur = '" + id + "'";
        resultat=this.connect.remplirChampsRequete(requete);
         if(resultat.first()){
            enseignant = new Enseignant(id,resultat.getInt("id_cours"));
         }
        
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return enseignant;
  }
  }


