package escuelaing.arep;

import spark.Request;
import spark.Response;

import java.io.IOException;

import static spark.Spark.*;



public class cacheApp {

    public static void main(String[] args){
        port(getPort());
        staticFiles.location("/public");
        get("/",(req,res)-> inputDataPage());
        get("/resultado",(req,res)-> resPage(req,res));
        get("/conexion","aplication/json", (req, res) -> conexion(req, res));
    }
    public static String inputDataPage() {
        String pageContent
                = "<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                + "<h2>Ingresar</h2>"
                + "<form action=\"/resultado\">"
                + "  First name:<br>"
                + "  <input type=\"text\" name=\"firstname\" value=\"Natalia\">"
                + "  <br>"
                + "  Last name:<br>"
                + "  <input type=\"text\" name=\"lastname\" value=\"Orjuela\">"
                + "  <br><br>"
                + "  <input type=\"submit\" value=\"Submit\">"
                + "</form>"
                + "<p>If you click the \"Submit\" button, the form-data will be sent to a page called \"/resultado\".</p>"
                + "</body>"
                + "</html>";
        return pageContent;
    }
    public static String resPage(Request req, Response res) {
        return req.queryParams("firstname") + " " +
                req.queryParams("lastname");
    }
    /**
     * Metodo que llama un objeto de tipo JSON
     * @param req que es el requerimiento recibido
     * @param res que es el response a enviar
     * @return un String de tipo JSON
     */
    private static String conexion(Request req, Response res) {
        String response = "None";
        String stock = req.queryParams("st");
        HttpStockService stockService = CurrentServiceInstance.getInstance().getService();
        if(stock != null && stock != "") {
            stockService.setStock(stock);
        }
        try {
            response = stockService.timeSeriesDaily();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return response;

    }

    /**
     * Metodo que muesta el puerto
     * @return un numero que es el puerto
     */
    public static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set (i.e. on localhost)
    }
}
