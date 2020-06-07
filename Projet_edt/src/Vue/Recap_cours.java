/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

//import static Vue.Page.creationSemaines;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.Border;

/**
 *
 * @author thomaspopielski
 */
public class Recap_cours extends JFrame{
    
       
    private JButton b1, b2, b3;
    private final JPanel p0, p01, p1, nord, p2;
    private JLabel t0, t1, tnord, t2,t3, ht;

    
    public Recap_cours()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Quand l'utilisateur ferme la fenetre code stop, voir DISPOSE_ON_CLOSE
        setSize(1200, 800); // Taille de la fenetre
        setLocationRelativeTo(null); //La fenetre s'affiche au centre de l'écran, peu importe la taille de l'écran

        setLayout(new BorderLayout());
        setResizable(true);
        setVisible(true);
        
        
        
        //Création des panels:
        p0 = new JPanel();
        p01= new JPanel();
        p1 = new JPanel();
        nord = new JPanel();
        p2 = new JPanel();

        
        // mise en page des panneaux
        p0.setLayout(new GridLayout(1, 1));
        p01.setLayout(new GridLayout(1, 1));
        nord.setLayout(new GridLayout(2, 1));
        p2.setLayout(new GridLayout(1, 2));

        
        
         // ajout des objets graphqiues dans les panneaux
         //p0.setBackground(new Color(81, 133, 169));
        TopBar tp = new TopBar(p0, p01);

       createTable(p2);
        
        //On ajout les deux panels p0 et p1 au Nord
        nord.add("North", p0);
        nord.add("North", p01);
        
        //Disposition des panels
        add("North", nord);
        add("Center", p2);


        
    }
    
    
    private void createTable(JPanel centre)
    {        
        setTitle("JTable basique dans un JPanel");
        Border blackline = BorderFactory.createLineBorder(Color.black);
 
        Object[][] donnees = {
                {"Johnathan", "Sykes", Color.red, true},
                {"Nicolas", "Van de Kampf", Color.black, true},
                {"Damien", "Cuthbert", Color.cyan, true},
                {"Corinne", "Valance", Color.blue, false},
                {"Emilie", "Schrödinger", Color.magenta, false},
                {"Delphine", "Duke", Color.yellow, false},
                {"Eric", "Trump", Color.pink, true},
        };
 
        String[] entetes = {"Prénom", "Nom", "Couleur favorite", "Homme"};
 
        JTable tableau = new JTable(donnees, entetes);
        tableau.setBorder(blackline);
        
        centre.add(tableau);
    }
    
}
