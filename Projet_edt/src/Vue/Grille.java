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
import Modele.MAJ.Recherche;
import Modele.entite.Utilisateur;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
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
    private Utilisateur user;
    private Recherche re;
    private String semaine, nom;
   

    
    public Grille(JPanel content, Utilisateur u, Recherche r, String semaine, String nom)
    {
        content.setLayout(new BorderLayout());
        
        user = u;
        re = r;
        this.nom = nom;
        this.semaine = semaine;
        //panneaux
        top = new JPanel();
        left = new JPanel();
        center = new JPanel();

      
        
        //boutons
        btn1 = new JButton("test1");
        btn2 = new JButton("test2");
        
        createHours(top);

        createDay(left);
        createCentre();
        

        
        content.add(top, BorderLayout.NORTH);
        content.add(left, BorderLayout.WEST);
        content.add(center, BorderLayout.CENTER);
        
      
    }
    
    public void paint()
    {
        center.removeAll();
        createCentre();
        center.revalidate();
        center.repaint();
    }
     
    public void createDay(JPanel left)
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
    
   
   
    
    public void createCentre()
    {   
        
        int droit = user.getDroit();
        ArrayList<String> str = new ArrayList<String>();
        JPanel cell[][]= new JPanel[6][13];
        int sem = Integer.parseInt(this.semaine);
        System.out.println(sem);
        
        
        if(!nom.equals(""))
        {
            String[] parts = nom.split(",");
           String name = parts[0];
           String obj = parts[1];
           
           if(obj.equals("etudiant"))
           {
               str= re.EdtEtudiant(sem, name); 
               for(String s:str)
               {
                   System.out.println(s);
               }
           }
           if(obj.equals("enseignant"))
           {
               str= re.EdtEnseignant(sem, name); 
           }
           if(obj.equals("salle"))
           {
               str= re.EdtSalle(sem, name); 
               
           }
           if(obj.equals("groupe"))
           {
               str= re.Edtgroupe(sem, name); 
               
           }
           
        }
        else
        {
            
       
        
        //Etudiant
        if(droit == 4)
        {
           str= re.EdtEtudiant(sem, user.getId()); 
        }
        //Enseignant
        else if(droit == 3)
        {
           str= re.EdtEnseignant(sem, user.getId());  
        }
        
        }
       
        Border blackline = BorderFactory.createLineBorder(Color.black);
        
        this.center.setBackground(Color.WHITE);

        //On définit le layout manager
        this.center.setLayout(new GridBagLayout());

        //L'objet servant à positionner les composants
        GridBagConstraints gbc = new GridBagConstraints();

        
        for(int i=0; i<6; i++){ 

            for(int j=0; j<13; j++){
                
                //Case pour les séances
                if(j%2==0)
                {
                    cell[i][j] = new JPanel();
                    cell[i][j].setPreferredSize(new Dimension(144, 102));
                
                    cell[i][j].setBackground(Color.WHITE);
                    cell[i][j].setBorder(blackline);
                    
                    gbc.gridx = j;
                    gbc.gridy = i;
                    
                    //La taille en hauteur et en largeur
                    gbc.gridheight = 1;
                    gbc.gridwidth = 1;
                    
                    createSeance(i,j, cell[i][j],str);

                    this.center.add(cell[i][j], gbc);

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
                    this.center.add(cell[i][j], gbc);

                }

            }

        }
           
   
    }
    

    public void createSeance(int i, int j, JPanel c, ArrayList<String> str)
    { 
        JPanel cell[][] = new JPanel[6][13];
        JLabel test;
        HashMap<String, Integer> table = new HashMap<String, Integer>();
           table.put("08:30:00",0);
           table.put("10:15:00",2);
           table.put("12:00:00",4);
           table.put("13:45:00",6);
           table.put("15:30:00",8);
           table.put("17:15:00",10);
           table.put("19:00:00",12);
           
        HashMap<String, Color> tableCouleur = new HashMap<String, Color>();
           tableCouleur.put("Analyse", new Color(45, 89, 133));
           tableCouleur.put("English", new Color(54, 133, 45));
           tableCouleur.put("Probabilités", new Color(89, 197, 192));
           tableCouleur.put("Electronique", new Color(149, 60, 53));
           tableCouleur.put("Droit", new Color(109, 45, 133));
           tableCouleur.put("POO Java", new Color(145, 149, 53));
         
        
        for(String s:str){
          // date, hd, hf, salle, site, cours, typeCours, prof, grp
           
           String[] parts = s.split(",");
           String date = parts[0]; 
           String hd = parts[1]; 
           String hf = parts[2]; 
           String salle = parts[3]; 
           String site = parts[4]; 
           String cours = parts[5]; 
           String typeCours = parts[6]; 
           String prof = parts[7]; 
           String grp = parts[8]; 
           String id = parts[9];
           
           String[] datesplit = date.split("-");
          
           int z;
           int annee = Integer.parseInt(datesplit[0]);
           int mois = Integer.parseInt(datesplit[1]);
           int jour = Integer.parseInt(datesplit[2]);
           int Day;
           if( mois >=3)
           {
               z=annee;
               Day = (((23*mois)/9) + jour + 4 + annee + (z/4) - (z/100) + (z/400) - 2)%7;
           }
           else
           {
               z= annee-1;
               Day = (((23*mois)/9) + jour + 4 + annee + (z/4) - (z/100) + (z/400))%7;
           }
       
           
           if (i==(Day-1) && j==(table.get(hd)))
           {
               if(user.getDroit() != 1)
               {
                  test = new JLabel("<html><div style=\" "
                     + "color: white; text-align:center;\">\n" +
                            salle +" "+ site +"<br><b>"+ cours+"</b><br>" + prof+"<br>" + grp + "<br>" + typeCours + "<br>"+
                        "</div></html>");
                   
               }
               else
               {
                   test = new JLabel("<html><div style=\" "
                     + "color: white; text-align:center;\">\n"+ id + "<br>" +
                            salle +" "+ site +"<br><b>"+ cours+"</b><br>" + prof+"<br>" + grp + "<br>" + typeCours + "<br>"+
                        "</div></html>");
               }
               
           
             
             //c.setBackground(Color.red);
             c.setBackground(tableCouleur.get(cours));
             c.add(test);
             
             System.out.println("test");
             
           }
        }
      
    }
    
    

    public void createHours(JPanel top)
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
