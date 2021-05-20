package riy.david.erp.service.employee.rq;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import riy.david.erp.model.Employee;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRq {
    private Employee employee;
}
