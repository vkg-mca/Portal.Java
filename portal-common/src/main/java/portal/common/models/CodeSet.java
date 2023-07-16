package portal.common.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder//Builder method implements
public class CodeSet
{
    private Integer id;
    private String category;
    private String code;
    private String value;
    private Date created;
    private String description;
}
