package portal.finance.models;

import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
//@Builder//Builder method implements

public class Bank extends FinanceModel
{
    private String Name;
    private String PAN;
    private String TAN;

    @Builder
    public Bank(int id, String name, String desc, String tan, String pan, Date created)
    {
        super(id, created,desc);
        this.Name = name;
        this.TAN = tan;
        this.PAN=pan;
    }
}
