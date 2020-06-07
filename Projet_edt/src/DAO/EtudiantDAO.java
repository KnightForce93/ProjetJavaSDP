/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Modele.entite.Etudiant;
import java.sql.*;
/**
 *
 * @author wass1
 */
public class EtudiantDAO extends DAO<Etudiant>{
    
    /**
     * Constructeur avec 1 paramètres : conn 
     *
     * @param conn
     */
    public EtudiantDAO(Connexion conn) {
        super(conn);
  }
     /**
     * Méthode qui permet de trouver l'objet dans la BDD
     *
     * @param id
     * @return etudiant
     * @throws SQLException
     */
  public Etudiant find(int id){
       Etudiant etudiant = new Etudiant();      
       String requete;
       ResultSet resultat;
      
    try {
        requete= "SELECT * FROM Etudiant WHERE id_utilisateur = '" + id + "'";
        resultat=this.connect.remplirChampsRequete(requete);
         if(resultat.first()){
            etudiant = new Etudiant(id,resultat.getInt("numero"),resultat.getInt("id_groupe"));
         }
        
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return etudiant; 
  }
  
}
