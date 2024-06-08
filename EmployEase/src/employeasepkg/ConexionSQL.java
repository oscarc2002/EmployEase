package employeasepkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConexionSQL {

    Connection SQLConexion;
    
    /*String host = "localhost";
        String puerto = "3306";
        String nameDB = "smi";

        String usuario = "root";
        String pass = "";*/

    /*public ConexionSQL() {
        String host = "bftjbqjiyokkmjmcuzna-mysql.services.clever-cloud.com";
        String puerto = "3306";
        String nameDB = "bftjbqjiyokkmjmcuzna";

        String usuario = "usq0hm3ccyutrka4";
        String pass = "zD3lm2BefT418oUVQzCa";

        String driver = "com.mysql.cj.jdbc.Driver";

        String databaseURL = "jdbc:mysql://" + host + ":" + puerto + "/" + nameDB + "?useSSL=false";
        
        Properties connectionProps = new Properties();
        connectionProps.put("user", usuario);
        connectionProps.put("password", pass);
        connectionProps.put("zeroDateTimeBehavior", "convertToNull"); // Fechas en cero son null

        try {
            Class.forName(driver);
            SQLConexion = DriverManager.getConnection(databaseURL, connectionProps);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }*/

    /*public Connection getConectarDB() {
        return SQLConexion;
    }*/
    
    private static HikariDataSource dataSource;

    public ConexionSQL() {
        String host = "bftjbqjiyokkmjmcuzna-mysql.services.clever-cloud.com";
        String puerto = "3306";
        String nameDB = "bftjbqjiyokkmjmcuzna";

        String usuario = "usq0hm3ccyutrka4";
        String pass = "zD3lm2BefT418oUVQzCa";

        String driver = "com.mysql.cj.jdbc.Driver";
        String databaseURL = "jdbc:mysql://" + host + ":" + puerto + "/" + nameDB + "?useSSL=false";

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(databaseURL);
        config.setUsername(usuario);
        config.setPassword(pass);
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        config.addDataSourceProperty("useServerPrepStmts", "true");
        config.addDataSourceProperty("zeroDateTimeBehavior", "convertToNull");

        // Configura un tamaño máximo de pool acorde al límite de la base de datos
        config.setMaximumPoolSize(5); // Reduce el tamaño del pool de conexiones aún más
        config.setMinimumIdle(1); // Número mínimo de conexiones ociosas
        config.setConnectionTimeout(30000); // Tiempo de espera para obtener una conexión
        config.setIdleTimeout(600000); // Tiempo de espera para que una conexión ociosa sea removida
        config.setMaxLifetime(1800000); // Tiempo de vida máximo de una conexión
        config.setLeakDetectionThreshold(2000); // Detectar conexiones que no se cierran

        dataSource = new HikariDataSource(config);
    }

    public static Connection getConectarDB() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
