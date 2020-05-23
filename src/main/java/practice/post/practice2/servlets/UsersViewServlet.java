package practice.post.practice2.servlets;

import practice.post.practice2.UserCache;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Сервлет для подготовки к рендерингу страницы Users.jsp
 * @author Ihor Savchenko
 * @version 1.0
 */
public class UsersViewServlet extends HttpServlet {
    private static final UserCache USER_CACHE = UserCache.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("usersAttr", this.USER_CACHE.values()); // Создаём по ключу usersAttr объект, в который записывается
                                                             // коллекция юзеров из map
        RequestDispatcher dispatcher = req.getRequestDispatcher("views/Users.jsp"); // внутренний редирект на Users.jsp
        dispatcher.forward(req, resp);
    }
}
