package ma.youcode.ssagencyspring.dao;

import ma.youcode.ssagencyspring.entity.Employee;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// in the Dao our Hibernate Session Factory needs a data source this last by itself need a data source info all these are dependencies so we can do a dependency injection
// wiring all these dependencies using DI
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

//        creating the query

//        executing the query and getting the result list

//        returning the results
        return null;
    }

}
