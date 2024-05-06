package cyborg.springboot.employee_rest_api.service;

import cyborg.springboot.employee_rest_api.DAO.EmployeeRepository;
import cyborg.springboot.employee_rest_api.entity.Employee;
import cyborg.springboot.employee_rest_api.rest.EmployeeNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
        employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> byId = employeeRepository.findById(id);

        Employee TheEmployee = null;
        if (byId.isPresent()) {
            TheEmployee = byId.get();
        } else {
            throw new EmployeeNotFoundException("Employee Not Found");
        }
        return TheEmployee;
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
