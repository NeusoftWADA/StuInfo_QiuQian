package Servlet;

import DataBase.DataBase;
import StuData.StuData;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/CreateServlet")
public class CreateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //固定操作，设置字符格式
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setHeader("content-type", "text/html;charset=utf-8");

        //从前端获取内容
        String ID = request.getParameter("ID");
        String Name = request.getParameter("Name");
        String Gender = request.getParameter("Gender");
        String Birthday = request.getParameter("Birthday");
        String State = request.getParameter("State");

        PrintWriter printWrite = response.getWriter();

        try {
            DataBase dataBase = new DataBase();
            dataBase.Create(ID, Name, Gender, Birthday, State);
            dataBase.close();
            printWrite.write("done!");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            printWrite.write("ERROR");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request, response);
    }
}
