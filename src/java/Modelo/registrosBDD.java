package Modelo;

/**
 *
 * @author H4HG
 */
public class registrosBDD 
{
    public int registroSales(String vProducto, String vCliente, String vDireccion)
    {
        int vResult = 1;
        String vInstruction ="";
        vInstruction = "insert into sales (description, name, address, status) values ('" +vProducto + "','"+vCliente +"','"+vDireccion+"','Sin empacar')";
        ManejoBDD m = new ManejoBDD();
        
        vResult = m.Insertar(vInstruction);
        System.out.println(vInstruction);
        if(vResult ==1)
        {
            return vResult;
        }
        else
        {
            return vResult = 0;
        }                
    }
}
