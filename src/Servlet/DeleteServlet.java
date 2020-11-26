package Servlet;

import DataBase.DataBase;
import StuData.StuData;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //固定操作，设置字符格式
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setHeader("content-type", "text/html;charset=utf-8");

        //从前端获取学号
        String ID = request.getParameter("SIID");
        PrintWriter printWrite = response.getWriter();

        try {
            DataBase dataBase = new DataBase();
            StuData stuData = dataBase.getStuData(ID);
            if ( stuData == null ) {
                printWrite.write("没有查询到学号为 " + ID + " 的学生信息!");
            }
            else {
                dataBase.Delete(ID);
                printWrite.write("done!");
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
