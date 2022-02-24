package ma.youcode.ssagencyspring.dao;

import ma.youcode.ssagencyspring.entity.Employee;
import java.util.List;

public interface EmployeeDao {

    public void addEmployee();
    public void updateEmployee();
    public List<Employee> getEmployee();

}
