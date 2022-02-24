package ma.youcode.ssagencyspring.controller;

import ma.youcode.ssagencyspring.dao.EmployeeDao;
import ma.youcode.ssagencyspring.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
//    Injecting the DAO (this injection is possible because of the @Repository in the DaoImpl file)
//    In summ the spring will scan for a component that implements CustomerDAO interface
    @Autowired
    private EmployeeDao employeeDao;

//    refactoring requestmappiing to getMapping so that we only have it through get requests by the browser
    @GetMapping("/list")
    public String listEmployees(Model theModel) {
//        Getting employees from DAO
        List<Employee> employees = employeeDao.getEmployee();
//        Adding Employees to the model
        theModel.addAttribute("employees", employees);
//        returning the result
        return "list-employees";
    }


}