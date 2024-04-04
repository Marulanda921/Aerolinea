import Controller.AvionController;
import Model.AvionModel;

import javax.swing.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        AvionController PrimerAvion = new AvionController();
        Scanner datos = new Scanner(System.in);
        boolean salir = false;

        while (!salir){
            int opcion = Integer.parseInt(JOptionPane.showInputDialog(null, """
                    1. Opciones Avion
                    2. Opciones Vuelo
                    3. Opciones Pasajero
                    4. Opciones Reservacion
                    0. Salir
                    
                    """));
            switch (opcion){
                case 1:
                    int opcionA= Integer.parseInt(JOptionPane.showInputDialog(null, """
                    1. Create Avion
                    2. Read Avion
                    3. Update Avion
                    4. Delete Avion
                    0. Salir
                    
                    """));
                    switch (opcionA){
                        case 1:
                            PrimerAvion.create();
                            break;
                        case 2:
                            PrimerAvion.read();
                            break;
                        case 3:
                            System.out.println("c");
                            break;
                        case 4:
                            System.out.println("d");
                            break;
                        case 0:
                            salir = true;
                            break;
                    }

                    break;

                case 2:
                    int opcionB= Integer.parseInt(JOptionPane.showInputDialog(null, """
                    1. Create Vuelo
                    2. Read Vuelo
                    3. Update Vuelo
                    4. Delete Vuelo
                    0. Salir
                    
                    """));
                    switch (opcionB) {
                        case 1:
                            System.out.println("a");
                            break;
                        case 2:
                            System.out.println("b");
                            break;
                        case 3:
                            System.out.println("c");
                            break;
                        case 4:
                            System.out.println("d");
                            break;
                        case 0:
                            salir = true;
                            break;
                    }
                    break;

                    case 3:
                        int opcionC= Integer.parseInt(JOptionPane.showInputDialog(null, """
                    1. Create Pasajero
                    2. Read Pasajero
                    3. Update Pasajero
                    4. Delete Pasajero
                    0. Salir
                    
                    """));
                        switch (opcionC) {
                            case 1:
                                System.out.println("a");
                                break;
                            case 2:
                                System.out.println("b");
                                break;
                            case 3:
                                System.out.println("c");
                                break;
                            case 4:
                                System.out.println("d");
                                break;
                            case 0:
                                salir = true;
                                break;
                        }
                        break;
                        case 4:
                            int opcionD= Integer.parseInt(JOptionPane.showInputDialog(null, """
                            1. Create Reservacion
                            2. Read Reservacion
                            3. Update Reservacion
                            4. Delete Reservacion
                            0. Salir
                    
                    """));
                            switch (opcionD) {
                                case 1:
                                    System.out.println("a");
                                    break;
                                case 2:
                                    System.out.println("b");
                                    break;
                                case 3:
                                    System.out.println("c");
                                    break;
                                case 4:
                                    System.out.println("d");
                                    break;
                                case 0:
                                    salir = true;
                                    break;
                            }
                            break;
                            case 0:
                                salir = true;
                                break;
                        }
                        break;

            }
        }
    }