package ma.youcode.ssagencyspring.controller;

import ma.youcode.ssagencyspring.dao.EmployeeDao;
import ma.youcode.ssagencyspring.entity.Employee;
import ma.youcode.ssagencyspring.service.EmployeeService;
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
//    @Autowired
//    private EmployeeDao employeeDao;e
//    Refactor here to enable relation with service first instead of DAO ...
    @Autowired
    private EmployeeService employeeService;


//    refactoring requestmappiing to getMapping so that we only have it through get requests by the browser
//    if we want only on post we go for PostMapping("/list")
    @GetMapping("/list")
    public String listEmployees(Model theModel) {
//        Getting employees from DAO
        List<Employee> employees = employeeService.getEmployees();
//        Adding Employees to the model
        theModel.addAttribute("employees", employees);
//        returning the result
        return "list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){
        //Create model attribute to bind form data in the jsp view
        Employee employee = new Employee();
        theModel.addAttribute("employee", employee);
        return "employee-form";
    }

}