/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Modele.entite.Seance_enseignant;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author wass1
 */
public class Seance_enseignantDAO extends DAO< Seance_enseignant>{
    
    /**
     * Constructeur avec 1 paramètres : conn 
     *
     * @param conn
     */
    public  Seance_enseignantDAO(Connexion conn) {
        super(conn);
  }
     /**
     * Méthode qui permet de trouver l'objet dans la BDD
     *
     * @param id
     * @return seance_enseignant
     * @throws SQLException
     */
  public  Seance_enseignant find(int id){
       Seance_enseignant seance_enseignant = new Seance_enseignant();      
       String requete;
       ResultSet resultat;
       ArrayList<Integer> liste= new ArrayList<Integer>();
      
    try {
        requete= "SELECT * FROM Seance_enseignants WHERE id_seance = '" + id + "'";
        resultat=this.connect.remplirChampsRequete(requete);
        while (resultat.next()) {
           liste.add(resultat.getInt("id_enseignant"));
        }
         if(resultat.first()){
           seance_enseignant= new Seance_enseignant(id,liste);
    }
    }catch (SQLException e) {
      e.printStackTrace();
    }
    return seance_enseignant; 
  
  }
  
  /**
     * Méthode qui permet de trouver id_seance de la table dans la BDD
     *
     * @param id_e
     * @param sem
     * @return liste
     * @throws SQLException
     */
  public ArrayList<Integer> findS(int id_e, int sem){    
       String requete;
       ResultSet resultat;
       ArrayList<Integer> liste;
       liste = new ArrayList<>();
    try {
        requete= "SELECT id_seance FROM Seance_enseignants, Seance WHERE Seance_enseignants.id_seance=Seance.id";
        requete=requete+" AND Seance_enseignants.id_enseignant = '" + id_e+"' AND Seance.semaine = '"+ sem+"'";
        resultat=this.connect.remplirChampsRequete(requete);
         
        while (resultat.next()) {
            liste.add(resultat.getInt("id_seance"));
        }
   
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return liste; 
  }
   
  /**
     * Méthode qui permet de créer une séance_enseignant lorsque l'admin le demande
     *
     * @param obj
     * @throws SQLException
     */
    public void create(Seance_enseignant obj) {
        int idS=obj.getId_seance();
        ArrayList<Integer> idE=obj.getId_enseignant();
        
        String requete;
        ResultSet resultat;

              try {
                  for(int i : idE) {
                      requete= "INSERT INTO Seance_enseignants (id_seance, id_enseignant) VALUES ('" + idS + "','" + idE.get(i) + "')";
                      resultat=this.connect.remplirChampsRequete(requete);
                  }
                   

              } catch (SQLException e) {
                   e.printStackTrace();
              }
  }
   
    /**
     * Méthode qui permet de mettre à jour une seance_enseignant lorsque l'admin le demande
     *
     * @param id_seance l'id de la séance
     * @param valeur la valeur à attribuer
     */
    public void updateEns(int id_seance, int valeur) {
    
        String requete;
              ResultSet resultat;
        try {
            requete= "UPDATE Seance_enseignants SET id_enseignant = '" + valeur + "' WHERE id_seance = '" + id_seance + "'";
            resultat=this.connect.remplirChampsRequete(requete);

        } catch (SQLException e) {
             e.printStackTrace();
        }
    }
}
