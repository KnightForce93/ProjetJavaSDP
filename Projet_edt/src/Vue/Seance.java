/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author thomaspopielski
 */
public class Seance extends JFrame{
    
    private JPanel seance = new JPanel();
    
    private JLabel prof, salle;
    private int matiere;
    private JButton test;
    
    //Couleur matières
    private Color mathsC= new Color(228, 46, 43);
    private Color angC= new Color(86, 185, 47);
    private Color phyC= new Color(47, 155, 185);
    private Color espC= new Color(241, 174, 125);
    private Color infoC= new Color(47, 95, 185);

    public Seance()
    { 
        
        //test = new JButton("test");
        //this.add(test);
        
        /*
        prof = new JLabel(p);
        salle = new JLabel(s);
        matiere = m;
        
        seance.setBackground(mathsC);
        seance.add(prof);
        seance.add(salle);
        
        seance.setVisible(true);
        
        */
    }
 
}
