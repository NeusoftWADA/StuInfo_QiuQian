package DataBase;

import StuData.StuData;
import java.sql.*;

public class DataBase {
    Connection connection = null;

    public DataBase() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        this.connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=StuInfo", "sa", "qwert");
    }

    /**
     * 测试数据库是否连接成功
     */
    public void testConnection() {
        System.out.println(this.connection);
    }

    /**
     * 关闭数据库
     * @throws SQLException
     */
    public void close() throws SQLException {
        connection.close();
    }


    /**
     * 通过学号查询信息
     * @param ID
     * @return
     * @throws SQLException
     */
    public StuData getStuData(String ID) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM StuInfo WHERE ID = ?");
        preparedStatement.setString(1, ID);
        preparedStatement.executeQuery();

        ResultSet resultSet = preparedStatement.getResultSet();
        if ( resultSet.next() ) {
            String iD = resultSet.getString("ID");
            String Name = resultSet.getString("Name");
            String Gender = resultSet.getString("Gender");
            String Birthday = resultSet.getString("Birthday");
            String State = resultSet.getString("State");
            return new StuData(iD, Name, Gender, Birthday, State);
        }
        else {
            return null;
        }
    }

    /**
     * 通过学号删除信息
     * @param ID
     * @throws SQLException
     */
    public void Delete(String ID) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE StuInfo WHERE ID = ?");
        preparedStatement.setString(1, ID);
        preparedStatement.executeUpdate();
    }

    /**
     * 增加学生信息
     * @param ID
     * @param Name
     * @param Gender
     * @param Birthday
     * @param State
     * @throws SQLException
     */
    public void Create(String ID, String Name, String Gender, String Birthday, String State) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO StuInfo VALUES(?, ?, ?, ?, ?)");
        preparedStatement.setString(1, ID);
        preparedStatement.setString(2, Name);
        preparedStatement.setString(3, Gender);
        preparedStatement.setString(4, Birthday);
        preparedStatement.setString(5, State);
        preparedStatement.executeUpdate();
    }

    /**
     * 通过学号修改学生信息
     * @param ID
     * @param Name
     * @param Gender
     * @param Birthday
     * @param State
     * @throws SQLException
     */
    public void Update(String ID, String Name, String Gender, String Birthday, String State) throws SQLException {
        if ( Name != null && Name.length() > 0 ) {
            PreparedStatement preparedStatement1 = connection.prepareStatement("UPDATE StuInfo SET Name = ? WHERE ID = " + ID);
            preparedStatement1.setString(1, Name);
            preparedStatement1.executeUpdate();
        }

        if ( Gender != null && Gender.length() > 0 ) {
            PreparedStatement preparedStatement2 = connection.prepareStatement("UPDATE StuInfo SET Gender = ? WHERE ID = " + ID);
            preparedStatement2.setString(1, Gender);
            preparedStatement2.executeUpdate();
        }

        if ( Birthday != null && Birthday.length() > 0 ) {
            PreparedStatement preparedStatement3 = connection.prepareStatement("UPDATE StuInfo SET Birthday = ? WHERE ID = " + ID);
            preparedStatement3.setString(1, Birthday);
            preparedStatement3.executeUpdate();
        }

        if ( State != null && State.length() > 0 ) {
            PreparedStatement preparedStatement4 = connection.prepareStatement("UPDATE StuInfo SET State = ? WHERE ID = " + ID);
            preparedStatement4.setString(1, State);
            preparedStatement4.executeUpdate();
        }
    }
}