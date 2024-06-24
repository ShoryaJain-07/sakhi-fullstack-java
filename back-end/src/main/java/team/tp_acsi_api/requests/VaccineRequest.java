package team.tp_acsi_api.requests;

import java.util.Date;

import org.bson.types.ObjectId;

import lombok.Data;


@Data
public class VaccineRequest {
    private String userId;
    private String name;
    private Date date;
}
