package portal.directory.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder//Builder method implements

public class Person {

    //NOTE: making any property public will cause that property appearing twice [ex. { "Id": 2, "id": 2}] in REST output
    private Integer Id;
    private String Name;
    private Character Gender;
    private Date BirthDate;
    private Date Created;
    private String Description;
}
