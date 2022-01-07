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
    
    public static boolean update(String pInstruccion)
    {
        boolean vResult = false;
        try
        {
            conectar();
            s.executeQuery(pInstruccion);
            vResult = true;
        }catch(SQLException e)
        {
            System.out.println("Error al Actualizar BDD");
            vResult = false;
        }
        return vResult;
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
            System.out.println("Error al realizar inserción en la BD");
            vResult = false;
        }
        
        return vResult;
    }
    
    public static ArrayList Inventory()
    {
        ArrayList<ClsInventory> lista = new ArrayList();
        String Query = "select id_number, description, amount from inventory order by id_number";
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
                i.setvAmount(Integer.parseInt(r.getString(3)));
                lista.add(i);                
            }
        }catch(SQLException ex)
        {
            Logger.getLogger(ManejoBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public static ArrayList Sales()
    {
        ArrayList<ClsSales> lista = new ArrayList();
        String Query = "select id_number, description, name, address, status, amount from sales where status = 'Sin empacar' order by id_number";
        conectar();
        
        try
        {
            s = c.prepareStatement(Query);
            r = s.executeQuery(Query);
            
            while(r.next())
            {
                ClsSales c = new ClsSales();
                c.setvID_number(Integer.parseInt(r.getString(1)));
                c.setvDescription(r.getString(2));
                c.setvName(r.getString(3));
                c.setvAddress(r.getString(4));
                c.setvStatus(r.getString(5));
                c.setvAmount(Integer.parseInt(r.getString(6)));
                lista.add(c);
            }
        }catch(SQLException ex)
        {
            Logger.getLogger(ManejoBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
