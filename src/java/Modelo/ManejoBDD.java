package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
    
    public static boolean Insertar(String pInstruccion)
    {        
        boolean vResult = false;
        try
        {
            conectar();
            s.executeQuery(pInstruccion);
            vResult = true;
        }catch(SQLException e)
        {
            System.out.println("Error al realizar inseción en la BD");
            vResult = false;
        }
        
        return vResult;
    }
    
    public static ArrayList Inventory()
    {
        ArrayList<ClsInventory> lista = new ArrayList();
        String Query = "select id_number, description from inventory";
        conectar();
        
        try
        {
            s = c.prepareStatement(Query);
            r = s.executeQuery(Query);
            
            while(r.next())
            {
                ClsInventory i = new ClsInventory();                
                i.setvID_number(Integer.parseInt(r.getString(1)));
                i.setvDescription(r.getString(2));
                lista.add(i);                
            }
        }catch(SQLException ex)
        {
            Logger.getLogger(ManejoBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
