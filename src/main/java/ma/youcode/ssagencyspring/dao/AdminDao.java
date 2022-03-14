package ma.youcode.ssagencyspring.dao;

import ma.youcode.ssagencyspring.entity.Admin;
import ma.youcode.ssagencyspring.entity.Employee;
import java.util.List;

public interface AdminDao {

    public Admin readAdmin (Long theId);
    public void createEmployee(Employee employee);
    public List<Employee> readEmployees();
    public void update(Employee employee);
    public void delete(Long theId);
    public Employee readEmployee(Long theId);


}
