/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Modele.entite.Seance;
import java.sql.*;
/**
 *
 * @author wass1
 */
    public class SeanceDAO extends DAO<Seance>{
        
        public SeanceDAO(Connexion conn) {
            super(conn);
        }
     /**
     * Permet de trouver l'objet dans la BDD
     *
     * @param id
     * @return seance
     * @throws SQLException
     */
        public Seance find(int id){
            Seance seance = new Seance();      
             String requete;
             ResultSet resultat;

          try {
              requete= "SELECT * FROM Seance WHERE id = " + id;
              resultat=this.connect.remplirChampsRequete(requete);
               if(resultat.first()){
                  seance = new Seance(id,resultat.getInt("semaine"),resultat.getString("date"),resultat.getString("heure_debut"),resultat.getString("heure_fin"),resultat.getInt("etat"),resultat.getInt("id_cours"),resultat.getInt("id_type"));
               }

          } catch (SQLException e) {
            e.printStackTrace();
          }
          return seance; 
        }
  /**
     * Permet de créer une séance lorsque l'admin le demande
     *
     * @param obj
     * @throws SQLException
     */
        public void create(Seance obj) {
              int id=obj.getId();
              int semaine=obj.getSem();
              String date=obj.getDate();
              String hd=obj.getHD();
              String hf=obj.getHF();
              int etat=obj.getEtat();
              int idC=obj.getIdC();
              int idT=obj.getIdT();

              String requete;
              ResultSet resultat;

              try {
                  requete= "INSERT INTO Seance (id, semaine, date, heure_debut, heure_fin, etat, id_cours, id_type) VALUES (" + id + "," + semaine + "," + date + "," + hd + ","+ hf + "," + etat + ","+ idC + "," + idT + ")";
                  resultat=this.connect.remplirChampsRequete(requete);
                  /*
                  if(resultat.first()){
                      seance = new Seance(id,resultat.getInt("semaine"),resultat.getString("date"),resultat.getString("heure_debut"),resultat.getString("heure_fin"),resultat.getInt("etat"),resultat.getInt("id_cours"),resultat.getInt("id_type"));
                  }
                  */

              } catch (SQLException e) {
                   e.printStackTrace();
              }

        }
   
  public boolean update() {
    
    return false;
  }
}
