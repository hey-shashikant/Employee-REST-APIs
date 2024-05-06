package cyborg.springboot.employee_rest_api.service;

import cyborg.springboot.employee_rest_api.DAO.EmployeeDAO;
import cyborg.springboot.employee_rest_api.entity.Employee;
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
}
