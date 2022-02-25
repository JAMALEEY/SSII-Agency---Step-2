package ma.youcode.ssagencyspring.dao;

import ma.youcode.ssagencyspring.entity.Employee;
import java.util.List;

public interface EmployeeDao {

    public void addEmployee(Employee employee);
    public List<Employee> getEmployees();
    public void updateEmployee(Employee employee);
    public void deleteEmployee(Employee employee);
    public Employee getEmployee(Long theId);


}
