package escuelaing.arep;
import java.io.InputStreamReader;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;

/**
 * Clase HttpStockService que abre un objeto tipo Http que recorre un String de tipo JSON
 *
 */

public abstract class HttpStockService {

    private static final String USER_AGENT = "Mozilla/5.0";


    /**
     * Metodo que crea y recorre un objeto tipo Http
     * @return un String que es el JSON
     * @throws IOException
     */
    public String timeSeriesDaily() throws IOException {

        String responseStr = "Nule";

        URL obj = new URL(getUrl());
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();


            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            responseStr = response.toString();

            // print result
            System.out.println(response.toString());
        } else {
            System.out.println("GET request not worked");
        }
        System.out.println("GET DONE");
        return responseStr;
    }
    /**
     * Metodo abstracto que obtiene un String que es la URL
     * @return un String que es la URL
     */
    abstract public String getUrl();
    /**
     * Metodo set que cambia el valor del symbol del objeto JSON
     * @param stock que es el valor al symbol a cambiar
     */
    abstract public void setStock(String stock);

}
