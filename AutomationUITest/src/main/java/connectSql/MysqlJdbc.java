package connectSql;
import java.sql.*;

public class MysqlJdbc {
   public static void main(String[] args) {
	   
	   try {
		      Class.forName("com.mysql.jdbc.Driver");    //加载MYSQL JDBC驱动程序 
		      //Class.forName("org.gjt.mm.mysql.Driver");
		      System.out.println("Success loading Mysql Driver!");
		    }
		    catch (Exception e) {
		      System.out.print("Error loading Mysql Driver!");
		      e.printStackTrace();
		    }
		    try {
		      Connection connect = DriverManager.getConnection(
		      "jdbc:mysql://mysql57.c8blom7xcpc4.us-west-2.rds.amazonaws.com/djangodb_stage","stager","KdErr7EBQNQh");
		//连接URL为   jdbc:mysql//服务器地址/数据库名
		//后面的2个参数分别是登陆用户名和密码
		      System.out.println("Success connect Mysql server!");
		   /*   Statement stmt = connect.createStatement();
		// 表名mytest_acount
		     ResultSet rs = stmt.executeQuery("select * from mytest_acount");
		      while (rs.next()) {
		        System.out.println(rs.getString("col1"));
		      }*/
		    } 
		    catch (Exception e) {
		      System.out.print("get data error!");
		       e.printStackTrace();
		    }
           }
   }
