package Database;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConfigDB {

    static  Connection objConnection = null;
    public static Connection openConnection(){

        try {

            //Se crean los parametros de la base de datos
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://ubhbtydmttbwa9mg:TEz3ziFFJhmYIYfUJ8Dw@byddxwhugtex3rfh8ebj-mysql.services.clever-cloud.com:3306/byddxwhugtex3rfh8ebj";
            String user = "ubhbtydmttbwa9mg";
            String password = "TEz3ziFFJhmYIYfUJ8Dw";

            //Se crea la conexión
            objConnection = (Connection) DriverManager.getConnection(url,user,password);
            System.out.println("Se establecio la conexion Satisfactoriamente");



        }catch (Exception e){
            System.out.println("Error encontrado" +  e.getMessage());
        }
        return objConnection;
    }

    public void CloseConnection(){
        try {
            objConnection.close();
            System.out.println("Se cerró la conexión");
        }catch (Exception e){
            System.out.println("El problema es: " + e.getMessage());
        }
    }
}
