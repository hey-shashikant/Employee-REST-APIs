package cyborg.springboot.employee_rest_api.service;

import cyborg.springboot.employee_rest_api.DAO.EmployeeDAO;
import cyborg.springboot.employee_rest_api.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO TheEmployeeDAO) {
        employeeDAO = TheEmployeeDAO;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployess();
    }

    @Override
    public Employee getEmployess(int id) {
        return employeeDAO.getEmployess(id);
    }

    @Transactional
    @Override
    public Employee saveEmployess(Employee employee) {
        return employeeDAO.saveEmployess(employee);
    }

    @Transactional
    @Override
    public void deleteEmployess(int id) {
        employeeDAO.deleteEmployess(id);
    }
}
