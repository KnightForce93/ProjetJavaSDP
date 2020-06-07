/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Modele.entite.Seance;
import Modele.entite.Seance_groupe;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author wass1
 */
public class Seance_groupeDAO extends DAO<Seance_groupe>{
    
    /**
     * Constructeur avec 1 paramètres : conn 
     *
     * @param conn
     */
    public Seance_groupeDAO(Connexion conn) {
        super(conn);
  }
     /**
     * Méthode qui permet de trouver l'objet dans la BDD
     *
     * @param id
     * @return seance_groupe
     * @throws SQLException
     */
  public Seance_groupe find(int id){
      Seance_groupe seance_groupe = new Seance_groupe();      
       String requete;
       ResultSet resultat;
       ArrayList<Integer> liste;
       liste = new ArrayList<>();
      
    try {
        requete= "SELECT * FROM Seance_groupes WHERE id_seance = '" + id + "'";
        resultat=this.connect.remplirChampsRequete(requete);
         while (resultat.next()) {
           liste.add(resultat.getInt("id_groupe"));
        }
         if(resultat.first()){
            seance_groupe= new Seance_groupe(id,liste);
         }
        
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return seance_groupe; 
  }
  
  /**
     * Méthode qui permet de trouver l'id_seance de la table dans la BDD
     *
     * @param id_g 
     * @param sem
     * @return liste
     * @throws SQLException
     */
  public ArrayList<Integer> findS(int id_g, int sem){    
       String requete;
       ResultSet resultat;
       ArrayList<Integer> liste;
       liste = new ArrayList<>();
    try {
        requete= "SELECT id_seance FROM seance_groupes, seance WHERE seance_groupes.id_seance=seance.id";
        requete=requete+" AND seance_groupes.id_groupe='" + id_g+"' AND seance.semaine='"+ sem +"'";
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
     * Méthode qui permet de créer une séance_groupes lorsque l'admin le demande
     *
     * @param obj
     * @throws SQLException
     */
    public void create(Seance_groupe obj) {
        int idS=obj.getId_seance();
        ArrayList<Integer> idG=obj.getId_groupe();
        
        String requete;
        ResultSet resultat;

              try {
                  for(int i : idG) {
                      requete= "INSERT INTO Seance_groupes (id_seance, id_groupe) VALUES ('" + idS + "','" + idG.get(i) + "')";
                      resultat=this.connect.remplirChampsRequete(requete);
                  /*
                  if(resultat.first()){
                      seance = new Seance(id,resultat.getInt("semaine"),resultat.getString("date"),resultat.getString("heure_debut"),resultat.getString("heure_fin"),resultat.getInt("etat"),resultat.getInt("id_cours"),resultat.getInt("id_type"));
                  }
                  */
                  }
                   

              } catch (SQLException e) {
                   e.printStackTrace();
              }
  }
   
    /**
     * Méthode qui permet de mettre à jour une seance_groupe lorsque l'admin le demande
     *
     * @param id_seance l'id de la séance
     * @param valeur la valeur à attribuer
     */
    public void updateGrp(int id_seance, int valeur) {
    
        String requete;
              ResultSet resultat;
        try {
            requete= "UPDATE Seance_groupes SET id_groupe = '" + valeur + "' WHERE id_seance = '" + id_seance + "'";
            resultat=this.connect.remplirChampsRequete(requete);

        } catch (SQLException e) {
             e.printStackTrace();
        }
    }
}
