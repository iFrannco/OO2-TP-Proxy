package ejercicio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    protected static String DB = "ejercicio_proxy";
    protected static String user = "root";
    protected static String pass = "root";
    protected static Connection conn = null;
    private static String URL_DB = "jdbc:mysql://localhost:3306/";

    public static void connect() {
        try {
            conn = DriverManager.getConnection(URL_DB + DB, user, pass);
        } catch (SQLException sqlEx) {
            System.out.println("No se ha podido conectar a " + URL_DB + DB + ". " + sqlEx.getMessage());
            System.out.println("Error al cargar el driver" + sqlEx.getMessage());
        }
    }

    public static void disconnect() {
        if (conn != null) {
            try {
                conn.close();
                conn = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void reconnect() {
        disconnect();
        connect();
    }

    public static Connection getConnection() {
        try {
            if (conn == null || conn.isClosed()) {
                connect();
            }
        } catch (SQLException e) {
            connect();
        }
        return conn;
    }

}