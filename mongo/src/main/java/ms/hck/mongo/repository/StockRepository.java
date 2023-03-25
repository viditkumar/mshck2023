package ms.hck.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ms.hck.mongo.model.Stock;

@Repository
public interface StockRepository extends MongoRepository<Stock, String> {
    
}
