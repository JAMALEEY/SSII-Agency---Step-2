//package ma.youcode.ssagencyspring.controller;
//
//import ma.youcode.ssagencyspring.dao.EmployeeDao;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("/employees")
//public class EmployeeController {
//
//    @RequestMapping("/login")
//    public String showEmployee(Model theModel) {
////        Create a employee object
//        EmployeeDao employee = new EmployeeDao();
////        Add employee object to the model
//        theModel.addAttribute("employee", employee);
//        return "login";
//    }
//
//    @RequestMapping("/processLogin")
//    public String processLogin(@ModelAttribute("employee") EmployeeDao employee) {
//        System.out.println("employee " + employee.getFirstName() + " " + employee.getLastName());
//        return "login-confirmation";
//    }
//
//}
