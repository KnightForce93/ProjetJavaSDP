/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.DAO;
import Modele.information.Seance_enseignant;
import Modele.information.Seance;
/**
 *
 * @author wass1
 */
public class Seance_enseignantDAO extends DAO< Seance_enseignant>{
     public  Seance_enseignantDAO(Connexion conn) {
    super(conn);
  }
  public  Seance_enseignant find(int id){
      
  }
    public boolean create(Seance obj) {
    return false;
  }
   
  public boolean update(Seance obj) {
    return false;
  }
}
