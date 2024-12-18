package com.example.demojdbc.Controller;

import com.example.demojdbc.Model.User;
import com.example.demojdbc.Service.IUserService;
import com.example.demojdbc.Service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

    public static final IUserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        String action = req.getParameter("action");
        System.out.println(action );
        if (action == null) {
            action = "list";
        }
        switch (action) {
            case "add":
                showAddUser(req, resp);
                break;
            case "edit":
                showUpdateUser(req, resp);
                break;
            case "delete":
                deleteUserAction(req, resp);
                break;
            default:
                showAllUser(req, resp);
                break;
        }
    }

    private void showUpdateUser(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        User user = userService.getUserById(id);
        req.setAttribute("user", user);
        RequestDispatcher dispatcher = req.getRequestDispatcher("user/edit.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showAddUser(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher dispatcher = req.getRequestDispatcher("user/add.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteUserAction(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        try {
            userService.deleteUser(id);
            showAllUser(req, resp);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void showAllUser(HttpServletRequest req, HttpServletResponse resp) {
        try{
            List<User> users = userService.getAllUser();
            req.setAttribute("users", users);
            RequestDispatcher dispatcher = req.getRequestDispatcher("user/list.jsp");
            dispatcher.forward(req, resp);
        }catch (SQLException | ClassNotFoundException | ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        String action = req.getParameter("action");
        System.out.println(action);
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                addUserAction(req, resp);
                break;
            case "edit":
                updateUserAction(req, resp);
                break;
            case "search":
                searchUserAction(req, resp);
                break;
            default:
                showAllUser(req, resp);
                break;
        }
    }

    private void searchUserAction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyword = req.getParameter("keyword");
        System.out.println(keyword);
        if (keyword == null || keyword.trim().isEmpty()) {
            req.setAttribute("error", "Keyword cannot be empty!");
            showAllUser(req, resp);
            return;
        }
        List<User> users = userService.getUserByName(keyword);
        if (users.isEmpty()) {
            req.setAttribute("message", "No employees found matching the keyword: " + keyword);
        } else {
            req.setAttribute("users", users);
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("user/list.jsp");
        dispatcher.forward(req, resp);
    }


    private void updateUserAction(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String password = req.getParameter("password");
        String address = req.getParameter("address");
        User user = new User(id, name, phone, password, address);
        userService.updateUser(id,user);
        showAllUser(req, resp);
    }

    private void addUserAction(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String password = req.getParameter("password");
        String address = req.getParameter("address");
        User user = new User(name, phone, password, address);
        userService.addUser(user);
        resp.sendRedirect("/user");
    }
}

