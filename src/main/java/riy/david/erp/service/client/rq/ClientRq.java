package riy.david.erp.service.client.rq;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import riy.david.erp.model.Employee;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientRq {
    Employee employee;
}
