package team.tp_acsi_api.models;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "vaccines")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vaccine {
    @Id
    private ObjectId id;

    @NonNull
    private String userId;

    @NonNull
    private String name;

    @NonNull
    private Date date;

    // Getters, setters, and constructors
}