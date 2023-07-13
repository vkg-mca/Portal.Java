package portal.directory.models;

import jakarta.persistence.*;
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
    private Integer Id;
    private String Category;
    private String Code;
    private String Value;
    private Date Created ;
    private String Description;
}
