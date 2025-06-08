package ejercicio2;

public class FileAccessProxy implements File {
    private FileAccess fileAccess;
    private String content;
    private Usuario usuario;

    public FileAccessProxy(FileAccess fileAccess, Usuario usuario) {
        this.usuario = usuario;
        this.fileAccess = fileAccess;
        this.content = "";
    }

    @Override
    public String readFile() {

        if (this.fileAccess.nombreComienzaCon("i")) {
            if (!usuario.poseePermiso(Permiso.ADMIN)) {
                throw new RuntimeException("Permisos insuficientes");
            }

        } else if (fileAccess.nombreComienzaCon("m")) {
            if (!usuario.poseePermiso(Permiso.ADMIN) || !usuario.poseePermiso(Permiso.INTERMEDIO)) {
                throw new RuntimeException("Permisos insuficientes");
            }
        }
        if (content.equals("")) {
            content = fileAccess.readFile();
        }
        return content;
    }
}
