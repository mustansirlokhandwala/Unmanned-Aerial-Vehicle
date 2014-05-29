/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UAV.DB4OUtil;

import java.util.ArrayList;

import javax.management.relation.Role;

/**
 *
 * @author Mustansir
 */
public class EcoSystem  {

    private static EcoSystem system;
   
    
   
    
    public static EcoSystem getInstance(){
        if (system == null){
            system = new EcoSystem();
        }
        return system;
    }

    private EcoSystem() {
      
       
        
    }  
    
}
