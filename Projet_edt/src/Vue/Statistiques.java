/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import DAO.Connexion;
import Modele.MAJ.Recherche;
import java.awt.*; 
import java.awt.event.*; 
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.*; 
import org.jfree.chart.*;
import org.jfree.chart.plot.*; 
import org.jfree.data.*; 
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author louisdonikian
 */
public class Statistiques extends JFrame{
    private JPanel panel; 

    /**
     * Permet d'afficher les stats
     *
     * @author J-M. DOUDOUX (inspiré de son exemple de code)
     */
  public Statistiques(int choix, Recherche r) { 
    
      //femeture de la fenetre
      addWindowListener(new WindowAdapter() { 
      public void windowClosing(WindowEvent e) { 
        dispose(); 
       // System.exit(0); 
      } 
    }); 
    panel = new JPanel(new BorderLayout()); 
    setContentPane(panel); 
    setSize(500, 350); 
    
    if(choix==1) {
           
            ArrayList<String> str= r.SalleT();
            DefaultCategoryDataset dataset = new DefaultCategoryDataset(); 

            int nbplaces=0;

            for(String s:str){

                   String[] parts = s.split(",");
                   String nom = parts[0]; 
                   int capacite = Integer.parseInt(parts[1]);
                   String id_site = parts[2]; 
                   String nom_site ="Indéterminé";


                   if(id_site.equals("1")) {
                      nom_site="E1";
                   } 
                   if(id_site.equals("2")) {
                      nom_site="E2";
                   } 
                   if(id_site.equals("3")) {
                      nom_site="E3";
                   } 
                   if(id_site.equals("4")) {
                      nom_site="E4";
                   } 
                   if(id_site.equals("5")) {
                      nom_site="E5";
                   }

                   dataset.addValue(capacite, nom, nom_site);
                   nbplaces+=capacite;
            }

            JFreeChart statBAR = ChartFactory.createBarChart("Capacité des salles", "Total : " + nbplaces + " places","Nombre de places", dataset, PlotOrientation.VERTICAL, true, true, false); 
            ChartPanel statPanel = new ChartPanel(statBAR); 
            panel.add(statPanel); 
    }
    if(choix==2) {
            
            ArrayList<String> str= new ArrayList();
            String n = "1";
            str.add(n);
            n = "1";
            str.add(n);
            n = "3";
            str.add(n);
            n = "2";
            str.add(n);
            n = "4";
            str.add(n);
            n = "6";
            str.add(n);
            n = "6";
            str.add(n);
            n = "5";
            str.add(n);
            n = "2";
            str.add(n);
            
            DefaultPieDataset dataset = new DefaultPieDataset(); 
            
            int cm=0;
            int td=0;
            int tp=0;
            int soutien=0;
            int projet=0;
            int examen=0;
            
            int nb=0;
            
            for(String s:str){

                   String[] parts = s.split(",");
                   int type = Integer.parseInt(parts[0]);
                   //String cours ="Indéterminé";

                   if(type==1) {
                      cm++;
                   } 
                   if(type==2) {
                      td++;
                   } 
                   if(type==3) {
                      tp++;
                   } 
                   if(type==4) {
                      soutien++;
                   } 
                   if(type==5) {
                      projet++;
                   }
                   if(type==6) {
                      examen++;
                   }
                   nb++;
            }
            dataset.setValue("Cours Magistraux " + cm*100/nb + "%", new Integer(cm)); 
            dataset.setValue("TD " + td*100/nb + "%", new Integer(td)); 
            dataset.setValue("TP " + tp*100/nb + "%", new Integer(tp)); 
            dataset.setValue("Soutien " + soutien*100/nb + "%", new Integer(soutien));  
            dataset.setValue("Projet " + projet*100/nb + "%", new Integer(projet));
            dataset.setValue("Examen " + examen*100/nb + "%", new Integer(examen)); 
            

            JFreeChart statCAMEM = ChartFactory.createPieChart("Répartition des matières sur l'année", dataset, true, true, true); 
            ChartPanel statPanel = new ChartPanel(statCAMEM); 
            panel.add(statPanel); 
    }
    
  } 

  public static void main(String args[]) throws SQLException, ClassNotFoundException { 
     String nameDatabase = "projetjava";
        String loginDatabase = "root"; 
        //pour mac
        String passwordDatabase = "";
        
        Connexion co = new Connexion(nameDatabase,loginDatabase, passwordDatabase);
        Recherche re= new Recherche(co);
    Statistiques bar = new Statistiques(1,re); 
    bar.setVisible(true); 
    Statistiques camembert = new Statistiques(2,re); 
    camembert.setVisible(true); 
  } 
}
