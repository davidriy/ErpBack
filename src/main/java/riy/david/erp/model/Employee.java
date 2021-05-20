package riy.david.erp.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("employee")
public class Employee {
    @Id
    private String id;
    // @Field(name = "name") Se le puede poner otro nombre que el seleccionado con la anotación @Field
    private String name;
    private String last_name;
    // private Date birth_date; FIXME: encontrar formato correcto para date
    private String salary;
    @Indexed(unique = true)
    private String document;
}
