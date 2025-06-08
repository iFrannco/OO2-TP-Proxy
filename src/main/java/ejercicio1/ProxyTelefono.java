package ejercicio1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.function.IntFunction;

public class ProxyTelefono implements Set<Telefono> {
    private int idPersona;

    public ProxyTelefono(int idPersona) {
        this.idPersona = idPersona;
    }


    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<Telefono> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        String sql = "select t.numero from telefonos t where t.persona_id=?";
        List<Telefono> telefonos = new ArrayList<>();
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement statement =
                     conn.prepareStatement(sql);) {
            statement.setInt(1, this.idPersona);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                telefonos.add(
                        new Telefono(result.getString(1))
                );
            }
            return telefonos.toArray(a);
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean add(Telefono telefono) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Telefono> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
