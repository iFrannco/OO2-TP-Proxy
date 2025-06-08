package ejercicio1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TelefonoDAO {
    Set<Telefono> telefonosPorId(int id){
        String sql = "select t.numero as tel_numero from telefonos t join personas p on t.idPersona=p.id where t.idPersona = ?";
//        String sql = "select p.nombre,t.numero "
//                + "from personas p, telefonos t "
//                + "where p.id = t.persona_id and p.id = ?";
        Set<Telefono> telefonos = new HashSet<Telefono>();
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement statement =
                     conn.prepareStatement(sql);) {
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                telefonos.add(new Telefono(result.getString("tel_numero")));
            }
            //return new Persona(id, nombrePersona,  new Proxu);
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
        return telefonos;
    }
}
