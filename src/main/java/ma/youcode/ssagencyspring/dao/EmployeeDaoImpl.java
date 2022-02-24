package ma.youcode.ssagencyspring.dao;

import ma.youcode.ssagencyspring.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
//    Managing the session automagically
    @Transactional
    public List<Employee> getEmployee() {

//        getting current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

//        creating the query
        Query<Employee> from_employee =
                currentSession.createQuery("from Employee", Employee.class);
//        executing the query and getting the result list
            List<Employee> employees = from_employee.getResultList();

//        returning the results
        return employees;
    }
//we enjected our session factory
}
