package ma.youcode.ssagencyspring.controller;

import org.springframework.stereotype.Controller;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


@Controller
@WebFilter(urlPatterns = {"/employees/*"})
public class AuthenticationFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse  = (HttpServletResponse) servletResponse;
        HttpSession mySession = httpServletRequest.getSession(false);
        boolean loggedIn = (mySession != null) && (mySession.getAttribute("adminId") != null);
            if (loggedIn) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                httpServletResponse.setContentType("text/html");
                PrintWriter out = httpServletResponse.getWriter();
                out.println("NO ACCESS");
            }

    }

    @Override
    public void destroy() {
    }
}
