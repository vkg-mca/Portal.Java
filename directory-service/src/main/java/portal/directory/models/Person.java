package portal.directory.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder//Builder method implements

public class Person {

    //NOTE: making any property public will cause that property appearing twice [ex. { "Id": 2, "id": 2}] in REST output
    private Integer id;
    private String name;
    private Character gender;
    private Date birthDate;
    private Date created;
    private String description;
}
