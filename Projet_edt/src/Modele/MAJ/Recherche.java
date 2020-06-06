/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.MAJ;
import java.util.ArrayList;
import DAO.*;
import Modele.entite.*;
/**
 *
 * @author wass1
 */
public class Recherche {
    ArrayList<String> EdtEtudiant(int sem, int id, Connexion con){
         ArrayList<String> Edt= new ArrayList<String>();
         EtudiantDAO etudiantdao= new EtudiantDAO(con);
         Etudiant etudiant = new Etudiant();
         etudiant= etudiantdao.find(id);
         GroupeDAO groupedao= new GroupeDAO(con);
         Groupe groupe = new Groupe();
         groupe=groupedao.find(etudiant.getIdG());
         Seance_groupeDAO seance_groupedao= new Seance_groupeDAO(con);
         ArrayList<Integer> Liste_seance = new ArrayList<Integer>();
         Liste_seance=seance_groupedao.findS(groupe.getId(),sem);
         
         SeanceDAO seanceDAO= new SeanceDAO(con);
         Seance seance= new Seance();
         Seance_sallesDAO seance_sallesdao= new Seance_sallesDAO(con);
         Seance_salles seance_salles= new Seance_salles();
         Seance_enseignantDAO seance_enseignantdao= new Seance_enseignantDAO(con);
         Seance_enseignant seance_enseignant= new Seance_enseignant();
         UtilisateurDAO utilisateurdao= new UtilisateurDAO(con);
         Utilisateur utilisateur= new Utilisateur();
         SalleDAO salledao= new SalleDAO(con);
         Salle salle= new Salle();
         CoursDAO coursdao= new CoursDAO(con);
         Cours cours = new Cours();
         Type_coursDAO type_coursdao = new Type_coursDAO(con);
         Type_cours type_cours = new Type_cours();
         SiteDAO sitedao= new SiteDAO(con);
         Site site= new Site();
         String donnee="";
         
         for( int i: Liste_seance){
          seance=seanceDAO.find(i);
          seance_salles=seance_sallesdao.find(i);
          salle=salledao.find(seance_salles.getId_salle());
          site=sitedao.find(salle.getIdS());
          cours=coursdao.find(seance.getIdC());
          type_cours=type_coursdao.find(seance.getIdT());
          seance_enseignant=seance_enseignantdao.find(i);
          utilisateur=utilisateurdao.find(seance_enseignant.getId_enseignant());
          
          donnee = seance.getDate()+",";
          donnee = donnee+ seance.getHD()+",";
          donnee = donnee+ seance.getHF()+",";
          donnee = donnee+ salle.getNom()+",";
          donnee = donnee+ site.getNom()+",";
          donnee = donnee+ cours.getNom()+",";
          donnee = donnee+ type_cours.getNom()+",";
          donnee = donnee+ utilisateur.getNom()+",";
          donnee = donnee+ groupe.getNom()+",";
          Edt.add(donnee);
          donnee="";
         }
        return Edt;
    }
    
  
}
