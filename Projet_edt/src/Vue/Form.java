/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modele.MAJ.Recherche;
import Modele.entite.Utilisateur;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author louisdonikian
 */
public class Form extends JFrame{
    private JPanel nord,centre;
    private JLabel connexion, semaine, date, hd, hf, etat, prof, salle, groupe, id;
    private  MyButton btnco, btnsem, btndate, btnhd, btnhf, btnetat, btnprof, btnsalle, btngroupe;
    private  JTextField semainetxt, datetxt, hdtxt, hftxt, etattxt, proftxt, salletxt, groupetxt, idtxt;
    private Recherche r;
    
    /**
     * Constructeur avec 1 paramètres : re
     *
     * @param re
     */
    public Form(Recherche re)
    {
        this.setTitle("Création Séance");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.r = re;

         setResizable(true);
         setVisible(true);

         connexion = new JLabel("<html>"
                 + "<div style=\"color: white; text-align: center;\">"
                 + "<h1>Page de création de séance</h1></div></html>");

         //Création des panels:
          nord = new JPanel();
          centre = new JPanel();

          nord.setBackground(new Color(81, 133, 169));
          centre.setBackground(new Color(95, 150, 187));

          nord.add(connexion);
          modifForm(centre);

          //Disposition des panels
            add("North", nord);
            add("Center", centre);  
    } 
   /**
     * Méthode qui permet de créer une nouvelle séance
     *
     * @param center 
     */
   private  void creationForm(JPanel centre)
   {
    //On définit le layout manager
    centre.setLayout(new GridBagLayout());

      semainetxt = new JTextField();
      semainetxt.setPreferredSize(new Dimension(120, 40));
      
      datetxt = new JTextField();
      datetxt.setPreferredSize(new Dimension(120, 40));
      
      hdtxt = new JTextField();
      hdtxt.setPreferredSize(new Dimension(120, 40));
      
      hftxt = new JTextField();
      hftxt.setPreferredSize(new Dimension(120, 40));
      
      etattxt = new JTextField();
      etattxt.setPreferredSize(new Dimension(120, 40));
      
      proftxt = new JTextField();
      proftxt.setPreferredSize(new Dimension(120, 40));
      
      salletxt = new JTextField();
      salletxt.setPreferredSize(new Dimension(120, 40));
      
      groupetxt = new JTextField();
      groupetxt.setPreferredSize(new Dimension(120, 40));
    //  mdptxt.setBorder(new LineBorder(Color.RED, 2)); couleur des bordures

      btnco = new MyButton("<html>"
             + "<div style=\"color: black;\">"
             + "Créer</div></html>");
      
      semaine = new JLabel("<html>"
             + "<div style=\"color: white; text-align: center;\">"
             + "<h3>Semaine </h3></div></html>");
      semaine.setPreferredSize(new Dimension(120, 40));
      
      date = new JLabel("<html>"
             + "<div style=\"color: white; text-align: center;\">"
             + "<h3>Date </h3></div></html>");
      date.setPreferredSize(new Dimension(120, 40));
      
      hd = new JLabel("<html>"
             + "<div style=\"color: white; text-align: center;\">"
             + "<h3>Heure de début </h3></div></html>");
      hd.setPreferredSize(new Dimension(120, 40));
      
      hf = new JLabel("<html>"
             + "<div style=\"color: white; text-align: center;\">"
             + "<h3>Heure de fin </h3></div></html>");
      hf.setPreferredSize(new Dimension(120, 40));
      
      etat = new JLabel("<html>"
             + "<div style=\"color: white; text-align: center;\">"
             + "<h3>Etat </h3></div></html>");
      etat.setPreferredSize(new Dimension(120, 40));
      
      prof = new JLabel("<html>"
             + "<div style=\"color: white; text-align: center;\">"
             + "<h3>Enseignant </h3></div></html>");
      prof.setPreferredSize(new Dimension(120, 40));
      
      salle = new JLabel("<html>"
             + "<div style=\"color: white; text-align: center;\">"
             + "<h3>Salle </h3></div></html>");
      salle.setPreferredSize(new Dimension(120, 40));
      
      groupe = new JLabel("<html>"
             + "<div style=\"color: white; text-align: center;\">"
             + "<h3>Groupe </h3></div></html>");
      groupe.setPreferredSize(new Dimension(120, 40));
      
      /*
      btnco.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                try {
                    connexionTest( e );
                } catch (SQLException ex) {
                    
                } catch (ClassNotFoundException ex) {
                    
                }
            }
        });*/

     //L'objet servant à positionner les composants
    GridBagConstraints gbc = new GridBagConstraints();
    
    //SEMAINE
    gbc.gridx = 0;
    gbc.gridy = 0;
    //La taille en hauteur et en largeur
    gbc.gridheight = 1;
    gbc.gridwidth = 1;
    centre.add(semaine, gbc);
    //---------------------------------------------
    gbc.gridx = 1;
    centre.add(semainetxt, gbc);
    //---------------------------------------------
    //Cette instruction informe le layout que c'est une fin de ligne
    gbc.gridwidth = GridBagConstraints.REMAINDER;

    //---------------------------------------------
    //DATE
    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    centre.add(date, gbc);   
    gbc.gridx = 1;
    centre.add(datetxt, gbc);
    gbc.gridwidth = GridBagConstraints.REMAINDER;
    
    //HD
    gbc.gridx = 0;
    gbc.gridy = 2;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    centre.add(hd, gbc);  
    gbc.gridx = 1;
    centre.add(hdtxt, gbc);
    gbc.gridwidth = GridBagConstraints.REMAINDER;
    
    //HF
    gbc.gridx = 0;
    gbc.gridy = 3;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    centre.add(hf, gbc);  
    gbc.gridx = 1;
    centre.add(hftxt, gbc);
    gbc.gridwidth = GridBagConstraints.REMAINDER;
    
    //ETAT
    gbc.gridx = 0;
    gbc.gridy = 4;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    centre.add(etat, gbc);  
    gbc.gridx = 1;
    centre.add(etattxt, gbc);
    gbc.gridwidth = GridBagConstraints.REMAINDER;
    
    //PROF
    gbc.gridx = 0;
    gbc.gridy = 5;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    centre.add(prof, gbc);  
    gbc.gridx = 1;
    centre.add(proftxt, gbc);
    gbc.gridwidth = GridBagConstraints.REMAINDER;
    
    //SALLE
    gbc.gridx = 0;
    gbc.gridy = 6;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    centre.add(salle, gbc);  
    gbc.gridx = 1;
    centre.add(salletxt, gbc);
    gbc.gridwidth = GridBagConstraints.REMAINDER;
    
    //GROUPE
    gbc.gridx = 0;
    gbc.gridy = 7;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    centre.add(groupe, gbc);  
    gbc.gridx = 1;
    centre.add(groupetxt, gbc);
    gbc.gridwidth = GridBagConstraints.REMAINDER;
    
    gbc.gridx = 0;
    gbc.gridy = 8;
    gbc.gridwidth = 2;
    centre.add(btnco, gbc);
      
   }
   
   /**
     * Méthode qui permet de modifier une séance existante
     *
     * @param center 
     */
   private  void modifForm(JPanel centre)
   {
    //On définit le layout manager
    centre.setLayout(new GridBagLayout());

      idtxt = new JTextField();
      idtxt.setPreferredSize(new Dimension(120, 40));
      
      semainetxt = new JTextField();
      semainetxt.setPreferredSize(new Dimension(120, 40));
      
      datetxt = new JTextField();
      datetxt.setPreferredSize(new Dimension(120, 40));
      
      hdtxt = new JTextField();
      hdtxt.setPreferredSize(new Dimension(120, 40));
      
      hftxt = new JTextField();
      hftxt.setPreferredSize(new Dimension(120, 40));
      
      etattxt = new JTextField();
      etattxt.setPreferredSize(new Dimension(120, 40));
      
      proftxt = new JTextField();
      proftxt.setPreferredSize(new Dimension(120, 40));
      
      salletxt = new JTextField();
      salletxt.setPreferredSize(new Dimension(120, 40));
      
      groupetxt = new JTextField();
      groupetxt.setPreferredSize(new Dimension(120, 40));
    //  mdptxt.setBorder(new LineBorder(Color.RED, 2)); couleur des bordures

      btnsem = new MyButton("<html>"
             + "<div style=\"color: black;\">"
             + "Modifier semaine</div></html>");
      btndate = new MyButton("<html>"
             + "<div style=\"color: black;\">"
             + "Modifier date</div></html>");
      btnhf = new MyButton("<html>"
             + "<div style=\"color: black;\">"
             + "Modifier heure de fin</div></html>");
      btnhd = new MyButton("<html>"
             + "<div style=\"color: black;\">"
             + "Modifier heure de début</div></html>");
      btnetat = new MyButton("<html>"
             + "<div style=\"color: black;\">"
             + "Modifier état</div></html>");
      btnprof = new MyButton("<html>"
             + "<div style=\"color: black;\">"
             + "Modifier enseignant</div></html>");
      btnsalle = new MyButton("<html>"
             + "<div style=\"color: black;\">"
             + "Modifier salle</div></html>");
      btngroupe = new MyButton("<html>"
             + "<div style=\"color: black;\">"
             + "Modifier groupe</div></html>");
      
      id = new JLabel("<html>"
             + "<div style=\"color: white; text-align: center;\">"
             + "<h3>ID de la séance à modifier </h3></div></html>");
      id.setPreferredSize(new Dimension(120, 40));
      semaine = new JLabel("<html>"
             + "<div style=\"color: white; text-align: center;\">"
             + "<h3>Semaine </h3></div></html>");
      semaine.setPreferredSize(new Dimension(120, 40));
      
      date = new JLabel("<html>"
             + "<div style=\"color: white; text-align: center;\">"
             + "<h3>Date </h3></div></html>");
      date.setPreferredSize(new Dimension(120, 40));
      
      hd = new JLabel("<html>"
             + "<div style=\"color: white; text-align: center;\">"
             + "<h3>Heure de début </h3></div></html>");
      hd.setPreferredSize(new Dimension(120, 40));
      
      hf = new JLabel("<html>"
             + "<div style=\"color: white; text-align: center;\">"
             + "<h3>Heure de fin </h3></div></html>");
      hf.setPreferredSize(new Dimension(120, 40));
      
      etat = new JLabel("<html>"
             + "<div style=\"color: white; text-align: center;\">"
             + "<h3>Etat </h3></div></html>");
      etat.setPreferredSize(new Dimension(120, 40));
      
      prof = new JLabel("<html>"
             + "<div style=\"color: white; text-align: center;\">"
             + "<h3>Enseignant </h3></div></html>");
      prof.setPreferredSize(new Dimension(120, 40));
      
      salle = new JLabel("<html>"
             + "<div style=\"color: white; text-align: center;\">"
             + "<h3>Salle </h3></div></html>");
      salle.setPreferredSize(new Dimension(120, 40));
      
      groupe = new JLabel("<html>"
             + "<div style=\"color: white; text-align: center;\">"
             + "<h3>Groupe </h3></div></html>");
      groupe.setPreferredSize(new Dimension(120, 40));
      
      /*
      btnco.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                try {
                    connexionTest( e );
                } catch (SQLException ex) {
                    
                } catch (ClassNotFoundException ex) {
                    
                }
            }
        });*/

     //L'objet servant à positionner les composants
    GridBagConstraints gbc = new GridBagConstraints();
    
    //ID
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    centre.add(id, gbc);   
    gbc.gridx = 1;
    centre.add(idtxt, gbc);
    gbc.gridwidth = GridBagConstraints.REMAINDER;
    
//SEMAINE
    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.gridheight = 1;
    gbc.gridwidth = 1;
    centre.add(semaine, gbc);
    gbc.gridx = 1;
    centre.add(semainetxt, gbc);
    gbc.gridx = 2;
    gbc.gridy = 1;
    gbc.gridwidth = 2;
    centre.add(btnsem, gbc);
    gbc.gridwidth = GridBagConstraints.REMAINDER;

    //DATE
    gbc.gridx = 0;
    gbc.gridy = 2;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    centre.add(date, gbc);   
    gbc.gridx = 1;
    centre.add(datetxt, gbc);
    gbc.gridx = 2;
    gbc.gridy = 2;
    gbc.gridwidth = 2;
    centre.add(btndate, gbc);
    gbc.gridwidth = GridBagConstraints.REMAINDER;
    
    //HD
    gbc.gridx = 0;
    gbc.gridy = 3;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    centre.add(hd, gbc);  
    gbc.gridx = 1;
    centre.add(hdtxt, gbc);
    gbc.gridx = 2;
    gbc.gridy = 3;
    gbc.gridwidth = 2;
    centre.add(btnhd, gbc);
    gbc.gridwidth = GridBagConstraints.REMAINDER;
    
    //HF
    gbc.gridx = 0;
    gbc.gridy = 4;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    centre.add(hf, gbc);  
    gbc.gridx = 1;
    centre.add(hftxt, gbc);
    gbc.gridx = 2;
    gbc.gridy = 4;
    gbc.gridwidth = 2;
    centre.add(btnhf, gbc);
    gbc.gridwidth = GridBagConstraints.REMAINDER;
    
    //ETAT
    gbc.gridx = 0;
    gbc.gridy = 5;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    centre.add(etat, gbc);  
    gbc.gridx = 1;
    centre.add(etattxt, gbc);
    gbc.gridx = 2;
    gbc.gridy = 5;
    gbc.gridwidth = 2;
    centre.add(btnetat, gbc);
    gbc.gridwidth = GridBagConstraints.REMAINDER;
    
    //PROF
    gbc.gridx = 0;
    gbc.gridy = 6;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    centre.add(prof, gbc);  
    gbc.gridx = 1;
    centre.add(proftxt, gbc);
    gbc.gridx = 2;
    gbc.gridy = 6;
    gbc.gridwidth = 2;
    centre.add(btnprof, gbc);
    gbc.gridwidth = GridBagConstraints.REMAINDER;
    
    //SALLE
    gbc.gridx = 0;
    gbc.gridy = 7;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    centre.add(salle, gbc);  
    gbc.gridx = 1;
    centre.add(salletxt, gbc);
    gbc.gridx = 2;
    gbc.gridy = 7;
    gbc.gridwidth = 2;
    centre.add(btnsalle, gbc);
    gbc.gridwidth = GridBagConstraints.REMAINDER;
    
    //GROUPE
    gbc.gridx = 0;
    gbc.gridy = 8;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    centre.add(groupe, gbc);  
    gbc.gridx = 1;
    centre.add(groupetxt, gbc);
    gbc.gridx = 2;
    gbc.gridy = 8;
    gbc.gridwidth = 2;
    centre.add(btngroupe, gbc);
    gbc.gridwidth = GridBagConstraints.REMAINDER;
      
   }

}
