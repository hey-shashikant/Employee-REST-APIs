package cyborg.springboot.employee_rest_api.DAO;

import cyborg.springboot.employee_rest_api.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
