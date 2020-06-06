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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.event.MenuListener;

/**
 *
 * @author thomaspopielski
 */
public class TopBar extends JFrame{
    
    private JPanel p0, p1;
    
    private static JButton btn1, btn2;
    
    private JMenu recap1;
    private JMenuItem recap, edt, r;
    
     //Constructeur 
    public TopBar (JPanel contentPanel1, JPanel contentPanel2 )
    {
        p0 = new JPanel();
        p1 = new JPanel();
        
        p0.setLayout(new GridLayout(1, 1));
        
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
        
        menuBar1.setLayout(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        
       
        /*
        JMenu edt = new JMenu ("<html>"
             + "<div style=\"color: green; \">"
             + "Emploi du temps</div></html>");
        */
       
            edt = new JMenuItem("<html>"
             + "<div style=\"color: green;\">"
             + "Emploi du temps</div></html>");
            edt.setBackground(new Color(250, 250, 250));
            
            gbc.gridx = 0;
            gbc.gridy = 0;
                    //La taille en hauteur et en largeur
            gbc.gridheight = 1;
            gbc.gridwidth = 1;
            menuBar1.add(edt, gbc);
            
            recap = new JMenuItem("<html>"
             + "<div style=\"color: green; \">"
             + "Recapitulatif des cours</div></html>");
            recap.setBackground(new Color(250, 250, 250));
                    
            gbc.gridx = 1;
            gbc.gridy = 0;
                    //La taille en hauteur et en largeur
            gbc.gridheight = 1;
            gbc.gridwidth = 1;
            menuBar1.add(recap, gbc); 
            
            //pour décaler les boutons à droite
            r = new JMenuItem();
            r.setPreferredSize(new Dimension(820, 20));
            r.setBackground(new Color(250, 250, 250));
            gbc.gridx = 2;
            gbc.gridy = 0;
            menuBar1.add(r, gbc); 

           
      

        recap.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
             btnRecap( e );
            }
        });
        
        edt.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
             btnEdt( e );
            }
        });
        

       //menuBar1.add(recap);
       
     
       
       
       return menuBar1;

    }
    
    private void btnRecap ( ActionEvent event )
    { 
        System.out.println("Recap bouton cliqué !");
        Recap_cours rc = new Recap_cours();
   
    }
    private void btnEdt ( ActionEvent event )
    { 
        System.out.println("EDT bouton cliqué !");
        Page p = new Page();
   
    }
    
 
    
     private JMenuBar createMenuBar()
    {
        JMenuBar menuBar = new JMenuBar();
        menuBar.setOpaque(true);
        menuBar.setBackground(Color.RED); 
        //Menu cours
        
        JMenu menuCours = new JMenu ("en grille");
        //Sous menu 
        JMenuItem menuEdt = new JMenuItem ("en grille");
        JMenuItem menuRecap = new JMenuItem ("en liste");
        
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
