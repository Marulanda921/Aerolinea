package Controller;

import Entity.Avion;
import Model.AvionModel;

import javax.swing.*;
import java.util.List;

public class AvionController {


    //Inicializamos el objeto
    AvionModel objAvion;

    //PRIMERO TENEMOS QUE INSTANCIAR EL MODELO

    public AvionController( ) {
        this.objAvion = new AvionModel();
    }


    public void create( ) {
        Avion ObjAvion = new Avion();
        String modelo = JOptionPane.showInputDialog(null, "Dame el modelo de tu avion: ");
        int capacidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Dame la capacidad de tu avion: "));
        ObjAvion.setModelo(modelo);
        ObjAvion.setCapacidad(capacidad);
        ObjAvion = (Avion) this.objAvion.create(ObjAvion);

    }

    public void update( ) {
        String lista = readAll(this.objAvion.readAll());

        //Pedimos el id  que queremos cambiar al usuario
        int idCambio =  Integer.parseInt(JOptionPane.showInputDialog(null, "Dame el id que deseas cambiar"));

        //

    }

    public void delete( ) {

    }

    public void read(){
        String lista = readAll(this.objAvion.readAll());
        JOptionPane.showMessageDialog(null, lista);

    }

    public String readAll(List<Object> listaObjetos ) {
        String cadena = "Lista de Aviones: \n";
        for (Object obj: listaObjetos ){
            Avion objAvion = (Avion) obj;
            cadena+=objAvion.toString() + "\n";
        }
        return cadena;
    }
}
