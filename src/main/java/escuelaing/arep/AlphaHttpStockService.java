package escuelaing.arep;

public class AlphaHttpStockService extends HttpStockService{

    String stock = "goog";
    /**
     * return la url que tiene el JSON
     */
    @Override
    public String getUrl() {
        // TODO Auto-generated method stub
        return "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol="+stock+"&apikey= RQPYZL4PVD28N3C2";
    }
    /**
     * Metodo que cambia el valor del stock que representa el symbol del objeto tipo JSON
     */
    @Override
    public void setStock(String stock) {
        // TODO Auto-generated method stub
        this.stock = stock;
    }

}