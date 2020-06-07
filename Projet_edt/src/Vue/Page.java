/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modele.MAJ.Recherche;
import Modele.entite.Utilisateur;
import Vue.Grille;
import Vue.TopBar;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

/**
 *
 * @author thomaspopielski
 */
public class Page extends JFrame{
      
    //private JButton b1, b2, b3;
    private final JPanel p0, p01, p1, nord, p2, p3, p02;
    //private JLabel t0, t1, tnord, t2,t3, ht;
    private Utilisateur user;
    private Recherche re;
    private String semaine = "10";
    private Grille g;
    
    //Top Bar
    private JPanel TopBarp0, TopBarp1;
    private JMenuItem recap, edt, r, stat, creationSeance, maj;
    private JTextField txt;
    private String nom;
        
   
    
    public Page(Utilisateur u, Recherche r)
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Quand l'utilisateur ferme la fenetre code stop, voir DISPOSE_ON_CLOSE
        setSize(1200, 800); // Taille de la fenetre
        setLocationRelativeTo(null); //La fenetre s'affiche au centre de l'écran, peu importe la taille de l'écran

        setLayout(new BorderLayout());
        setResizable(true);
        setVisible(true);
        
        user = u;
        re= r;
        nom = "";
      
        
        //Création des panels:
        p0 = new JPanel();
        p01= new JPanel();
        p1 = new JPanel();
        p02 = new JPanel();
        nord = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        
        // mise en page des panneaux
        p0.setLayout(new GridLayout(1, 1));
        p01.setLayout(new GridLayout(1, 1));
        p1.setLayout(new GridLayout(1, 50));
       // p02.setLayout(new GridLayout(1, 13));
        nord.setLayout(new GridLayout(4, 1));
        p2.setLayout(new GridLayout(1, 2));
        p3.setLayout(new GridLayout(1, 3));
        
        
         // ajout des objets graphqiues dans les panneaux
         //p0.setBackground(new Color(81, 133, 169));
        //TopBar tp = new TopBar(p0, p01, user);
        
        //ArrayList<String> tpnom = tp.getNom(); 
        
        creationSemaines(p1);
        creationMois(p02);
        
        g = new Grille(p2, user, re, semaine, nom);
        
        
        TopBar();
        
        //On ajout les deux panels p0 et p1 au Nord
        nord.add("North", p0);
        nord.add("North", p01);
        nord.add("North", p1);
        nord.add("North", p02);
        
        //Disposition des panels
        add("North", nord);
        add("Center", p2);
        add("South", p3);
        
        
        
        
    }
    
    public void creationSemaines(JPanel contentGrille)
    {
        
        JButton cell[][]= new JButton[50][2];
   
        for(int i=0; i<50; i++){
           
                if(i<22)
                {
                  
                    cell[i][1]= new JButton(""+(i+31));
                    cell[i][1].setSize(new Dimension(10, 10));
                    
                    
                    cell[i][1].addActionListener( new ActionListener()
                    {
                        public void actionPerformed(ActionEvent e) {
                            retrouveSem( e );
                        }
                    });  

              

                }
                else
                {
             
                    cell[i][1]= new JButton(""+(i-21));
                    cell[i][1].setSize(new Dimension(10, 10)); 
                    
                    cell[i][1].addActionListener( new ActionListener()
                    {
                        public void actionPerformed(ActionEvent e) {
                            retrouveSem( e );
                        }
                    });  
                }
                
                cell[i][1].setBackground(new Color(230, 229, 228));

                contentGrille.add(cell[i][1]);
                
                    
                
            }
        
    }
   
    public void retrouveSem(ActionEvent e) {

// Affichage du texte du bouton dans le JLabel lorsque le bouton est cliqué
// on peux très bien faire autre chose que ça
      this.semaine =  ((JButton)e.getSource()).getText(); 
      g = new Grille(p2, user, re, this.semaine, nom);
      g.paint();
        
    }
   
    
    
    
    public static void creationMois(JPanel ligne)
    {
        Border blackline = BorderFactory.createLineBorder(Color.black);
        JLabel mois[] =new JLabel[13];
        
        ligne.setLayout(new GridBagLayout());
        ligne.setBackground(Color.white);
        
        mois[0] = new JLabel("", SwingConstants.CENTER);
        mois[0].setPreferredSize(new Dimension(12, 31));
        
        mois[1] = new JLabel("août", SwingConstants.CENTER);
        mois[1].setPreferredSize(new Dimension(104, 31));
        
        mois[2] = new JLabel("septembre", SwingConstants.CENTER);
        mois[2].setPreferredSize(new Dimension(104, 31));
        
        mois[3] = new JLabel("octobre", SwingConstants.CENTER);
        mois[3].setPreferredSize(new Dimension(99, 31));
        
        mois[4] = new JLabel("novembre", SwingConstants.CENTER);
        mois[4].setPreferredSize(new Dimension(104, 31));
        
        mois[5] = new JLabel("decembre", SwingConstants.CENTER);
        mois[5].setPreferredSize(new Dimension(105, 31));
        
        mois[6] = new JLabel("janvier", SwingConstants.CENTER);
        mois[6].setPreferredSize(new Dimension(99, 31));
        
        mois[7] = new JLabel("février", SwingConstants.CENTER);
        mois[7].setPreferredSize(new Dimension(88, 31));
        
        mois[8] = new JLabel("mars", SwingConstants.CENTER);
        mois[8].setPreferredSize(new Dimension(99, 31));
        
        mois[9] = new JLabel("avril", SwingConstants.CENTER);
        mois[9].setPreferredSize(new Dimension(99, 31));
        
        mois[10] = new JLabel("mai", SwingConstants.CENTER);
        mois[10].setPreferredSize(new Dimension(99, 31));
        
        mois[11] = new JLabel("juin", SwingConstants.CENTER);
        mois[11].setPreferredSize(new Dimension(99, 31));
        
        mois[12] = new JLabel("juillet", SwingConstants.CENTER);
        mois[12].setPreferredSize(new Dimension(89, 31));
        
        for(int i = 0; i<13; i++)
        {
            
            //mois[i].setBackground(Color.white);
            mois[i].setBorder(blackline);
            
            ligne.add(mois[i]);
        }
        

        
        
    }
    
    
    private void TopBar()
    {
        TopBarp0 = new JPanel();
        TopBarp1 = new JPanel();
        
        
        TopBarp0.setLayout(new GridLayout(1, 1));
        
        TopBarp1.setLayout(new GridLayout(1, 3));
        
        TopBarp0.add(Haut());
        TopBarp1.add(createMenuBar());
        
        
       
        p0.add("Haut", TopBarp0);
        p01.add("Bas", TopBarp1);
        
    }
    
    private JMenuBar Haut()
    {
        int droit = user.getDroit();
        
        JMenuBar menuBar1 = new JMenuBar(); 
        
        menuBar1.setLayout(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        
       
    
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
        
      g = new Grille(p2, user, re, this.semaine, nom);
      g.paint();
      
    }
      private void btnEnseignant ( ActionEvent event )
    { 
        String recherche = new String();
        System.out.println("btnEnseignant bouton cliqué !");
        recherche = txt.getText();
        nom=recherche+","+"enseignant";
        g = new Grille(p2, user, re, this.semaine, nom);
        g.paint();
   
    }
       private void btnSalle ( ActionEvent event )
    { 
        String recherche = new String();
        System.out.println("btnSalle bouton cliqué !");
        recherche = txt.getText();
        nom=recherche+","+"salle";
        
        g = new Grille(p2, user, re, this.semaine, nom);
        g.paint();
   
    }
        private void btnGroupe ( ActionEvent event )
    { 
        String recherche = new String();
        System.out.println("btnGroupe bouton cliqué !");
        recherche = txt.getText();
        nom=recherche+","+"groupe";
        
        g = new Grille(p2, user, re, this.semaine, nom);
        g.paint();
    }
}
