package cyborg.springboot.employee_rest_api.DAO;

import cyborg.springboot.employee_rest_api.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> getAllEmployess();

    Employee getEmployess(int id);

    Employee saveEmployess(Employee employee);

    void deleteEmployess(int id);
}
