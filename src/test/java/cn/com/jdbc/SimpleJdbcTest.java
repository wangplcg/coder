package cn.com.jdbc;

import org.junit.Test;

import java.sql.*;

/**
 * Created with IntelliJ IDEA.
 * Description: 简单Jdbc测试
 * User: Think
 * Date: 2019-04-25
 * Time: 23:30
 */
public class SimpleJdbcTest {

    @Test
    public void testSimpleJdbc() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://47.98.122.184:3306/myinfo_schema?useServerPrepStmts=true", "wangpl", "951213");
        String prepareSql = "select t.CATEGORY, t.TOWN tt, t.CITY, t.code from CODE_AREAS t where t.id = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(prepareSql, new String[]{"CATEGORY","TOWN"});
        preparedStatement.setString(1, "1");
        ResultSet resultSet = preparedStatement.executeQuery();


        ResultSetMetaData metaData = resultSet.getMetaData();
        System.out.println(metaData.getColumnCount());
        for (int i = 1; i <= metaData.getColumnCount(); i++) {
            System.out.println(metaData.getColumnLabel(i));
            System.out.println(metaData.getColumnName(i));
        }
        preparedStatement.close();
    }
}
