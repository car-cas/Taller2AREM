package co.edu.escuelaing.arem.designprimer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import spark.Request;
import spark.Response;
import static spark.Spark.*;

/**
 *
 * @author Carlos Andres Castaneda Lozano
 *
 */
public class SparkWebApp {

    private static double pro;
    private static double deri;
    private static Linked lista = new Linked();

    public SparkWebApp() {
        this.lista = lista;
        this.pro = pro;
        this.deri = deri;
    }

    /**
     * Metodo media, calcula la media de una lista encadenada
     *
     * @return res media de la lista
     */
    public static double media() {
        double res;
        for (int i = 0; i < lista.getTamanio(); i++) {
            pro += lista.ver(i);
        }
        res = pro / lista.getTamanio();
        return res;
    }

    /**
     * Metodo desviacionEstandar, calcula la desviacion estandar de una lista
     * encadenada
     *
     * @return total derivada parcial de la lista
     */
    public static double desviacionEstandar() {
        for (int i = 0; i < lista.getTamanio(); i++) {
            deri += lista.ver(i);
        }
        double p = deri / lista.getTamanio();
        double c = 0;

        for (int i = 0; i < lista.getTamanio(); i++) {
            c += Math.pow(lista.ver(i) - p, 2);
        }

        double total = Math.sqrt(c / (lista.getTamanio() - 1));

        return total;
    }

    /**
     * Metodo leerArchivo, lee los números de un archivo .txt y los almacena en
     * una lista enlazada
     *
     * @throws java.io.IOException IoException
     * @param archivo archivo
     */
    public static void leerArchivo(String listado) {

        String[] parts = listado.split(",");
        for (int i = 0; i < parts.length; i++) {
            double nuevo = Double.parseDouble(parts[i]);
            lista.agregar(nuevo);
        }
    }

    /**
     * This main method uses SparkWeb static methods and lambda functions to
     * create a simple Hello World web app. It maps the lambda function to the
     * /hello relative URL.
     */
    public static void main(String[] args) {
        port(getPort());
        get("/inputdata", (req, res) -> inputDataPage(req, res));
        get("/results", (req, res) -> resultsPage(req, res));
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

    private static String inputDataPage(Request req, Response res) {
        String pageContent
                = "<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                + "<h2>Media y desviacion estandar</h2>"
                + "<form action=\"/results\">"
                + "  * Ingresar datos separados por comas : <br>"
                + "  <input type=\"text\" name=\"numero\">"
                + "  <br>"
                + "  <input type=\"submit\" value=\"Submit\">"
                + "</form>"
                + "</body>"
                + "</html>";
        return pageContent;
    }

    private static String resultsPage(Request req, Response res) {
        leerArchivo(req.queryParams("numero"));
         String pageContent
                = "<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                + "<h2>Media y desviacion estandar</h2>"
                + "  * Resultado: <br>"
                + "Media: " + media() 
                + "  <br>"
                + "Desviacion estandar: " + desviacionEstandar()
                + "  <br>"
                + "</body>"
                + "</html>";
        
        return pageContent ;
    }
}
