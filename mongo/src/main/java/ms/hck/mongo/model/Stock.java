package ms.hck.mongo.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "stocks")
public class Stock {
    private String stockName;
    private String stockSymbol;
    private List<String> exchangeListed;

    public String getStockName() {
        return stockName;
    }
    public void setStockName(String stockName) {
        this.stockName = stockName;
    }
    public String getStockSymbol() {
        return stockSymbol;
    }
    public void setStockSymbol(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }
    public List<String> getExchangeListed() {
        return exchangeListed;
    }
    public void setExchangeListed(List<String> exchangeListed) {
        this.exchangeListed = exchangeListed;
    }
}
