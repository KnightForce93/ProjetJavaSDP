/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Vue.Grille;
import Vue.TopBar;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

/**
 *
 * @author thomaspopielski
 */
public class Page extends JFrame{
      
    private JButton b1, b2, b3;
    private final JPanel p0, p01, p1, nord, p2, p3, p02;
    private JLabel t0, t1, tnord, t2,t3, ht;

    
    public Page()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Quand l'utilisateur ferme la fenetre code stop, voir DISPOSE_ON_CLOSE
        setSize(1200, 800); // Taille de la fenetre
        setLocationRelativeTo(null); //La fenetre s'affiche au centre de l'écran, peu importe la taille de l'écran

        setLayout(new BorderLayout());
        setResizable(true);
        setVisible(true);
        
        //Création des Labels
        t0= new JLabel("<html><font color=red> Texte de T0 </font> </html>");
        t1= new JLabel("<html><font color=red> Texte de T1 </font> </html>");
        
        
        
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
        TopBar tp = new TopBar(p0, p01);
      
        
        
        
        
        //p1.add(t1);
        creationSemaines(p1);
        creationMois(p02);
        
        //creationGrille(p2);
        Grille g = new Grille(p2);
        
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
    
    public static void creationSemaines(JPanel contentGrille)
    {
        JPanel cell[][] =new JPanel[50][2];
        Border blackline = BorderFactory.createLineBorder(Color.black);
        JLabel num[] = new JLabel[50];

        
        for(int i=0; i<50; i++){
                
                cell[i][1]= new JPanel();
                cell[i][1].setSize(new Dimension(10, 10));
                
                if(i<22)
                {
                  num[i] = new JLabel(""+(i+31));  
                }
                else
                {
                 num[i] = new JLabel(""+(i-21));  
                }
                
                
                cell[i][1].setBackground(new Color(230, 229, 228));
                cell[i][1].setBorder(blackline);
                
                cell[i][1].add(num[i]);
                contentGrille.add(cell[i][1]);
                
                    
                
            }
        
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
}
