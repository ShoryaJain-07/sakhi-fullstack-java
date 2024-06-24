package team.tp_acsi_api.repositories;

import org.bson.types.ObjectId;
import team.tp_acsi_api.models.Quiz;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends MongoRepository<Quiz, ObjectId> {
}