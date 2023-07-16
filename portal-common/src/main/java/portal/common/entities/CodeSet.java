package portal.common.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Table(name="CodeSet")
@Entity
@Data
@Builder//Builder method implements
public class CodeSet
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String category;
    private String code;
    private String value;
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Date created;
    private String description;
}
