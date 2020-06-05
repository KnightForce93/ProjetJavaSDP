/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.DAO;
import Modele.information.Seance;
/**
 *
 * @author wass1
 */
public class SeanceDAO extends DAO<Seance>{
     public SeanceDAO(Connexion conn) {
    super(conn);
  }
  public Seance find(int id){
      return false;
  }
    public boolean create(Seance obj) {
    return false;
  }
   
  public boolean update(Seance obj) {
    return false;
  }
}
