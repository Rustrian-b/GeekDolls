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
        vInstruction = "insert into sales (id_number, description, name, address, status) values (" + "incremento_codigoSales.NextVal,'" +vProducto + "','"+vCliente +"','"+vDireccion+"','Sin empacar')";
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
        vInstruction = "insert into inventory (id_number, description) values (" + "incremento_codigoInventory.NextVal,'" + vDescription + "')";
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
    
    public boolean updateSales(int vID)
    {
        String vInstruction = "";
        vInstruction = "update sales set status = 'Empacado' where id_number = '"+ vID +"' ";
        ManejoBDD m = new ManejoBDD();
        
        boolean vResult = m.update(vInstruction);
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
