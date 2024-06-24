package team.tp_acsi_api.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import team.tp_acsi_api.models.Vaccine;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccineRepository extends MongoRepository<Vaccine, ObjectId> {
    List<Vaccine> findByUserId(String userId);
}