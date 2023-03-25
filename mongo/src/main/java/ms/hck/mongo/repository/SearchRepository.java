package ms.hck.mongo.repository;

import java.util.*;

import org.springframework.stereotype.Repository;

import ms.hck.mongo.model.Stock;

@Repository
public interface SearchRepository {
    
    public List<Stock> findStockByExchange(String text);

}
