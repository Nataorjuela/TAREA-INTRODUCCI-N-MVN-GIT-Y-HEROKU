package escuelaing.arep;

public class CurrentServiceInstance {

    private static CurrentServiceInstance _instance = new CurrentServiceInstance();
    private HttpStockService service;

    /**
     * Constructor de la clase CurrentServiceInstance donde se instancia la clase
     */
    private CurrentServiceInstance() {
        service = new AlphaHttpStockService();

    }

    /**
     * Se instancia con el patron singleton
     * @return _instance con la clase CurrentServiceInstance
     */
    public static CurrentServiceInstance getInstance() {
        return _instance;
    }
    /**
     * Metodo que retorna el servicio
     * @return service que es de tipo HttpStockService
     */
    public HttpStockService getService() {
        return service;
    }

}