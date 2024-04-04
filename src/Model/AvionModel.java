package Model;

import Database.CRUD;
import Database.ConfigDB;
import Entity.Avion;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AvionModel implements CRUD {

    @Override
    public Object create(Object object) {
        //establecer la conexion
        Connection objConnection = ConfigDB.openConnection();

        //Se crea el objeto y se parsea
        Avion obAvion = (Avion) object;

        try {
            //Se crea la consulta
            String sql = "INSERT INTO Avion (modelo,capacidad) values (?,?);";

            //Se crea el prepareStatement
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            //Se agregan los valores
            objPrepare.setString(1, obAvion.getModelo());
            objPrepare.setInt(2, obAvion.getCapacidad());

            //Se ejecuta la consulta
            objPrepare.execute();
            JOptionPane.showMessageDialog(null,"Datos insertados satisfactoriamente");


        }catch (Exception e){
            System.out.println("El error es: " + e.getMessage());
        }
        return obAvion;
    }

    //_____________________________________________________________________________________________________

    @Override
    public boolean update(Object object) {
        //Establecer la conexion
        Connection objConnection = ConfigDB.openConnection();

        //Boleano para saber si cambio o no
        boolean cambio = false;

        //Se crea el objeto y se parsea
        Avion obAvion = (Avion) object;

        try {
            //Se crea la consulta
            String sql = "UPDATE Avion SET modelo =?, capacidad =? WHERE Avion.id_avion =?";

            //Preaparar el statement
            PreparedStatement objPrepare = (PreparedStatement) objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            //Se agregan los valores
            objPrepare.setString(1, obAvion.getModelo());
            objPrepare.setInt(2, obAvion.getCapacidad());
            objPrepare.setInt(3, obAvion.getId_avion());

            //Se ejecuta la consulta
            int rowsAfected = objPrepare.executeUpdate();
            if (rowsAfected > 0){
                cambio = true;
                JOptionPane.showMessageDialog(null,"Datos actualizados satisfactoriamente");
            }



        }catch (Exception e){
            System.out.println("El erro es: " + e.getMessage());
        }
        return cambio;
    }
    //______________________________________________________________________________________________________

    @Override
    public boolean delete(Object object) {
        try {

        }catch (Exception e){
            System.out.println("El erro es: " + e.getMessage());
        }
        return false;
    }
    //________________________________________________________________________________________________________

    @Override
    public Object findBYid(int id) {
        //Establecer la conexion
        Connection objConnection = ConfigDB.openConnection();

        //Se crea el objeto donde se van a guardar los datos
        Avion objAvion = null;

        try {
            //Escribir la consulta
            String sql = "SELECT * FROM Avion WHERE Avion.id_avion = ?;";

            //preparar el statement
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);


            //setear los valores dentro del parametro
            objPrepare.setInt(1,id);

            //Se ejecuta la consulta
            ResultSet objResult = (ResultSet) objPrepare.executeQuery();

            //Se recorren las filas
            while (objResult.next()) {
                //Se crea el objeto
                objAvion = new Avion();
                objAvion.setId_avion(objResult.getInt("id_avion"));
                objAvion.setModelo(objResult.getString("modelo"));
                objAvion.setCapacidad(objResult.getInt("capacidad"));
            }
            JOptionPane.showMessageDialog(null, "Se ejecuto");




        }catch (Exception e){
            System.out.println("El error es este: " + e.getMessage());
        }

        return objAvion;
    }

    //___________________________________________________________________________________________________

    @Override
    public List<Object> readAll() {

        //establecer la conexion
        Connection objConnection = ConfigDB.openConnection();

        //Se crea el objeto donde se van a guardar los datos
        List<Object> listaAviones = new ArrayList<>();

        try {
            //Hacer la consulta
            String sql = "SELECT * FROM Avion ORDER BY Avion.id_avion ASC";

            //Se crea el prepareStatement
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            //se ejecuta la consulta
            ResultSet objResult = (ResultSet) objPrepare.executeQuery();

            //Se recorren las filas
            while (objResult.next()) {
                //Se crea el objeto
                Avion objAvion = new Avion();
                objAvion.setId_avion(objResult.getInt("id_avion"));
                objAvion.setModelo(objResult.getString("modelo"));
                objAvion.setCapacidad(objResult.getInt("capacidad"));
                listaAviones.add(objAvion);
            }
            JOptionPane.showMessageDialog(null, "Se ejecuto");



        }catch (Exception e){
            System.out.println("El error es: " + e.getMessage());
        }
        return listaAviones;
    }
}
