package team.tp_acsi_api.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "quizs")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Quiz {
    @Id
    private ObjectId id;

    @NonNull
    private String question;

    @NonNull
    private String option1;
    @NonNull
    private String option2;
    @NonNull
    private String option3;
    @NonNull
    private String option4;
    @NonNull
    private String answer;

    // Getters, setters, and constructors
}