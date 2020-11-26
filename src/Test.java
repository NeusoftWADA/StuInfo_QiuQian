import DataBase.DataBase;

import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DataBase dataBase = new DataBase();
        dataBase.testConnection();
    }

}
