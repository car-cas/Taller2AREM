/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arem.designprimer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 2110540
 */
public class Json {
    private ArrayList json;
    public void agregar(double n){
        json.add(n);
    }
    public int getTamanio(){
        return json.size();
    }
    
    public double ver(double i){
      
        return (double) json.get((int) i);
        
    }
            
}
