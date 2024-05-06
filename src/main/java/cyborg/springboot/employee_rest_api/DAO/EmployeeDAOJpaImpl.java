package cyborg.springboot.employee_rest_api.DAO;

import cyborg.springboot.employee_rest_api.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    // define field for entitymanager
    private EntityManager entityManager;

    //setup constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> getAllEmployess() {

        // create a query
        TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);

        // execute query and get result list
        List<Employee> employees = query.getResultList();

        // return the results
        return employees;

    }

    @Override
    public Employee getEmployess(int id) {

        // get employee
        Employee employee = entityManager.find(Employee.class, id);

        // return employee
        return employee;
    }

    @Override
    public Employee saveEmployess(Employee employee) {

        // add/update employee
        Employee savedEmployee = entityManager.merge(employee);

        // return employee
        return savedEmployee;
    }

    @Override
    public void deleteEmployess(int id) {

        // delete query
        Employee employee = entityManager.find(Employee.class, id);

        // delete employee
        entityManager.remove(employee);
    }
}
