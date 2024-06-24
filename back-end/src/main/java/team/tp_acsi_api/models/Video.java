package team.tp_acsi_api.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "videos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Video {
    @Id
    private ObjectId id;

    @NonNull
    private String title;

    @NonNull
    private String link;

    // Getters, setters, and constructors
}