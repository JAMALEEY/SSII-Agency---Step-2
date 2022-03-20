package ma.youcode.ssagencyspring.service;

//Service facade design pattern
//basiccaly its a layer for custom business logic
// and it integrates data from multiple sources (DAO ... REPOSITORIES ...)

import ma.youcode.ssagencyspring.dao.EmployeeDao;
import ma.youcode.ssagencyspring.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

//    injecting the DAO
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        employeeDao.addEmployee(employee);
    }

    @Override
    @Transactional
    public void updateEmployee(Employee emp) {
        employeeDao.updateEmployee(emp);
    }

//    @Override
//    public void updateEmployee(Employee employee) {
//        employeeDao.updateEmployee(employee);
//    }

    @Transactional
    @Override
    public void deleteEmployee(Long theId) {
        employeeDao.deleteEmployee(theId);
    }

    @Override
    //    Managing the session automagically (commit ... update session etc auto)

    @Transactional
    public List<Employee> getEmployees() {
        return employeeDao.getEmployees();
    }

    @Transactional
    @Override
    public Employee getEmployee(Long theId) {
        return employeeDao.getEmployee(theId);
    }
}
