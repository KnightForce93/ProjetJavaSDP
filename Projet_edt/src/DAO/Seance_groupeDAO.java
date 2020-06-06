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
     public Seance_groupeDAO(Connexion conn) {
    super(conn);
  }
     /**
     * Permet de trouver l'objet dans la BDD
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
        requete= "SELECT * FROM Seance_groupes WHERE id = '" + id + "'";
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
  
  public ArrayList<Integer> findS(int id_g, int sem){    
       String requete;
       ResultSet resultat;
       ArrayList<Integer> liste;
       liste = new ArrayList<>();
    try {
        requete= "SELECT id_seance FROM Seance_groupes, Seance WHERE Seance_groupes.id_seance=Seance.id";
        requete=" AND Seance_groupes.id_groupe = '" + id_g+"' AND Seance.semaine = '"+ sem +"'";
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
     * Permet de créer une séance_groupes lorsque l'admin le demande
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
   
  public boolean update(Seance_groupe obj) {
    return false;
  }
}
