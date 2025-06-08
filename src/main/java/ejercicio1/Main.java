package ejercicio1;

public class Main {
    public static void main(String args[]) {
        PersonaDAO dao = new PersonaDAO();
        Persona p = dao.personaPorId(2);
        System.out.println(p.nombre());
        for (Telefono telefono : p.telefonos()) {
            System.out.println(telefono);
        }
    }
}