package practice.post.practice2.filters;


import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class SearchEmptyFieldsFilter extends BaseFilter {
    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain filterChain) throws IOException, ServletException {

        String login=req.getParameter("login");
        String password=req.getParameter("password");

        if(login.equals("") || password.equals("") ){
            RequestDispatcher dispatcher = req.getRequestDispatcher("views/ErrorEmpty.jsp");
            dispatcher.forward(req, resp);

        } else {
            filterChain.doFilter(req, resp);
        }


    }
}
