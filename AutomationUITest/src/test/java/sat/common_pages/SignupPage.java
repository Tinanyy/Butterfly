package sat.common_pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import junit.framework.Assert;
import sat.testbases.Page;

import org.openqa.selenium.By;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import java.util.UUID;


public class SignupPage extends Page{
	
	String mockEmail;		// we randomly generate a String as account to sign up 
	
	public SignupPage(AndroidDriver<AndroidElement> driver){
		super(driver);
	}
	
	/*
	 * components ID
	 */
	
	// header
	By backBtnID = By.id("back");
	By titleLabelID = By.id("topBarTitle");
	
	// middle
	By emailFiledID = By.id("et_signup_email");
	By userNameFieldID = By.id("et_signup_username");
	By pwdFieldID = By.id("et_signup_password");
	By signupBtnID = By.id("btn_signup_confirm");
	
	// misc 
	By docLabelID = By.id("tv_signup_terms_2");
	By loginLabelID = By.id("tv_signup_login");
	//By allowPermissionID =By.id("permission_allow_button");
	
	
	/*
	 * manipulate components
	 */
	
	public void setEmailText(String email){
		driver.findElement(emailFiledID).sendKeys(email);
	}
	
	public void setUsernameText(String userName){
		driver.findElement(userNameFieldID).sendKeys(userName);
	}
	
	public void setPwdText(String pwd){
		driver.findElement(pwdFieldID).sendKeys(pwd);
	}
	
	public void clickSignupBtn(){
		driver.findElement(signupBtnID).click();
	}
	/*public void clickAllowPerBtn(){
		driver.findElement(allowPermissionID).click();
	}
	*/
	
	/*
	 * util functions
	 */
	
	public void signUp(String email, String userName, String pwd){
		this.setEmailText(email);
		this.setUsernameText(userName);
		this.setPwdText(pwd);
		this.clickSignupBtn();
	}
	
	public void signUp(){
		// fix this 
		UUID uid = UUID.randomUUID();
		mockEmail = uid.toString() + "@13.com";
		System.out.println("\nmockEmail: " + mockEmail + "\n");
		this.setEmailText(mockEmail);
		this.setUsernameText("test_tina");
		this.setPwdText("123456Nyy");
		this.clickSignupBtn();
		//this.clickAllowPerBtn();
	}
	
	public String getMockEmail(){
		return this.mockEmail;
	}
	
	public void deleteAccount(String email){
		cleanAccount(email);
	}
	
	public void deleteAccount(){
		cleanAccount(mockEmail);
	}
	
	// since Matt doesnt want us to delete in the production DB, so this function is actually not used.
	private void cleanAccount(String email){
		
		try{
			String host = "jdbc:jtds:sqlserver://54.148.220.80:1433;DatabaseName=SideChef2.1";
			String uName = "sa";
			String userPwd = "NICEguy2!";
			Connection con = DriverManager.getConnection(host,uName, userPwd);
			
			Statement stmt = con.createStatement();
			String selectID = "select tu.id from tb_user tu where tu.name = '" + email + "'";
			String userID;
			ResultSet res = stmt.executeQuery(selectID);
			res.next();
			userID = res.getString(1);
			System.out.println(userID);

			String delete1 = "delete from oauth2_provider_refreshtoken where user_id = " + userID;
			String delete2 = "delete from oauth2_provider_accesstoken where user_id = " + userID;
			String delete3 = "delete from auth_user where id =" + userID;
			String delete4 = "delete from api_userpartner where user_id =" + userID;
			String delete5 = "delete from mail_segmentuser where user_id = " + userID;
			String delete = "delete from tb_user where name = 'test@13.com' ";
			
			stmt.executeUpdate(delete1);
			stmt.executeUpdate(delete2);
			stmt.executeUpdate(delete3);
			stmt.executeUpdate(delete4);
			stmt.executeUpdate(delete5);
			stmt.executeUpdate(delete);
			
			System.out.println("deleted test data in DB.\n");
			
		}catch(SQLException err){
			System.out.println(err.getMessage());
		}
		
	}

	@Override
	public void checkPage() {
		// TODO Auto-generated method stub
		
	}

}
