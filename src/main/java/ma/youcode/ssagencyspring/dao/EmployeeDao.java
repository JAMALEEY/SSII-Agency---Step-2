package ma.youcode.ssagencyspring.dao;

import ma.youcode.ssagencyspring.entity.Employee;
import java.util.List;

public interface EmployeeDao {

    public void addEmployee(Employee employee);
    public List<Employee> getEmployees();
    public void updateEmployee(Employee emp);
    public void deleteEmployee(Long theId);
    public Employee getEmployee(Long theId);


}
