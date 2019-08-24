package springAndMongoDB.Repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import springAndMongoDB.Models.Pets;

public interface PetsRepository extends MongoRepository<Pets, String> {
    public Pets findBy_id(ObjectId _id);
    public Pets findByName(String name);
}
