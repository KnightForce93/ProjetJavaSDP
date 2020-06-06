/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import DAO.Connexion;
import Modele.MAJ.Recherche;
import Modele.entite.Utilisateur;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author thomaspopielski
 */
public class FirstPage extends JFrame{
    
     private JPanel nord,centre;
    private JLabel connexion, mail, mdp;
    private  MyButton btnco;
    private  JTextField mailtxt, mdptxt;
    private Recherche r;
        
        
    
    
    
    public FirstPage(Recherche re)
    {
    this.setTitle("Connection");
    this.setSize(800, 600);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.r = re;

     setResizable(true);
     setVisible(true);
     
     
     connexion = new JLabel("<html>"
             + "<div style=\"color: white; text-align: center;\">"
             + "<h1>Page de Connexion</h1></div></html>");
     
     //Création des panels:
      nord = new JPanel();
      centre = new JPanel();

      
      nord.setBackground(new Color(81, 133, 169));
      centre.setBackground(new Color(95, 150, 187));
       
      nord.add(connexion);
      creationConnexion(centre);
      
      //Disposition des panels
        add("North", nord);
        add("Center", centre);
        
        
        
      
    } 
    
   private  void creationConnexion(JPanel centre)
   {
       
    
    //On définit le layout manager
    centre.setLayout(new GridBagLayout());

      mailtxt = new JTextField();
      mailtxt.setPreferredSize(new Dimension(120, 40));
      
      mdptxt = new JTextField();
      mdptxt.setPreferredSize(new Dimension(120, 40));
    //  mdptxt.setBorder(new LineBorder(Color.RED, 2)); couleur des bordures

      
      btnco = new MyButton("<html>"
             + "<div style=\"color: black;\">"
             + "Connexion</div></html>");
      
      mail = new JLabel("<html>"
             + "<div style=\"color: white; text-align: center;\">"
             + "<h3>Identifiant </h3></div></html>");
      mail.setPreferredSize(new Dimension(120, 40));
      
      mdp = new JLabel("<html>"
             + "<div style=\"color: white; text-align: center;\">"
             + "<h3>Mot de passe </h3></div></html>");
      mdp.setPreferredSize(new Dimension(120, 40));
      
       
      btnco.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                try {
                    connexionTest( e );
                } catch (SQLException ex) {
                    
                } catch (ClassNotFoundException ex) {
                    
                }
            }
        }); 

     //L'objet servant à positionner les composants
    GridBagConstraints gbc = new GridBagConstraints();
    
    gbc.gridx = 0;
    gbc.gridy = 0;
    //La taille en hauteur et en largeur
    gbc.gridheight = 1;
    gbc.gridwidth = 1;
    centre.add(mail, gbc);
    //---------------------------------------------
    gbc.gridx = 1;
    centre.add(mailtxt, gbc);
    //---------------------------------------------
    //Cette instruction informe le layout que c'est une fin de ligne
    gbc.gridwidth = GridBagConstraints.REMAINDER;

    //---------------------------------------------
    gbc.gridx = 0;
    gbc.gridy = 1;
 
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    centre.add(mdp, gbc);
    
    gbc.gridx = 1;
    centre.add(mdptxt, gbc);
    
    
    gbc.gridx = 0;
    gbc.gridy = 2;
    gbc.gridwidth = 2;
    centre.add(btnco, gbc);
      
   }
   
    private void connexionTest ( ActionEvent event ) throws SQLException, ClassNotFoundException
    { 
        Utilisateur user = new Utilisateur();
        String mail, mdp;
        System.out.println("Recap bouton cliqué !");
        mail = mailtxt.getText();
        System.out.println("Identifiant: "+mail);
        
        mdp = mdptxt.getText();
        System.out.println("mot de passe: "+ mdp);
        
        user = r.ConnexionU(mail, mdp);
      
        if(user != null)
        {
            Page p = new Page(user, r);
            p.setVisible(true);
        }

   
    }
    
    
}
