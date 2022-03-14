package ma.youcode.ssagencyspring.dao;

import ma.youcode.ssagencyspring.entity.Admin;
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
public class AdminDaoImpl implements AdminDao {

    //    session factory injection :
    @Autowired
    private SessionFactory sessionFactory;
    private String firstName;
    private String lastName;
    private String email;


    @Override
    public Admin readAdmin(Long theId) {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // now retrieve/read from database using the primary key
        Admin theAdmin = currentSession.get(Admin.class, theId);

        return theAdmin;
    }

    @Override
    public void createEmployee(Employee employee) {

    }

    @Override
    public List<Employee> readEmployees() {
        return null;
    }

    @Override
    public void update(Employee employee) {

    }

    @Override
    public void delete(Long theId) {

    }

    @Override
    public Employee readEmployee(Long theId) {
        return null;
    }
}
