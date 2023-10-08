package codefactory.model;

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
    public Integer id;
    public String category;
    public String code;
    public String value;
    public Date created;
    public String description;
}
