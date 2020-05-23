package practice.post.practice2.filters;


import practice.post.practice2.User;
import practice.post.practice2.UserCache;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;


    public class AlreadyExistFilter extends BaseFilter {
    private static final UserCache USER_CACHE = UserCache.getInstance();
    private static final AtomicInteger ids = new AtomicInteger();

    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        String login=req.getParameter("login");

        Collection<User> users = this.USER_CACHE.values();
        boolean mark = false;
        for (User u: users) {
            if (login.equals(u.getLogin()) ) {
                HttpSession session = req.getSession();
                session.setAttribute("user", u);
                mark = true;
                break;
            }
        }

        if(mark){
            RequestDispatcher dispatcher = req.getRequestDispatcher("views/ErrorExist.jsp");
            dispatcher.forward(req, resp); // внешний редирект
        } else {
            filterChain.doFilter(req, resp);

        }


    }
}
