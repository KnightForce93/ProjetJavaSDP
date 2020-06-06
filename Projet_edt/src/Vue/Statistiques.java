/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import java.awt.*; 
import java.awt.event.*; 
import java.util.ArrayList;
import javax.swing.*; 
import org.jfree.chart.*;
import org.jfree.chart.plot.*; 
import org.jfree.data.*; 
import org.jfree.data.category.DefaultCategoryDataset;

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
  public Statistiques() { 
    addWindowListener(new WindowAdapter() { 
      public void windowClosing(WindowEvent e) { 
        dispose(); 
        System.exit(0); 
      } 
    }); 
    panel = new JPanel(new BorderLayout()); 
    setContentPane(panel); 
    setSize(500, 350); 
    
    ArrayList<String> str= new ArrayList();
    String n = "P305,70,2";
    str.add(n);
    n = "EM210,100,1";
    str.add(n);
    n = "P446,47,2";
    str.add(n);
    n = "C110,30,3";
    str.add(n);
    n = "G010,80,4";
    str.add(n);
    
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
   
    JFreeChart barChart = ChartFactory.createBarChart("Capacité des salles", "Total : " + nbplaces + " places","Nombre de places", dataset, PlotOrientation.VERTICAL, true, true, false); 
    ChartPanel cPanel = new ChartPanel(barChart); 
    panel.add(cPanel); 
  } 

  public static void main(String args[]) { 
    Statistiques stat = new Statistiques(); 
    stat.setVisible(true); 
  } 
}
