//package ma.youcode.ssagencyspring.controller;
//
//import ma.youcode.ssagencyspring.dao.EmployeeDao;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller()
//public class Home {
//    @RequestMapping(value = "/")
//        public String processLogin(@ModelAttribute("employee") EmployeeDao employee) {
//            System.out.println("employee " + employee.getFirstName() + " " + employee.getLastName());
//        return "home";
//    }
//
//    @RequestMapping("/login")
//    public String login() {
//        return "login";
//    }
//
//    @RequestMapping("/customer")
//    public String customer() {
//        return "customer-form";
//    }
//}
