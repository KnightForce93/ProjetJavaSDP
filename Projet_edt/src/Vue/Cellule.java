/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import javax.swing.JPanel;

/**
 *
 * @author thomaspopielski
 */
public class Cellule extends JPanel{
    
    private int k;
    
    public Cellule ()
    {
        super();
        this.k = 0;
        
    }
    
    public void setK(int i)
    {
        k = i;
    }
    
    public int getK()
    {
        return k;
    }
    
}
