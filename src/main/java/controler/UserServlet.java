package controler;

import model.User;
import service.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name ="UserServlet",value = "/users")
public class UserServlet extends HttpServlet {
    public static UserServiceImp userServiceImp = new UserServiceImp();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        try {

            switch (action) {
                case "create":
                    createUser(req, resp);
                    break;
                case "delete":
                    deleteUser(req,resp);
                    break;
                case "update":
                    UpdateUser(req,resp);
                    break;
                case "search":
                    SearchUser(req,resp);
                    break;
                default:
                    break;
            }
        }catch (SQLException | ClassNotFoundException e){
              req.getRequestDispatcher("user/error.jsp");
        }
    }
    public void createUser(HttpServletRequest request ,HttpServletResponse response) throws SQLException, ServletException, IOException, ClassNotFoundException {
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String contry = request.getParameter("contry");
        User user = new User(name,age,contry);
        userServiceImp.insertUser(user);
        request.setAttribute("message"," them thanh cong");
        request.getRequestDispatcher("user/create.jsp").forward(request,response);
    }
    public void deleteUser(HttpServletRequest request , HttpServletResponse response) throws SQLException, ServletException, IOException, ClassNotFoundException {
        int id = Integer.parseInt(request.getParameter("id"));
        userServiceImp.deleteUser(id);
        request.setAttribute("message","xoa thanh cong");
        request.getRequestDispatcher("user/delete.jsp").forward(request,response);
    }

    public void UpdateUser(HttpServletRequest request , HttpServletResponse response) throws SQLException, ServletException, IOException, ClassNotFoundException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String contry = request.getParameter("contry");
        User user = new User(id,name,age,contry);
        userServiceImp.UpdateUser(user);
        request.getRequestDispatcher("user/edit.jsp").forward(request,response);
    }
    public void SearchUser (HttpServletRequest request , HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        String country = request.getParameter("contry");
        List<User> list = userServiceImp.searchByCountry(country);
        request.setAttribute("list",list);
        request.getRequestDispatcher("user/search.jsp").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        try {

            switch (action) {
                case "create":
                    FormCreate(req, resp);
                    break;
                case "delete":
                    FormDelete(req,resp);
                    break;
                case "update":
                     FormUpdate(req,resp);
                    break;
                case "search":
                    FormSearch(req,resp);
                    break;
                default:
                     listUser(req,resp);
                    break;
            }
        }catch (SQLException | ClassNotFoundException a){
            throw new RuntimeException();
        }
    }
    public void FormCreate(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("user/create.jsp").forward(request,response);
    }
    public void FormSearch(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("user/search.jsp").forward(request,response);
    }
    public void FormDelete(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        int id = Integer.parseInt(request.getParameter("id"));
        List<User> list = userServiceImp.selectAll();
        for (User user : list) {
            if (id == user.getId()){
                request.setAttribute("user",user);
                request.getRequestDispatcher("user/delete.jsp").forward(request,response);
            }
        }
    }
    public void FormUpdate(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        int id = Integer.parseInt(request.getParameter("id"));
        List<User> list = userServiceImp.selectAll();
        for (User user : list) {
            if (id == user.getId()){
                request.setAttribute("user",user);
                request.getRequestDispatcher("user/edit.jsp").forward(request,response);
            }
        }
    }
    public void listUser(HttpServletRequest request , HttpServletResponse response) throws SQLException, ServletException, IOException, ClassNotFoundException {
        List<User> list = userServiceImp.selectAll();
        request.setAttribute("list",list);
        request.getRequestDispatcher("user/list.jsp").forward(request,response);
    }
}
