/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arem.designprimer;

import java.util.ArrayList;
import static jdk.nashorn.internal.objects.NativeMath.max;
import static jdk.nashorn.internal.objects.NativeMath.min;


/**
 *
 * @author 2110540
 */
public class Ejercicio {

    private static double pro;
    private static double deri;
    private static Json lista;
    

    public static double imprimir() {
        
        for (int i = 0; i < lista.getTamanio(); i++) {
            return lista.ver(i);
        }
        return 0;
    }

    public static double sumatoria() {
        for (int i = 0; i < lista.getTamanio(); i++) {
            pro += lista.ver(i);
        }
        return pro;
    }

    public static double multiplicatoria() {
        for (int i = 0; i < lista.getTamanio(); i++) {
            pro *= lista.ver(i);
        }
        return pro;
    }

    public static double maximo() {
        double res = 0;
        for (int i = 0; i < lista.getTamanio(); i++) {
            return res = max(lista.ver(i));
        }
        return res;
    }

    public static double minimo() {
        double res = 0;
        for (int i = 0; i < lista.getTamanio(); i++) {
            return res = min(lista.ver(i));
        }
        return res;
    }

    public static void leerArchivo(String listado) {

        String[] parts = listado.split(",");
        for (int i = 0; i < parts.length; i++) {
            double nuevo = Double.parseDouble(parts[i]);
            System.out.println("ya");
            lista.agregar(nuevo);
            
        }
        
    }

}
