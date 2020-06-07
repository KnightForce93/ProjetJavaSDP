/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import DAO.Connexion;
import Modele.MAJ.Recherche;
import Modele.entite.Utilisateur;
import java.sql.SQLException;
import java.sql.*;

/**
 *
 * @author thomaspopielski
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // TODO code application logic here
         
        String nameDatabase = "projetjava";
        String loginDatabase = "root"; 
        //pour mac
        String passwordDatabase = "root";
        
        Connexion co = new Connexion(nameDatabase,loginDatabase, passwordDatabase);
        Recherche re= new Recherche(co);
                
        FirstPage fe = new FirstPage(re);
        fe.setVisible(true);
        //Form fe = new Form(re);
        //fe.setVisible(true);
<<<<<<< HEAD
        
=======
>>>>>>> master
        

         
    }
    
}
