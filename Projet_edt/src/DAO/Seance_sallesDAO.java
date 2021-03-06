/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Modele.entite.Seance_salles;
import Modele.entite.Seance;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author wass1
 */
public class Seance_sallesDAO extends DAO<Seance_salles>{
    
    /**
     * Constructeur avec 1 paramètres : conn 
     *
     * @param conn
     */
    public Seance_sallesDAO(Connexion conn) {
        super(conn);
  }
     /**
     * Méthode qui permet de trouver l'objet dans la BDD
     *
     * @param id
     * @return seance_salles
     * @throws SQLException
     */
  public Seance_salles find(int id){
      Seance_salles seance_salles = new Seance_salles();      
       String requete;
       ResultSet resultat;
       ArrayList<Integer> liste;
       liste = new ArrayList<>();
    try {
        requete= "SELECT * FROM Seance_salles WHERE id_seance = '" + id + "'";
        resultat=this.connect.remplirChampsRequete(requete);
         while (resultat.next()) {
           liste.add(resultat.getInt("id_salle"));
        }
         if(resultat.first()){
            seance_salles= new Seance_salles(id,liste);
         }
        
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return seance_salles; 
  }
  
  /**
     * Méthode qui permet de trouver id_seance dans la BDD
     *
     * @param id_s
     * @param sem
     * @return liste
     * @throws SQLException
     */
   public ArrayList<Integer> findS(int id_s, int sem){    
       String requete;
       ResultSet resultat;
       ArrayList<Integer> liste;
       liste = new ArrayList<>();
    try {
        requete= "SELECT id_seance FROM Seance_salles, seance WHERE Seance_salles.id_seance=Seance.id";
        requete=requete+" AND Seance_salles.id_salle = '" + id_s+"' AND Seance.semaine = '"+ sem +"'";
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
     * Méthode qui permet de créer une seance_salles lorsque l'admin le demande
     *
     * @param obj
     * @throws SQLException
     */
    public void create(Seance_salles obj) {
        int idSe=obj.getId_seance();
        ArrayList<Integer> idSa=obj.getId_salle();
        
        String requete;
        ResultSet resultat;

              try {
                  for(int i : idSa) {
                      requete= "INSERT INTO Seance_salles (id_seance, id_salle) VALUES ('" + idSe + "','" + idSa.get(i) + "')";
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
     * Méthode qui permet de mettre à jour une seance_salle lorsque l'admin le demande
     *
     * @param id_seance l'id de la séance
     * @param salleAp la valeur à attribuer
     * @param salleAv la valeur avant
     */
    public void updateSalle(int id_seance,  int salleAv, int salleAp) {
    
        String requete;
        ResultSet resultat;
        
        try {
            requete= "UPDATE Seance_salles SET id_salle = '" + salleAp + "' WHERE id_seance = '" + id_seance + "' AND id_salle = '" + salleAv + "'";
            resultat=this.connect.remplirChampsRequete(requete);

        } catch (SQLException e) {
             e.printStackTrace();
        }
    }
}
