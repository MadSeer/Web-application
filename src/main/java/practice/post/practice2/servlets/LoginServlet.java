package practice.post.practice2.servlets;

import javafx.print.Collation;
import practice.post.practice2.User;
import practice.post.practice2.UserCache;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

public class LoginServlet extends HttpServlet {
    private static final UserCache USER_CACHE = UserCache.getInstance();
    private static final AtomicInteger ids = new AtomicInteger();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login=req.getParameter("login");
        String password=req.getParameter("password");

        Collection<User> users = this.USER_CACHE.values();
        boolean mark = false;
        for (User u: users) {
            if (login.equals(u.getLogin()) && password.equals(u.getPassword())) {
                HttpSession session = req.getSession();
                session.setAttribute("user", u);
                mark = true;
                break;
            }
        }

        if(mark){
            resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/enter")); // внешний редирект
        } else {
            RequestDispatcher dispatcher = req.getRequestDispatcher("views/Error.jsp");
            dispatcher.forward(req, resp);

        }


    }
}
