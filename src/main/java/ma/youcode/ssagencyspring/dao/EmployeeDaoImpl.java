package ma.youcode.ssagencyspring.dao;

import ma.youcode.ssagencyspring.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

// in the Dao our Hibernate Session Factory needs a data source this last by itself need a data source info all these are dependencies so we can do a dependency injection
// wiring all these dependencies using DI

// In order to enable Dao scanning by spring and to handle exceptions
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    //    session factory injection :
    @Autowired
    private SessionFactory sessionFactory;
    private String firstName;
    private String lastName;
    private String email;


    @Override
    public void addEmployee(Employee employee) {
//        Getting current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
//        creating query to save the new employee
        currentSession.saveOrUpdate(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {

    }

    @Override
    public void deleteEmployee(Long theId) {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // delete object with primary key
        Query theQuery =
                currentSession.createQuery("delete from Employee where id=:employeeId");
        theQuery.setParameter("employeeId", theId);

        theQuery.executeUpdate();
    }



    @Override
    public List<Employee> getEmployees() {

//        getting current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

//        creating the query ... + BONUS SORTING BY LAST NAME ASSENDING
        Query<Employee> from_employee =
                currentSession.createQuery("from Employee order by lastName", Employee.class);
//        executing the query and getting the result list
        List<Employee> employees = from_employee.getResultList();

//        returning the results
        return employees;
    }
//we enjected our session factory


    @Override
    public Employee getEmployee(Long theId) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // now retrieve/read from database using the primary key
        Employee theEmployee = currentSession.get(Employee.class, theId);

        return theEmployee;
    }

}
