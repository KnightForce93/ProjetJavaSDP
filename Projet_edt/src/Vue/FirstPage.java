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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private static JLabel connexion, id, mdp;
    private static MyButton btnco;
    private static JTextField idtxt, mdptxt;

    
    
    public FirstPage()
    {
    this.setTitle("Connection");
    this.setSize(800, 600);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    

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
    
   private static void creationConnexion(JPanel centre)
   {
       
    
    //On définit le layout manager
    centre.setLayout(new GridBagLayout());

      idtxt = new JTextField();
      idtxt.setPreferredSize(new Dimension(120, 40));
      
      mdptxt = new JTextField();
      mdptxt.setPreferredSize(new Dimension(120, 40));
    //  mdptxt.setBorder(new LineBorder(Color.RED, 2)); couleur des bordures

      
      btnco = new MyButton("<html>"
             + "<div style=\"color: black;\">"
             + "Connexion</div></html>");
      
      id = new JLabel("<html>"
             + "<div style=\"color: white; text-align: center;\">"
             + "<h3>Identifiant </h3></div></html>");
      id.setPreferredSize(new Dimension(120, 40));
      
      mdp = new JLabel("<html>"
             + "<div style=\"color: white; text-align: center;\">"
             + "<h3>Mot de passe </h3></div></html>");
      mdp.setPreferredSize(new Dimension(120, 40));
      
       
      btnco.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
             connexionTest( e );
            }
        }); 

     //L'objet servant à positionner les composants
    GridBagConstraints gbc = new GridBagConstraints();
    
    gbc.gridx = 0;
    gbc.gridy = 0;
    //La taille en hauteur et en largeur
    gbc.gridheight = 1;
    gbc.gridwidth = 1;
    centre.add(id, gbc);
    //---------------------------------------------
    gbc.gridx = 1;
    centre.add(idtxt, gbc);
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
   
    private static void connexionTest ( ActionEvent event )
    { 
        String id, mdp;
        System.out.println("Recap bouton cliqué !");
        id = idtxt.getText();
        System.out.println("Identifiant: "+id);
        
        mdp = mdptxt.getText();
        System.out.println("mot de passe: "+ mdp);
        
        if("Thomas".equals(id) && "1234".equals(mdp))
        {
            Page p = new Page();
            p.setVisible(true);
        }
   
    }
    
}
