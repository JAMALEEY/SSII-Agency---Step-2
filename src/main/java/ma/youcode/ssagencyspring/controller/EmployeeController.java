package ma.youcode.ssagencyspring.controller;

import ma.youcode.ssagencyspring.dao.AdminDao;
import ma.youcode.ssagencyspring.dao.EmployeeDao;
import ma.youcode.ssagencyspring.entity.Admin;
import ma.youcode.ssagencyspring.entity.Employee;
import ma.youcode.ssagencyspring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class EmployeeController {
//
//    @Autowired
//    private AdminDao adminDao;
//    Admin theAdmin = adminDao.readAdmin(1L);
//
//    @RequestMapping("/")
//    public String login(Model theModel){
//        theModel.addAttribute("admin", theAdmin);
//        return "login";
//    }
//
//
//
//
//    @RequestMapping("/checkLogin")
//    public String checkLogin(@ModelAttribute("admin") Admin admin,
//                             @RequestParam(required=false, name = "emailAdress") String emailAdress,
//                             @RequestParam(required = false, name = "password") String password
//    ) {
//

//        if ((emailAdress != null) && (password != null)) {
//            if (emailAdress.contains(theAdmin.getEmailAdress()) && password.contains(theAdmin.getPassword())) {
//                return "list-employees";
//            }
//        }
//        return "redirect:/login";
//    }


    /* add an initbinder so I can convert trim input strings
    * to remove whitespace and resolve issueof validation
    * */

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

//    Injecting the DAO (this injection is possible because of the @Repository in the DaoImpl file)
//    In summ the spring will scan for a component that implements CustomerDAO interface
//    @Autowired
//    private EmployeeDao employeeDao;
//    Refactor here to enable relation with service first instead of DAO ...
    @Autowired
    private EmployeeService employeeService;


//    refactoring requestmappiing to getMapping so that we only have it through get requests by the browser
//    if we want only on post we go for PostMapping("/list")
    @GetMapping("/employees")
    public String listEmployees(Model theModel) {
//        Getting employees from service
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

    @PostMapping("/saveEmployee")
    public  String saveEmployee(
            @Valid @ModelAttribute("employee") Employee employee,
            BindingResult theBindingResult
    ){
// save the employee using EmployeeService that is relating on employeeDao
        if (theBindingResult.hasErrors()) {
            return "employee-form";
        } else {
            employeeService.saveEmployee(employee);
            return "redirect:/employees";
        }
    }

    @RequestMapping("/employees/updateEmployee")
//    public  String updateEmployee(Employee employee){
public  String updateEmployee(@ModelAttribute("employee") Employee employee){

// save the employee using EmployeeService that is relating on employeeDao
        employeeService.updateEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/employees/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") Long theId,
                                    Model theModel) {

        // get the employee from our service
        Employee employee = employeeService.getEmployee(theId);

        // set employee as a model attribute to pre-populate the form
        theModel.addAttribute("employee", employee);

        // send over to our form
        return "employee-form-update";
    }



    @GetMapping("/employees/delete")
    public String deleteEmployee(@RequestParam("employeeId") Long theId) {
        System.out.println("hada hwa: " + theId);
        // delete the customer
        employeeService.deleteEmployee(theId);

        return "redirect:/employees";
    }

}