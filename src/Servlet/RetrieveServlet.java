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

@WebServlet("/RetrieveServlet")
public class RetrieveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //固定操作，设置字符格式
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setHeader("content-type", "text/html;charset=utf-8");

        //从前端获取学号
        String ID = request.getParameter("SIID");
        System.out.println(ID);
        PrintWriter printWrite = response.getWriter();

        try {
            //连接数据库
            DataBase dataBase = new DataBase();
            //从数据库中获取信息
            StuData stuData = dataBase.getStuData(ID);
            //关闭数据库
            dataBase.close();

            if ( stuData == null ) {
                printWrite.write("信息有误，请返回重新输入");
            }
            else {
                //输出stuData中所有信息
                printWrite.write("学号: " + stuData.getID() + "<br>");
                printWrite.write("姓名: " + stuData.getName() + "<br>");
                printWrite.write("性别: " + stuData.getGender() + "<br>");
                printWrite.write("生日: " + stuData.getBirthday() + "<br>");
                printWrite.write("状态:  " + stuData.getState() + "<br>");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            printWrite.write("ERROR");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request, response);
    }
}
