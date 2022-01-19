package Modelo;

/**
 *
 * @author H4HG
 */
public class registrosBDD 
{
    public boolean registroSales(String vProducto, String vCliente, String vDireccion, int vAmount, String vPayment, int vPhone, int vPhone1)
    {        
        String vInstruction ="";
        vInstruction = "insert into sales (id_number, description, name, address, amount, status, payment, phone, phone2) values (" + "incremento_codigoSales.NextVal,'" +vProducto + "','"+vCliente +"','"+vDireccion+"','"+vAmount +"','Sin empacar','" + vPayment + "','"+ vPhone + "','" + vPhone1 + "')";
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
    
    public boolean registroInventory(String vDescription, int vAmount)
    {
        String vInstruction ="";
        vInstruction = "insert into inventory (id_number, description, amount) values (" + "incremento_codigoInventory.NextVal,'" + vDescription + "','" + vAmount + "')";
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
    
    public static void updateInventory(String vDescription, int vAmount)
    {
        String vInstruction = "";
        vInstruction = "update inventory set amount = "+ vAmount +" where description = '" + vDescription + "' " ;
        ManejoBDD m = new ManejoBDD();
        
        System.out.println(vInstruction);
        m.update(vInstruction);
        
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
