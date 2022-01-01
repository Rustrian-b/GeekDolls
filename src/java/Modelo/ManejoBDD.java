package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author H4HG
 */
public class ManejoBDD 
{
    static Connection c;
    static Statement s;
    static ResultSet r;
    
    public static void conectar()
    {
        String user = "GEEK_DOLLS";
        String password = "umg123";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            c = DriverManager.getConnection(url, user, password);
            s = c.createStatement();
        }catch(SQLException e)
        {
            System.out.println("Error al conectar a la BD");
        }catch(ClassNotFoundException ex)
        {
            Logger.getLogger(ManejoBDD.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public static void cerrar()
    {
        try
        {
            s.close();
            c.close();
        }catch(SQLException e)
        {
            System.out.println("Error al cerrar BDD");
        }
    }
    
    public static void update(String pInstruccion)
    {
        try
        {
            conectar();
            s.executeQuery(pInstruccion);            
        }catch(SQLException e)
        {
            System.out.println("Error al Actualizar BDD");            
        }
    }
    
    public int Insertar(String pInstruccion)
    {        
        int vResult = 0;
        try
        {
            conectar();
            s.executeQuery(pInstruccion);
            vResult = 1;
        }catch(SQLException e)
        {
            System.out.println("Error al realizar inseción en la BD");
            vResult = 0;
        }
        
        return vResult;
    }
}
