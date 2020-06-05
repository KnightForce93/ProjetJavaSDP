/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

/**
 *
 * @author thomaspopielski
 */
public class TopBar extends JFrame{
    
    private JPanel p0, p1;
    
    private static JButton btn1, btn2;
    
     //Constructeur 
    public TopBar (JPanel contentPanel1, JPanel contentPanel2 )
    {
        p0 = new JPanel();
        p1 = new JPanel();
        
        p0.setLayout(new GridLayout(1, 2));
        
        p1.setLayout(new GridLayout(1, 3));
        
        p0.add(Haut());
        p1.add(createMenuBar());
        
        
       
        contentPanel1.add("Haut", p0);
        contentPanel2.add("Bas", p1);
        

     //contentPanel.add(createMenuBar());
        
    }

   
    
    
    private JMenuBar Haut()
    {
        JMenuBar menuBar1 = new JMenuBar(); 
        
        
        JMenu edt = new JMenu ("<html>"
             + "<div style=\"color: green; \">"
             + "Emploi du temps</div></html>");
        
       
       
        JMenu recap = new JMenu ("<html>"
             + "<div style=\"color: green; \">"
             + "Recapitulatif des cours</div></html>");
           
        
       menuBar1.add(edt);
        
       menuBar1.add(recap);
       
     
       
       
       return menuBar1;
        
        
        
        
     
    }
    
    
 
    
     private JMenuBar createMenuBar()
    {
        JMenuBar menuBar = new JMenuBar();
        menuBar.setOpaque(true);
        menuBar.setBackground(Color.RED); 
        //Menu cours
        
        JMenu menuCours = new JMenu ("en grille");
        //Sous menu 
        JMenuItem menuEdt = new JMenuItem ("choix 1");
        JMenuItem menuRecap = new JMenuItem ("choix 2");
        
        menuCours.add(menuEdt);
        menuCours.addSeparator();
        menuCours.add(menuRecap);
        
        menuBar.add(menuCours);
        
        //Menu Vie Scolaire
        
        JMenu menuVS = new JMenu ("Saisie du nom");
        //Sous menu 
        JMenuItem Absences = new JMenuItem ("choix 1");
        JMenuItem Intervenants = new JMenuItem ("choix 2");
        JMenuItem Scolarite = new JMenuItem ("choix 3");
        JMenuItem CalendrierScolaire = new JMenuItem ("choix 4");
        
        menuVS.add(Absences);
        menuVS.addSeparator();
        menuVS.add(Intervenants);
        menuVS.addSeparator();
        menuVS.add(Scolarite);
        menuVS.addSeparator();
        menuVS.add(CalendrierScolaire);
        
        menuBar.add(menuCours);
        
        //Barre de recherche
        
        JTextField txt = new JTextField("recherche...");
        txt.setPreferredSize(new Dimension(120, 30));
        
        
        //Ajout des menus à la page 
        menuBar.add(menuCours);
        menuBar.add(menuVS);
        menuBar.add(txt);
        
        
        
        
        
        return menuBar;
        
    }
    
}
