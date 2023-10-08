package codefactory.finance.entities;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Table(name="Bank")
@Entity
@Data
//@Builder//Builder method implements
public class Bank extends FinanceEntity
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
