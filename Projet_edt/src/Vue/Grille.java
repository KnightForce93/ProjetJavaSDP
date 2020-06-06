/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

/**
 *
 * @author thomaspopielski
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.Random;
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
public class  Grille extends JFrame{
    
    private JPanel top, left, center;
    private JButton btn1, btn2;
    
    
    public Grille(JPanel content)
    {
        content.setLayout(new BorderLayout());
        
        
        //panneaux
        top = new JPanel();
        left = new JPanel();
        center = new JPanel();

        //boutons
        btn1 = new JButton("test1");
        btn2 = new JButton("test2");
        
        //top.add(btn1);
        //createHours(top);
        createHours(top);

        createDay(left);


        createCentre(center);
        
        
        content.add(top, BorderLayout.NORTH);
        content.add(left, BorderLayout.WEST);
        content.add(center, BorderLayout.CENTER);
        
      
    }
     
    private void createDay(JPanel left)
    {
        JLabel cell1 = new JLabel("<html><div style=\" "
                + "color: white; text-align: center;  padding: 5px;\">\n" +
                    "Lundi \n" +
                    "</div></html>");
        cell1.setPreferredSize(new Dimension(90, 102));	
        
        JLabel cell2 = new JLabel("<html><div style=\" "
                + "color: white; text-align: center;  padding: 5px;\">\n" +
                    "Mardi \n" +
                    "</div></html>");
        cell2.setPreferredSize(new Dimension(90, 102));
        
        JLabel cell3 = new JLabel("<html><div style=\" "
                + "color: white; text-align: center;  padding: 5px;\">\n" +
                    "Mercredi \n" +
                    "</div></html>");
        cell3.setPreferredSize(new Dimension(90, 102));
        
        JLabel cell4 = new JLabel("<html><div style=\" "
                + "color: white; text-align: center;  padding: 5px;\">\n" +
                    "Jeudi \n" +
                    "</div></html>");
        cell4.setPreferredSize(new Dimension(90, 102));
        
        JLabel cell5 = new JLabel("<html><div style=\" "
                + "color: white; text-align: center;  padding: 5px;\">\n" +
                    "Vendredi \n" +
                    "</div></html>");
        cell5.setPreferredSize(new Dimension(90, 102));
        
        JLabel cell6 = new JLabel("<html><div style=\" "
                + "color: white; text-align: center;  padding: 5px;\">\n" +
                    "Samedi \n" +
                    "</div></html>");
        cell6.setPreferredSize(new Dimension(90, 102));
       //Le conteneur principal
        
        left.setBackground(Color.GRAY);

        //On définit le layout manager
        left.setLayout(new GridBagLayout());

        //L'objet servant à positionner les composants
        GridBagConstraints gbc = new GridBagConstraints();

        //On positionne la case de départ du composant
        gbc.gridx = 0;
        gbc.gridy = 0;
        //La taille en hauteur et en largeur
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        left.add(cell1, gbc);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        //---------------------------------------------
        gbc.gridy = 1;
        left.add(cell2, gbc);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        //---------------------------------------------
        gbc.gridy = 2;		
        left.add(cell3, gbc);	
         gbc.gridwidth = GridBagConstraints.REMAINDER;
        //---------------------------------------------
        //Cette instruction informe le layout que c'est une fin de ligne
        gbc.gridy = 3;	
        left.add(cell4, gbc);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        //---------------------------------------------
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;

       
        left.add(cell5, gbc);
        
        gbc.gridy = 5;
       
        left.add(cell6, gbc);
        
        
        
        
    }
    
    private void createCentre(JPanel centre)
    {
        JPanel cell[][]= new JPanel[6][13];
        JButton test = new JButton("test");

        Border blackline = BorderFactory.createLineBorder(Color.black);
        
        centre.setBackground(Color.WHITE);
        
        Random r = new Random();
        int low = 1;
        int high = 6;
        
        

        //On définit le layout manager
        centre.setLayout(new GridBagLayout());

        //L'objet servant à positionner les composants
        GridBagConstraints gbc = new GridBagConstraints();
        
        
        
        
        for(int i=0; i<6; i++){ 

            for(int j=0; j<13; j++){
                
                if(j%2==0)
                {
                    cell[i][j]= new JPanel();
                    cell[i][j].setPreferredSize(new Dimension(144, 102));
                
                    cell[i][j].setBackground(Color.WHITE);
                    cell[i][j].setBorder(blackline);
                    
                    gbc.gridx = j;
                    gbc.gridy = i;
                    //La taille en hauteur et en largeur
                    gbc.gridheight = 1;
                    gbc.gridwidth = 1;
                    centre.add(cell[i][j], gbc);
                    
                   int result = r.nextInt(high-low) + low;
                   createSeance(cell[i][j], result);

                }
                
                
                //colonne rouge (pause)
                else
                {
                    cell[i][j]= new JPanel();
                    cell[i][j].setPreferredSize(new Dimension(17, 102));
                
                    cell[i][j].setBackground(new Color(253, 122, 120));
                    //cell[i][j].setBorder(blackline);
                
                    gbc.gridx = j;
                    gbc.gridy = i;
                    //La taille en hauteur et en largeur
                    gbc.gridheight = 1;
                    gbc.gridwidth = 1;
                    centre.add(cell[i][j], gbc);

                }
                
                
                
            }
            

        }
        /*
        createSeance(cell[0][0], 2);
        createSeance(cell[2][4], 1);
        createSeance(cell[1][2], 2);
        createSeance(cell[2][6], 3);
        */
       
        
    }
    
    
    
    
    private void createSeance(JPanel cell, int c)
    {
        
        Seance s = new Seance(cell, c);
        
        

    }
    
    

    private void createHours(JPanel top)
    {
        JLabel cell[]= new JLabel[16];
        
        Border blackline = BorderFactory.createLineBorder(Color.black);
        
       //Le conteneur principal
        
        top.setBackground(Color.GRAY);

        //On définit le layout manager
        top.setLayout(new GridBagLayout());

        //L'objet servant à positionner les composants
        GridBagConstraints gbc = new GridBagConstraints();
        
        cell[0] = new JLabel();
                cell[0].setPreferredSize(new Dimension(79, 42));
                top.add(cell[0]);
                
        cell[1] = new JLabel("<html><div style=\" "
                + "color: white;\">\n" +
                    "08h30 \n" +
                    "</div></html>");
            cell[1].setPreferredSize(new Dimension(50, 42));
            top.add(cell[1]);
                
        cell[2] = new JLabel();
                cell[2].setPreferredSize(new Dimension(60, 42));
            top.add(cell[2]);

            cell[3] = new JLabel("<html><div style=\" "
                + "color: white;\">\n" +
                    "10h00 10h15 \n" +
                    "</div></html>", SwingConstants.RIGHT );
            cell[3].setPreferredSize(new Dimension(100, 42));
            top.add(cell[3]);
            
            cell[4] = new JLabel();
            cell[4].setPreferredSize(new Dimension(80, 42));
            top.add(cell[4]);
            
            cell[5] = new JLabel("<html><div style=\" "
                + "color: white;\">\n" +
                    "11h45 12H \n" +
                    "</div></html>", SwingConstants.RIGHT );
            cell[5].setPreferredSize(new Dimension(80, 42));
            top.add(cell[5]);
            
            cell[6] = new JLabel();
            cell[6].setPreferredSize(new Dimension(60, 42));
            top.add(cell[6]);
            
            cell[7] = new JLabel("<html><div style=\" "
                + "color: white;\">\n" +
                    "13h30 13h45 \n" +
                    "</div></html>", SwingConstants.RIGHT );
            cell[7].setPreferredSize(new Dimension(90, 42));
            top.add(cell[7]);
            
            cell[8] = new JLabel();
            cell[8].setPreferredSize(new Dimension(70, 42));
            top.add(cell[8]);
            
            cell[9] = new JLabel("<html><div style=\" "
                + "color: white;\">\n" +
                    "15h15 15h30 \n" +
                    "</div></html>", SwingConstants.RIGHT );
            cell[9].setPreferredSize(new Dimension(90, 42));
            top.add(cell[9]);
            
            cell[10] = new JLabel();
            cell[10].setPreferredSize(new Dimension(60, 42));
            top.add(cell[10]);
            
            cell[11] = new JLabel("<html><div style=\" "
                + "color: white;\">\n" +
                    "17h00 17h15 \n" +
                    "</div></html>", SwingConstants.RIGHT );
            cell[11].setPreferredSize(new Dimension(100, 42));
            top.add(cell[11]);
            
            cell[12] = new JLabel();
            cell[12].setPreferredSize(new Dimension(75, 42));
            top.add(cell[12]);
            
            cell[13] = new JLabel("<html><div style=\" "
                + "color: white;\">\n" +
                    "18h45 19h \n" +
                    "</div></html>", SwingConstants.RIGHT );
            cell[13].setPreferredSize(new Dimension(80, 42));
            top.add(cell[13]);
            
            cell[14] = new JLabel();
            cell[14].setPreferredSize(new Dimension(85, 42));
            top.add(cell[14]);
            
            
            cell[15] = new JLabel("<html><div style=\" "
                + "color: white;\">\n" +
                    "20h \n" +
                    "</div></html>", SwingConstants.RIGHT );
            cell[15].setPreferredSize(new Dimension(40, 42));
            top.add(cell[15]);
           
          
        
    }
    
    
    
}
