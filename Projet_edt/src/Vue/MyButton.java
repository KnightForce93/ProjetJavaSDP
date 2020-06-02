/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import java.awt.Color;
import javax.swing.JButton;

/**
 *
 * @author thomaspopielski
 */
public class MyButton extends JButton{
    
     public MyButton(String txt) {
        super(txt);
        setForeground(Color.WHITE);
        
         
        setOpaque(false);
        setContentAreaFilled(true); // On met à false pour empêcher le composant de peindre l'intérieur du JButton.
        setBorderPainted(true); // De même, on ne veut pas afficher les bordures.


         

    }
    
}
