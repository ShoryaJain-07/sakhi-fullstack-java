package team.tp_acsi_api.requests;

import java.util.Date;

import lombok.Data;


@Data
public class RegisterRequest {
    private String email;
    private String password;
    private String username;
    private String role;
}
