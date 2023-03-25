package ms.hck.mongo.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ms.hck.mongo.model.Stock;
import ms.hck.mongo.repository.SearchRepository;
import ms.hck.mongo.repository.StockRepository;

@RestController
public class AnalyticsController {
    
    @Autowired
    StockRepository stockRepository;

    @Autowired
    SearchRepository searchRepository;

    @GetMapping("/stocks")
    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    @GetMapping("/stock/{text}")
    public List<Stock> findStockByExchange(@PathVariable String text) {
        List<Stock> stocks = new ArrayList<>();
        
        stocks = searchRepository.findStockByExchange(text);
        return stocks;
    }
}
