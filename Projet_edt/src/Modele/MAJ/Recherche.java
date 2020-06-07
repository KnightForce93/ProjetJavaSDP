/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.MAJ;
import java.util.ArrayList;
import DAO.*;
import Modele.entite.*;
import DAO.Connexion;
/**
 *
 * @author wass1
 */
public class Recherche {
    
    private Connexion con;
    
    public Recherche(Connexion co)
    {
        this.con = co;
    
    }
    
    public Utilisateur ConnexionU(String email, String mdp){
         UtilisateurDAO utilisateurdao= new UtilisateurDAO(con);
         Utilisateur utilisateur= new Utilisateur();
         utilisateur=utilisateurdao.finds(email, mdp);
         return utilisateur;
    }
    public ArrayList<String> SalleT(){
         SalleDAO salledao= new SalleDAO(con);
         Salle salle= new Salle();
         String donnee;
         ArrayList<String> Dsalle=new ArrayList();
         ArrayList<Integer> Idsalles=new ArrayList();
         Idsalles=salledao.findAll();
         for(int id: Idsalles){
           salle=salledao.find(id);
           donnee=salle.getNom()+","+ salle.getCapacite()+","+  salle.getIdS();
           Dsalle.add(donnee);
         }
         return Dsalle;
    }
    public ArrayList<String> EdtEtudiant(int sem, int id){
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
         Seance_groupe seance_groupe= new Seance_groupe();
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
         ArrayList<String> listesalle;
         listesalle = new ArrayList<>();
         for( int i: Liste_seance){
             
          seance=seanceDAO.find(i);
          seance_salles=seance_sallesdao.find(i);
          for(int ls:seance_salles.getId_salle()){
          salle=salledao.find(ls);
          listesalle.add(salle.getNom());
          site=sitedao.find(salle.getIdS());
          }
          
          cours=coursdao.find(seance.getIdC());
          type_cours=type_coursdao.find(seance.getIdT());
          ArrayList<String> listeenseignant;
          listeenseignant= new ArrayList<>();
          seance_enseignant=seance_enseignantdao.find(i);
          
          for(int le:seance_enseignant.getId_enseignant()){
          utilisateur=utilisateurdao.find(le);
          listeenseignant.add(utilisateur.getNom());
          }
         
          ArrayList<String> listegroupe;
          listegroupe= new ArrayList<>();
          seance_groupe=seance_groupedao.find(i);
          for(int le:seance_groupe.getId_groupe()){
          groupe=groupedao.find(le);
          listegroupe.add(groupe.getNom());
          }
          
          donnee = seance.getDate()+",";
          donnee = donnee+ seance.getHD()+",";
          donnee = donnee+ seance.getHF()+",";
          donnee = donnee+ listesalle.get(0);
          for (String ls:listesalle){
              if(!ls.equals(listesalle.get(0))){
                donnee=donnee+"+"+ ls;  
              }
          }
          donnee=donnee+ ",";
          donnee = donnee+ site.getNom()+",";
          donnee = donnee+ cours.getNom()+",";
          donnee = donnee+ type_cours.getNom()+",";
          donnee = donnee+ listeenseignant.get(0);
          for (String le:listeenseignant){
              if(!le.equals(listeenseignant.get(0))){
                donnee=donnee+"+"+ le;  
              }
          }
          donnee=donnee+ ",";
          donnee = donnee+ listegroupe.get(0);
          for (String lg:listegroupe){
              if(!lg.equals(listegroupe.get(0))){
                donnee=donnee+"+"+ lg;  
              }
          }
          Edt.add(donnee);
          donnee="";
         }
        return Edt;
    }
    
     public ArrayList<String> EdtEnseignant(int sem, int id){
         ArrayList<String> Edt= new ArrayList<String>();
         Seance_enseignantDAO seance_enseignantdao= new Seance_enseignantDAO(con);
         Seance_enseignant seance_enseignant = new Seance_enseignant();
         ArrayList<Integer> Liste_seance = new ArrayList<Integer>();
         Liste_seance=seance_enseignantdao.findS(id,sem);
         
      
         SeanceDAO seanceDAO= new SeanceDAO(con);
         Seance seance= new Seance();
         Seance_sallesDAO seance_sallesdao= new Seance_sallesDAO(con);
         Seance_salles seance_salles= new Seance_salles();
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
         Groupe groupe = new Groupe();
         GroupeDAO groupedao = new GroupeDAO(con);
         Seance_groupe  seance_groupe =new  Seance_groupe();
         Seance_groupeDAO seance_groupedao= new Seance_groupeDAO(con);
         String donnee="";
         ArrayList<String> listesalle;
         listesalle = new ArrayList<>();
         for( int i: Liste_seance){
          seance=seanceDAO.find(i);
          seance_salles=seance_sallesdao.find(i);
         
          for(int ls:seance_salles.getId_salle()){
          salle=salledao.find(ls);
          listesalle.add(salle.getNom());
          site=sitedao.find(salle.getIdS());
          }
          
          cours=coursdao.find(seance.getIdC());
          type_cours=type_coursdao.find(seance.getIdT());
          
          ArrayList<String> listeenseignant;
          listeenseignant= new ArrayList<>();
          seance_enseignant=seance_enseignantdao.find(i);
          for(int le:seance_enseignant.getId_enseignant()){
          utilisateur=utilisateurdao.find(le);
          listeenseignant.add(utilisateur.getNom());
          }
          
          ArrayList<String> listegroupe;
          listegroupe= new ArrayList<>();
          seance_groupe=seance_groupedao.find(i);
          for(int lg:seance_groupe.getId_groupe()){
          groupe=groupedao.find(lg);
          listegroupe.add(groupe.getNom());
          }
         
          
          donnee = seance.getDate()+",";
          donnee = donnee+ seance.getHD()+",";
          donnee = donnee+ seance.getHF()+",";
          donnee = donnee+ listesalle.get(0);
          for (String ls:listesalle){
              if(!ls.equals(listesalle.get(0))){
                donnee=donnee+"+"+ ls;  
              }
            
          }
          donnee=donnee+ ",";
          donnee = donnee+ site.getNom()+",";
          donnee = donnee+ cours.getNom()+",";
          donnee = donnee+ type_cours.getNom()+",";
          donnee = donnee+ listeenseignant.get(0);
          for (String le:listeenseignant){
              if(!le.equals(listeenseignant.get(0))){
                donnee=donnee+"+"+ le;  
              }
          }
          donnee=donnee+ ",";
          donnee = donnee+ listegroupe.get(0);
          for (String lg:listegroupe){
              if(!lg.equals(listegroupe.get(0))){
                donnee=donnee+"+"+ lg;  
              }
          }
          Edt.add(donnee);
          donnee="";
         }
        return Edt;
    }
    
     public ArrayList<String> EdtSalle (int sem, int id){
         ArrayList<String> Edt= new ArrayList<String>();
         SalleDAO Salledao= new SalleDAO(con);
         Salle salle= new Salle();
         salle= Salledao.find(id);
         Seance_sallesDAO seance_sallesdao= new Seance_sallesDAO(con);
         ArrayList<Integer> Liste_seance = new ArrayList<Integer>();
         Liste_seance=seance_sallesdao.findS(salle.getId(),sem);
         
         SeanceDAO seanceDAO= new SeanceDAO(con);
         Seance seance= new Seance();
         Seance_salles seance_salles= new Seance_salles();
         Seance_enseignantDAO seance_enseignantdao= new Seance_enseignantDAO(con);
         Seance_enseignant seance_enseignant= new Seance_enseignant();
         UtilisateurDAO utilisateurdao= new UtilisateurDAO(con);
         Utilisateur utilisateur= new Utilisateur();
         SalleDAO salledao= new SalleDAO(con);
         CoursDAO coursdao= new CoursDAO(con);
         Cours cours = new Cours();
         Type_coursDAO type_coursdao = new Type_coursDAO(con);
         Type_cours type_cours = new Type_cours();
         SiteDAO sitedao= new SiteDAO(con);
         Site site= new Site();
         Groupe groupe = new Groupe();
         GroupeDAO groupedao = new GroupeDAO(con);
         Seance_groupe  seance_groupe =new  Seance_groupe();
         Seance_groupeDAO seance_groupedao= new Seance_groupeDAO(con);
         String donnee="";
         ArrayList<String> listesalle;
         listesalle = new ArrayList<>();
         
         for( int i: Liste_seance){
          seance=seanceDAO.find(i);
          seance_salles=seance_sallesdao.find(i);
          for(int ls:seance_salles.getId_salle()){
          salle=salledao.find(ls);
          listesalle.add(salle.getNom());
          site=sitedao.find(salle.getIdS());
          }
          
          cours=coursdao.find(seance.getIdC());
          type_cours=type_coursdao.find(seance.getIdT());
          
          ArrayList<String> listeenseignant;
          listeenseignant= new ArrayList<>();
          seance_enseignant=seance_enseignantdao.find(i);
          for(int le:seance_enseignant.getId_enseignant()){
          utilisateur=utilisateurdao.find(le);
          listeenseignant.add(utilisateur.getNom());
          }
         
           ArrayList<String> listegroupe;
          listegroupe= new ArrayList<>();
          seance_groupe=seance_groupedao.find(i);
          for(int lg:seance_groupe.getId_groupe()){
          groupe=groupedao.find(lg);
          listegroupe.add(groupe.getNom());
          }
          
          donnee = seance.getDate()+",";
          donnee = donnee+ seance.getHD()+",";
          donnee = donnee+ seance.getHF()+",";
          donnee = donnee+ listesalle.get(0);
          for (String ls:listesalle){
              if(!ls.equals(listesalle.get(0))){
                donnee=donnee+"+"+ ls;  
              }
            
          }
          donnee=donnee+ ",";
          donnee = donnee+ site.getNom()+",";
          donnee = donnee+ cours.getNom()+",";
          donnee = donnee+ type_cours.getNom()+",";
          donnee = donnee+ listeenseignant.get(0);
          for (String le:listeenseignant){
              if(!le.equals(listeenseignant.get(0))){
                donnee=donnee+"+"+ le;  
              }
          }
          donnee=donnee+ ",";
          donnee = donnee+ listegroupe.get(0);
          for (String lg:listegroupe){
              if(!lg.equals(listegroupe.get(0))){
                donnee=donnee+"+"+ lg;  
              }
          }
          Edt.add(donnee);
          donnee="";
         }
        return Edt;
    }
    
     public ArrayList<String> Edtgroupe(int sem, int id){
         ArrayList<String> Edt= new ArrayList<String>();
         
         GroupeDAO groupedao= new GroupeDAO(con);
         Groupe groupe = new Groupe();
         groupe=groupedao.find(id);
         Seance_groupeDAO seance_groupedao= new Seance_groupeDAO(con);
         ArrayList<Integer> Liste_seance = new ArrayList<Integer>();
         Liste_seance=seance_groupedao.findS(groupe.getId(),sem);
         Seance_groupe seance_groupe= new Seance_groupe();
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
         ArrayList<String> listesalle;
         listesalle = new ArrayList<>();
         for( int i: Liste_seance){
             
          seance=seanceDAO.find(i);
          seance_salles=seance_sallesdao.find(i);
          for(int ls:seance_salles.getId_salle()){
          salle=salledao.find(ls);
          listesalle.add(salle.getNom());
          site=sitedao.find(salle.getIdS());
          }
          
          cours=coursdao.find(seance.getIdC());
          type_cours=type_coursdao.find(seance.getIdT());
          ArrayList<String> listeenseignant;
          listeenseignant= new ArrayList<>();
          seance_enseignant=seance_enseignantdao.find(i);
          
          for(int le:seance_enseignant.getId_enseignant()){
          utilisateur=utilisateurdao.find(le);
          listeenseignant.add(utilisateur.getNom());
          }
         
          ArrayList<String> listegroupe;
          listegroupe= new ArrayList<>();
          seance_groupe=seance_groupedao.find(i);
          for(int le:seance_groupe.getId_groupe()){
          groupe=groupedao.find(le);
          listegroupe.add(groupe.getNom());
          }
          
          donnee = seance.getDate()+",";
          donnee = donnee+ seance.getHD()+",";
          donnee = donnee+ seance.getHF()+",";
          donnee = donnee+ listesalle.get(0);
          for (String ls:listesalle){
              if(!ls.equals(listesalle.get(0))){
                donnee=donnee+"+"+ ls;  
              }
            
          }
          donnee=donnee+ ",";
          donnee = donnee+ site.getNom()+",";
          donnee = donnee+ cours.getNom()+",";
          donnee = donnee+ type_cours.getNom()+",";
          donnee = donnee+ listeenseignant.get(0);
          for (String le:listeenseignant){
              if(!le.equals(listeenseignant.get(0))){
                donnee=donnee+"+"+ le;  
              }
          }
          donnee=donnee+ ",";
          donnee = donnee+ listegroupe.get(0);
          for (String lg:listegroupe){
              if(!lg.equals(listegroupe.get(0))){
                donnee=donnee+"+"+ lg;  
              }
          }
          Edt.add(donnee);
          donnee="";
         }
        return Edt;
    }
    
  
}
