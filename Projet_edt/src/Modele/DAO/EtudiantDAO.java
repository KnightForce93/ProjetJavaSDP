/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.DAO;
import Modele.information.Etudiant;
import java.sql.*;
/**
 *
 * @author wass1
 */
public class EtudiantDAO extends DAO<Etudiant>{
     public EtudiantDAO(Connexion conn) {
    super(conn);
  }
  public Etudiant find(int id){
       Etudiant etudiant = new Etudiant();      
       String requete;
       ResultSet resultat;
      
    try {
        requete= "SELECT * FROM etudiant WHERE id = " + id;
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
