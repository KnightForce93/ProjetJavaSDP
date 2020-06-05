/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.DAO;

/**
 *
 * @author wass1
 */
public abstract class DAO<T> {
  protected Connexion connect = null;
   
  public DAO(Connexion conn){
    this.connect = conn;
  }
  public abstract T find(int id);
}

