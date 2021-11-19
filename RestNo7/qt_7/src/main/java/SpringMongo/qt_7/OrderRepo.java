package SpringMongo.qt_7;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface OrderRepo extends MongoRepository< Order, String > {
	
	@Query("{ 'itemName' : ?0 }")
	Order findOrdersByName(String itemName);

}
