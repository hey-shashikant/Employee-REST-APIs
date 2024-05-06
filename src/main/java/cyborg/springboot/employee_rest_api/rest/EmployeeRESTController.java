package cyborg.springboot.employee_rest_api.rest;

import cyborg.springboot.employee_rest_api.DAO.EmployeeDAO;
import cyborg.springboot.employee_rest_api.entity.Employee;
import cyborg.springboot.employee_rest_api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRESTController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRESTController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    // expose "/employees" and return list of employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // add mapping for GET /employees/{employeesId}
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {

        Employee theEmployee = employeeService.getEmployess(employeeId);

        if (theEmployee == null) {
            throw new EmployeeNotFoundException("Employee id not found - " + employeeId);
        }
        return theEmployee;
    }

    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleException(EmployeeNotFoundException exp) {

        // create a StudentErrorResponse

        EmployeeErrorResponse response = new EmployeeErrorResponse();

        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setMessage(exp.getMessage());
        response.setTimeStamp(System.currentTimeMillis());

        // return ResponseEntity
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

    }

    // add another exception handler.. to catch any exception(catch all)

    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleException(Exception e) {

        // create a StudentErrorResponse

        EmployeeErrorResponse response = new EmployeeErrorResponse();

        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setMessage(e.getMessage());
        response.setTimeStamp(System.currentTimeMillis());

        // return ResponseEntity
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


}
