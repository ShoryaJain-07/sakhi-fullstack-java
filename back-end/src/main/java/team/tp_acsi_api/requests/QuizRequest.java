package team.tp_acsi_api.requests;

import lombok.Data;


@Data
public class QuizRequest {
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String answer;
}
