/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.DAO;
import Modele.information.Seance_salles;
import Modele.information.Seance;
/**
 *
 * @author wass1
 */
public class Seance_sallesDAO extends DAO<Seance_salles>{
     public Seance_sallesDAO(Connexion conn) {
    super(conn);
  }
  public Seance_salles find(int id){
      
  }
    public boolean create(Seance obj) {
    return false;
  }
   
  public boolean update(Seance obj) {
    return false;
  }
}
