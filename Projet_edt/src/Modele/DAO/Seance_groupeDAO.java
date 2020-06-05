/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.DAO;
import Modele.information.Seance;
import Modele.information.Seance_groupe;
/**
 *
 * @author wass1
 */
public class Seance_groupeDAO extends DAO<Seance_groupe>{
     public Seance_groupeDAO(Connexion conn) {
    super(conn);
  }
  public Seance_groupe find(int id){
      
  }
    public boolean create(Seance obj) {
    return false;
  }
   
  public boolean update(Seance obj) {
    return false;
  }
}
