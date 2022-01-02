package Modelo;

/**
 *
 * @author H4HG
 */
public class registrosBDD 
{
    public boolean registroSales(String vProducto, String vCliente, String vDireccion)
    {        
        String vInstruction ="";
        vInstruction = "insert into sales (description, name, address, status) values ('" +vProducto + "','"+vCliente +"','"+vDireccion+"','Sin empacar')";
        ManejoBDD m = new ManejoBDD();
        
        boolean vResult = m.Insertar(vInstruction);
        System.out.println(vInstruction);
        if(vResult == true)
        {
            return vResult;
        }
        else
        {
            return vResult = false;
        }                
    }
    
    public boolean registroInventory(String vDescription)
    {
        String vInstruction ="";
        vInstruction = "insert into inventory (description) values ('" + vDescription + "')";
        ManejoBDD m = new ManejoBDD();
        
        boolean vResult = m.Insertar(vInstruction);
        System.out.println(vInstruction);
        if(vResult == true)
        {
            return vResult;
        }
        else
        {
            return vResult = false;
        }
    }
}
