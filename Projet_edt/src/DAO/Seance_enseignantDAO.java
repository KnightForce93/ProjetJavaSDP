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
     public  Seance_enseignantDAO(Connexion conn) {
    super(conn);
  }
     /**
     * Permet de trouver l'objet dans la BDD
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
        requete= "SELECT * FROM Seance_enseignants WHERE id = " + id;
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
   public ArrayList<Integer> findS(int id_e, int sem){    
       String requete;
       ResultSet resultat;
       ArrayList<Integer> liste;
       liste = new ArrayList<>();
    try {
        requete= "SELECT id_seance FROM Seance_enseignants, Seance WHERE Seance_enseignants.id_seance=Seance.id";
        requete=" AND Seance_enseignants.id_enseignant = " + id_e+" AND Seance.semaine = "+ sem;
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
     * Permet de créer une séance_enseignant lorsque l'admin le demande
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
                      requete= "INSERT INTO Seance_enseignants (id_seance, id_enseignant) VALUES (" + idS + "," + idE.get(i) + ")";
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
   
  public boolean update(Seance_enseignant obj) {
    return false;
  }
}
