package cyborg.springboot.employee_rest_api.service;

import cyborg.springboot.employee_rest_api.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);

}
