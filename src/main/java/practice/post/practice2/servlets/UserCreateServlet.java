package practice.post.practice2.servlets;

import practice.post.practice2.User;
import practice.post.practice2.UserCache;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Сервлет для создания нового юзера
 * @author Ihor Savchenko
 * @version 1.0
 */
public class UserCreateServlet extends HttpServlet {
    private static final UserCache USER_CACHE = UserCache.getInstance();
    private static final AtomicInteger ids = new AtomicInteger();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.USER_CACHE.add(new User(this.ids.incrementAndGet(), req.getParameter("login"), req.getParameter("password")));
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/view")); // внешний редирект
    }
}
