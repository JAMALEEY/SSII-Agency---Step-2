package ma.youcode.ssagencyspring.controller;

import ma.youcode.ssagencyspring.dao.AdminDao;
import ma.youcode.ssagencyspring.dao.EmployeeDao;
import ma.youcode.ssagencyspring.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sun.jvm.hotspot.runtime.posix.POSIXSignals;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

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
        public ModelAndView checkLogin(@ModelAttribute("admin") Admin admin,
                                       HttpServletRequest request,
                                       Model loginModel,
                                       @RequestParam(required = false, name = "emailAdress") String emailAdress,
                                       @RequestParam(required = false, name = "password") String password
    ) throws IOException {
        Admin myAdmin = adminDao.readAdmin(1L);
        if ((emailAdress != null) && (password != null)) {
            if (emailAdress.contains(myAdmin.getEmailAdress()) && password.contains(myAdmin.getPassword())) {
                HttpSession mySession = request.getSession();
                mySession.setAttribute("adminId", myAdmin.getId());
                mySession.setAttribute("theAdmin", myAdmin.getEmailAdress());
                return new ModelAndView("redirect:/employees");
            } else {
                loginModel.addAttribute("error", "Sorry, admin not found try again");
                return new ModelAndView("login");
            }

        }
        return null;
    }

    @RequestMapping("/logout")
        public String logout(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }



}
