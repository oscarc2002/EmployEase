package employeasepkg;

import org.mindrot.jbcrypt.BCrypt;
import java.sql.*;

/**
 *
 * @author Mario
 */
public class PasswordManager {
    // Método para encriptar una contraseña
    public static String encriptarContraseña(String contraseña) {
        return BCrypt.hashpw(contraseña, BCrypt.gensalt());
    }

    // Método para verificar si la contraseña proporcionada coincide con la contraseña encriptada almacenada
    public static boolean verificarContraseña(String contraseña, String contraseñaEncriptada) {
        return BCrypt.checkpw(contraseña, contraseñaEncriptada);
    }

    // Método para insertar la contraseña encriptada en la base de datos
    public static void insertarContraseñaEnBaseDeDatos(String contraseñaEncriptada) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tu_basededatos", "usuario", "contraseña");
            String query = "INSERT INTO usuarios (contraseña) VALUES (?)";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, contraseñaEncriptada);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
