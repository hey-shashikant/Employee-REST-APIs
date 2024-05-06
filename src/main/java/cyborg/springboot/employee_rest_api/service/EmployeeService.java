package cyborg.springboot.employee_rest_api.service;

import cyborg.springboot.employee_rest_api.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Employee getEmployess(int id);

    Employee saveEmployess(Employee employee);

    String deleteEmployess(int id);

}
