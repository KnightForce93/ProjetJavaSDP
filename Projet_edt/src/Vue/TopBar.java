/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modele.entite.Utilisateur;
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
import javax.swing.JLabel;
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

    private JMenuItem recap, edt, r, stat, creationSeance, maj;
    private Utilisateur user;
    private JTextField txt;
    private String nom;
    private Grille g;
    
     //Constructeur 
    public TopBar (JPanel contentPanel1, JPanel contentPanel2, Utilisateur user, Grille g)
    {
        p0 = new JPanel();
        p1 = new JPanel();
        
        this.user = user;
        this.g = g;
        
        
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
        int droit = user.getDroit();
        
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
            
            if(droit == 3)
            {
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
               
               
               recap.addActionListener( new ActionListener()
                {
                    public void actionPerformed(ActionEvent e) {
                     btnRecap( e );
                    }
                });
               
            }
            
            if(droit == 1)
            {
               stat = new JMenuItem("<html>"
                + "<div style=\"color: green; \">"
                + "Statistiques </div></html>");
               stat.setBackground(new Color(250, 250, 250));

               gbc.gridx = 2;
               gbc.gridy = 0;
                       //La taille en hauteur et en largeur
               gbc.gridheight = 1;
               gbc.gridwidth = 1;
               menuBar1.add(stat, gbc); 
               
             creationSeance = new JMenuItem("<html>"
                + "<div style=\"color: green; \">"
                + "Création Séance </div></html>");
               creationSeance.setBackground(new Color(250, 250, 250));

               gbc.gridx = 3;
               gbc.gridy = 0;
                       //La taille en hauteur et en largeur
               gbc.gridheight = 1;
               gbc.gridwidth = 1;
               menuBar1.add(creationSeance, gbc);
               
               maj = new JMenuItem("<html>"
                + "<div style=\"color: green; \">"
                + "Mise à jour </div></html>");
               maj.setBackground(new Color(250, 250, 250));

               gbc.gridx = 4;
               gbc.gridy = 0;
                       //La taille en hauteur et en largeur
               gbc.gridheight = 1;
               gbc.gridwidth = 1;
               menuBar1.add(maj, gbc);
            
             
            }
     
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
       // Page p = new Page();
   
    }
    
 
    
     private JMenuBar createMenuBar()
    {
        
        int droit = user.getDroit();
        
        
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
        
        menuBar.add(menuCours);

       
        String name = user.getNom()+" "+user.getPrenom();
        
        JLabel nom = new JLabel(name);
        nom.setPreferredSize(new Dimension (120, 30));
        
        
        //Ajout des menus à la page
        menuBar.add(nom);
        menuBar.add(menuCours);
        
        
        //Menu Vie Scolaire

        if(droit == 1 || droit == 2)
        {
            JMenu menuVS = new JMenu ("Données");
        //Sous menu 
        JMenuItem etudiant = new JMenuItem ("Etudiant");
        
        etudiant.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
             btnEtudiant( e );
            }
        });
        JMenuItem enseignant = new JMenuItem ("Enseignant");
        
        enseignant.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
             btnEnseignant( e );
            }
        });
        JMenuItem salle = new JMenuItem ("Salle");
        
        salle.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
             btnSalle( e );
            }
        });
        JMenuItem Groupe = new JMenuItem ("Groupe");
        
        Groupe.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
             btnGroupe( e );
            }
        });
        
        txt = new JTextField("recherche...");
        txt.setPreferredSize(new Dimension(120, 30));
        
       
        
        menuVS.add(etudiant);
        menuVS.addSeparator();
        menuVS.add(enseignant);
        menuVS.addSeparator();
        menuVS.add(salle);
        menuVS.addSeparator();
        menuVS.add(Groupe);
        menuBar.add(menuVS);
        menuBar.add(txt);
            
        }

        
        return menuBar;
        
    }
     
     private void btnEtudiant ( ActionEvent event )
    { 
        String recherche = new String();
        System.out.println("Etudiant bouton cliqué !");
        recherche = txt.getText();
        nom=recherche+","+"etudiant";
        
        System.out.println("Identifiant: "+recherche);
   
    }
      private void btnEnseignant ( ActionEvent event )
    { 
        String recherche = new String();
        System.out.println("btnEnseignant bouton cliqué !");
        recherche = txt.getText();
        nom=recherche+","+"enseignant";
        System.out.println("Identifiant: "+recherche);
   
    }
       private void btnSalle ( ActionEvent event )
    { 
        String recherche = new String();
        System.out.println("btnSalle bouton cliqué !");
        recherche = txt.getText();
        nom=recherche+","+"salle";
        System.out.println("Identifiant: "+recherche);
   
    }
        private void btnGroupe ( ActionEvent event )
    { 
        String recherche = new String();
        System.out.println("btnGroupe bouton cliqué !");
        recherche = txt.getText();
        nom=recherche+","+"groupe";
        System.out.println("Identifiant: "+recherche);
   
    }
    
}
