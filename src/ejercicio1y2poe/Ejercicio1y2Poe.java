package ejercicio1y2poe;

import Gui.Ejercicio;
import Gui.Ventana;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatArcDarkIJTheme;


public class Ejercicio1y2Poe {

    public static Lista vehiculos = new Lista();

    /*
    Realizar una interfaz AGRADABLE que permita capturar la información de un 
    VEHICULO teniendo en cuenta  los siguientes aspectos:
    Datos: código, placa, descripción, propietario: (nombre, dirección), 
    ciudad de la placa (que sean del departamento del Caquetá),  
    Tipo vehículo, Estado (activo, inactivo, suspendido), color (seleccionable), 
    cantidad de pasajeros, etc
    Incluya componentes de cada tipo visto en clase 
    Incluir los siguientes botones con imágenes para GUARDAR, 
    LIMPIAR,  SALIR   (aunque no hagan nada)
     */
 /*
          Teniendo en cuenta el paradigma de la programación orientada 
          a objetos POO, desarrolle el siguiente ejercicio en modo consola:
          Aplicación que permita administrar datos de  VEHICULO incluyendo el tipo 
          (moto, automovil, camioneta, autobus). 
          Incluya opciones para:  adicionar, consultar, modificar, INACTIVAR.
          Utilizar almacenamiento temporal con alguna estructura de datos.
          Sobre la implementación realizada identifique los pilares de la POO.
     */
    public static void main(String[] args) {
        try {
            FlatArcDarkIJTheme.setup();

        } catch (Exception e) {
            System.out.println("Error");
        }

        Ventana mostrar = new Ventana();
        mostrar.setVisible(true);
//        Ejercicio tmp = new Ejercicio();
//        tmp.setVisible(true);
    }
}
