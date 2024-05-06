import java.sql.Connection;
import java.sql.DriverManager;

public class SQLConnection {
    Connection SQLConexion;
    
    public SQLConnection()
    {
        String host = "localhost";
        String puerto = "3306";
        String nameDB = "smi_test";
        
        String usuario = "root";
        String pass = "";
        
        String driver = "com.mysql.cj.jdbc.Driver";
        
        String databaseURL = "jdbc:mysql://"+host+":"+puerto+"/"+nameDB+"?useSSL=false";
    
        try 
        {
            Class.forName(driver);
            SQLConexion = DriverManager.getConnection(databaseURL,usuario,pass);
            //System.out.println("Conexion exitosa");
        } 
        catch (Exception e) 
        {
            System.out.println("Ocurrio un error");
        }
    }
    
    public Connection getConectarDB()
    {
        return SQLConexion;
    }
}
