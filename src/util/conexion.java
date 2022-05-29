/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Jairo de León
 */
public class conexion {
    //Conexion local
    
    public static Connection conectar(){
    
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/recursosc","root","");        
            return cn;
        }catch (SQLException e){
            System.out.println("Error en conexion local"+e);
        
        }
return (null);
    
    }
    
}
