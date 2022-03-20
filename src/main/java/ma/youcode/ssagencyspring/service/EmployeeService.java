package ma.youcode.ssagencyspring.service;

import ma.youcode.ssagencyspring.entity.Employee;

import java.util.List;

public interface EmployeeService {

    void saveEmployee(Employee employee);
    void updateEmployee(Employee emp);
    void deleteEmployee(Long theId);
    public List<Employee> getEmployees();

    Employee getEmployee(Long theId);
}
