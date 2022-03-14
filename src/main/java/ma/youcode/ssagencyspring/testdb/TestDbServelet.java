package ma.youcode.ssagencyspring.testdb;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

@WebServlet(name = "TestDbServelet", value = "/TestDbServelet")
public class TestDbServelet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        setup connection variables
        String user = "hbstudent";
        String pass = "hbstudent";

        String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker.customer";
        String driver = "com.mysql.cj.jdbc.Driver";

//        get connection to database
        try{
            PrintWriter out = response.getWriter();
            out.println("Connecting to database " + jdbcUrl);
            Class.forName(driver);

            Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);

            out.println(" Connection success !!! ");
            myConn.close();

        }catch (Exception exc) {
            exc.printStackTrace();
            throw new ServletException(exc);
        }
    }

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
}
