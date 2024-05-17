package employeasepkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConexionSQL {

    Connection SQLConexion;

    public ConexionSQL() {
        String host = "localhost";
        String puerto = "3306";
        String nameDB = "smi    ";

        String usuario = "root";
        String pass = "";

        String driver = "com.mysql.cj.jdbc.Driver";

        String databaseURL = "jdbc:mysql://" + host + ":" + puerto + "/" + nameDB + "?useSSL=false";
        
        Properties connectionProps = new Properties();
        connectionProps.put("user", usuario);
        connectionProps.put("password", pass);
        connectionProps.put("zeroDateTimeBehavior", "convertToNull"); // Fechas en cero son null

        try {
            Class.forName(driver);
            SQLConexion = DriverManager.getConnection(databaseURL, connectionProps);
            //System.out.println("Conexion exitosa");
        } catch (Exception e) {
            System.out.println("Ocurrio un error");
        }
    }

    public Connection getConectarDB() {
        return SQLConexion;
    }
}
