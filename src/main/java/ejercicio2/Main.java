package ejercicio2;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Usuario admin = new Usuario("Matias", List.of(Permiso.BASICO));
        FileAccessProxy fileAccessProxy = new FileAccessProxy(new FileAccess(
                "/home/franco", "prueba.txt"), admin);
        System.out.println(fileAccessProxy.readFile());
    }
}

