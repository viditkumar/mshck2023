package ms.hck.mongo.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import ms.hck.mongo.model.Stock;

@Component
public class SearchRepositoryImpl implements SearchRepository {

    @Autowired
    MongoClient mongoClient;

    @Autowired
    MongoConverter mongoConverter;

    @Override
    public List<Stock> findStockByExchange(String text) {
        List<Stock> stocks = new ArrayList<>();

        MongoDatabase database = mongoClient.getDatabase("sample_stocks");
        MongoCollection<Document> collection = database.getCollection("stocks");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search", 
                                            new Document("index", "default")
                                            .append("text", 
                                            new Document("query", text)
                                            .append("path", "exchangeListed")))));

        result.forEach(doc -> stocks.add(mongoConverter.read(Stock.class, doc)));
        return stocks;
    }
}
