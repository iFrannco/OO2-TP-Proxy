package ejercicio2;

import java.io.IOException;

public class FileAccessProxy implements File{
    private FileAccess fileAccess;
    private String content;
    private Usuario usuario;

    public FileAccessProxy(String ruta, String nombreArchivo, Usuario usuario) {
        this.usuario = usuario;
        this.fileAccess = new FileAccess(ruta, nombreArchivo);
        this.content = "";
    }

    @Override
    public String readFile() throws IOException {

        if(this.fileAccess.nombreComienzaCon("i")){
            if(!usuario.poseePermiso(Permiso.ADMIN)){
                throw new RuntimeException("Permisos insuficientes");}

        } else if (fileAccess.nombreComienzaCon("m")) {
            if(!usuario.poseePermiso(Permiso.ADMIN) || !usuario.poseePermiso(Permiso.INTERMEDIO)){
                throw new RuntimeException("Permisos insuficientes");}
        }
        if(content.equals("")){
            content = fileAccess.readFile();
        }
        return content;
    }
}
