package ma.youcode.ssagencyspring.controller;

import ma.youcode.ssagencyspring.dao.AdminDao;
import ma.youcode.ssagencyspring.dao.EmployeeDao;
import ma.youcode.ssagencyspring.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sun.jvm.hotspot.runtime.posix.POSIXSignals;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private AdminDao adminDao;
//    Admin theAdmin = adminDao.readAdmin(1L);

    @RequestMapping(value = "/")
    public String login(Model theModel) {
        Admin admin = new Admin();
        theModel.addAttribute("admin", admin);
        return "login";
    }

    @PostMapping("/checkLogin")
    public String checkLogin(@Valid @ModelAttribute("admin") Admin admin,
                             @RequestParam(required = false, name = "emailAdress") String emailAdress,
                             @RequestParam(required = false, name = "password") String password,
                             BindingResult theBindingResult

    ) {
        Admin myAdmin = adminDao.readAdmin(1L);
//        String emailAdress = myAdmin.getEmailAdress();
//        String password = myAdmin.getPassword();

        System.out.println("admin email =  " + myAdmin.getEmailAdress() + " " + myAdmin.getPassword());
        if ((emailAdress != null) && (password != null)) {
            if (
                            emailAdress.contains(myAdmin.getEmailAdress()) &&
                            password.contains(myAdmin.getPassword())
            ) {
                return "redirect:/employees";
            } else if(theBindingResult.hasErrors()){
                return "login";
            }

        }
        return "redirect:/";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }
//        return "login";

//    public String processLogin(@ModelAttribute("admin") Admin admin,
//                                   @RequestParam(required=false, name = "emailAdress") String emailAdress,
//                                   @RequestParam(required = false, name = "password") String password
//    ) {
//        admin.setEmailAdress(emailAdress);
//        admin.setPassword(password);
//            System.out.println("admin email =  " + admin.getEmailAdress() + " " + admin.getPassword());
//        return "login";
//    }


}
