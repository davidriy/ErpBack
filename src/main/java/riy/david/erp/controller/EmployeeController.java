package riy.david.erp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import riy.david.erp.model.Employee;
import riy.david.erp.service.employee.EmployeeService;
import riy.david.erp.service.employee.rq.EmployeeRq;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee newEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<Employee>(newEmployee, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        Employee updatedEmployee = employeeService.updateEmployee(employee);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/all")
    public ResponseEntity getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/find/{document}")
    public ResponseEntity getEmployeeByDocument(@RequestBody EmployeeRq rq) {
        return ResponseEntity.ok(employeeService.getEmployeeByDocument(rq.getEmployee().getDocument()));
    }
    @PostMapping("/delete")
    public ResponseEntity deleteEmployee(@RequestBody Employee employee) {
        employeeService.deleteEmployee(employee.getId());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
