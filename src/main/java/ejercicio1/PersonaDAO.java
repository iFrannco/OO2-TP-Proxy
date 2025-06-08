package ejercicio1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonaDAO {
    private Connection obtenerConexion() {
        return ConnectionManager.getConnection();
    }

    public Persona personaPorId(int id) {
        String sql = "select p.nombre from personas p where p.id=?";
        try (Connection conn = obtenerConexion();
             PreparedStatement statement =
                     conn.prepareStatement(sql);) {
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            String nombrePersona = null;
            while (result.next()) {
                nombrePersona = result.getString(1);
            }
            return new Persona(id, nombrePersona, new ProxyTelefono(id));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}