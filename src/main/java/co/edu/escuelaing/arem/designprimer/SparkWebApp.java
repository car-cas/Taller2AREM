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

    private static Ejercicio ejercicio;
    

    public SparkWebApp() {
        this.ejercicio = ejercicio;
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
                + "<h2>Parcial AREM primer corte</h2>"
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
        ejercicio.leerArchivo(req.queryParams("numero"));
         String pageContent
                = "<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                + "<h2> Resultado del parcial : </h2>"
                + "  * Resultado: <br>"
                + "Lista de numeros: " + ejercicio.imprimir()
                + "  <br>"
                + "Maximo: " + ejercicio.maximo()
                + "  <br>"
                + "Minimo: " + ejercicio.minimo()
                + "  <br>"
                + "sumatoria: " + ejercicio.sumatoria()
                + "  <br>"
                + "Multiplicatoria:" + ejercicio.multiplicatoria()
                + "  <br>"
                + "</body>"
                + "</html>";
        
        return pageContent ;
    }
}
