/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Modele.entite.Seance;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author wass1
 */
    public class SeanceDAO extends DAO<Seance>{
        
        /**
     * Constructeur avec 1 paramètres : conn 
     *
     * @param conn
     */
        public SeanceDAO(Connexion conn) {
            super(conn);
        }
        
     /**
     * Méthode qui permet de trouver l'objet dans la BDD
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
              requete= "SELECT * FROM Seance WHERE id = '" + id + "'";
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
     * Méthode qui permet de trouver toutes les types de cours dans la BDD
     *
     * @return liste : tous les id_types des cours
     * @throws SQLException
     */
    public ArrayList<Integer> findT(){    
       String requete;
       ResultSet resultat;
       ArrayList<Integer> liste;
       liste = new ArrayList<>();
        try {
            requete= "SELECT id_type FROM Seance ";
            resultat=this.connect.remplirChampsRequete(requete);

            while (resultat.next()) {

                liste.add(resultat.getInt("id_type"));
            }

        } catch (SQLException e) {
          e.printStackTrace();
        }
        return liste; 
  }
  
    /**
     * Méthode qui permet de créer une séance lorsque l'admin le demande
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
   
        /**
     * Méthode qui permet de mettre à jour une séance lorsque l'admin le demande
     *
     * 
     * 
     */
  public boolean update() {
    
    return false;
  }
}
