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

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
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

        System.out.println("ID" + ID);
        System.out.println("Name" + Name);
        System.out.println("Gender" + Gender);
        System.out.println("Birthday" + Birthday);
        System.out.println("State" + State);

        PrintWriter printWrite = response.getWriter();

        try {
            DataBase dataBase = new DataBase();
            StuData stuData = dataBase.getStuData(ID);
            if ( stuData == null ) {
                printWrite.write("没有找到学号为 " + ID + " 的信息！");
            }
            else {
                dataBase.Update(ID, Name, Gender, Birthday, State);
                printWrite.write("done!");
            }
            dataBase.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            printWrite.write("ERROR");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request, response);
    }
}
