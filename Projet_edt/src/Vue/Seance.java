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

    public Seance(JPanel c, int cours)
    { 
        
        
        
        choixCours(c,cours);
       // c.add(test);
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
    
    private void choixCours(JPanel cell, int c)
    {
        if(c==1)
        {
           cell.setBackground(mathsC); 
           JLabel test = new JLabel("<html><div style=\" color: black;"
                + " text-align: center;  padding: 5px;\">\n" +
                    "Cours de Maths  \n" + "</div></html>");
           cell.add(test);
        }
        if(c==2)
        {
           cell.setBackground(angC); 
           JLabel test = new JLabel("<html><div style=\" color: black;"
                + " text-align: center;  padding: 5px;\">\n" +
                    "Cours d'anglais  \n" + "</div></html>");
           cell.add(test);
        }
        if(c==3)
        {
           cell.setBackground(phyC);
           JLabel test = new JLabel("<html><div style=\" color: black;"
                + " text-align: center;  padding: 5px;\">\n" +
                    "Cours de physique  \n" + "</div></html>");
           cell.add(test);
        }
        if(c==4)
        {
           cell.setBackground(espC);
           JLabel test = new JLabel("<html><div style=\" color: black;"
                + " text-align: center;  padding: 5px;\">\n" +
                    "Cours d'espagnol  \n" + "</div></html>");
           cell.add(test);
        }
        if(c==5)
        {
           cell.setBackground(infoC);
           JLabel test = new JLabel("<html><div style=\" color: black;"
                + " text-align: center;  padding: 5px;\">\n" +
                    "Cours d'informatique  \n" + "</div></html>");
           cell.add(test);
        }
        
    }
 
}
