package riy.david.erp.service.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import riy.david.erp.model.Employee;
import riy.david.erp.repository.EmployeeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee){
        employeeRepository.save(employee);
        return employee;
    }

    public Employee updateEmployee(Employee employee) {
        Employee savedEmployee = employeeRepository.findById(employee.getId())
                .orElseThrow( () -> new RuntimeException(
                                String.format("Cannot find Employee by ID %s", employee.getId())));
        savedEmployee.setName(employee.getName());
        savedEmployee.setLast_name(employee.getLast_name());
        savedEmployee.setSalary(employee.getSalary());
        savedEmployee.setDocument(employee.getDocument());

        return employeeRepository.save(savedEmployee);
    }

    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeRepository.findAll());
    }

    public Employee getEmployeeByDocument(String document) {
        return employeeRepository.findByDocument(document)
                .orElseThrow( () -> new RuntimeException(
                   String.format("Cannot find Employee by document %s", document)
                ));
    }

    public void deleteEmployee(String id) {
        employeeRepository.deleteById(id);
    }
}
