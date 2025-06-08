package ejercicio2;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Usuario admin = new Usuario("Matias", List.of(Permiso.ADMIN));
        FileAccessProxy fileAccessProxy = new FileAccessProxy(
                "/home/franco", "prueba.txt", admin);
        System.out.println(fileAccessProxy.readFile());
    }
}

