package sat.sidechef.pages;
import connectSql.MysqlJdbc;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import sat.common_pages.ChangePasswordPage;

public class SCChangePasswordPage extends ChangePasswordPage{

	public SCChangePasswordPage(AndroidDriver<AndroidElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	MysqlJdbc conn =new MysqlJdbc();
	
	public int update()
	{
		int i=0;
	//	String sql="update TB_User set Password "       need to wait for 5G
		return i;
	}
	
	

}
