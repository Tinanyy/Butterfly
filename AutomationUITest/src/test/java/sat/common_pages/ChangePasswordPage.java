package sat.common_pages;
import org.junit.Assert;
import org.openqa.selenium.By;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import sat.testbases.Page;

/* this is the page of changing password in app internal
 * 
 */
public class ChangePasswordPage extends Page{

	public ChangePasswordPage(AndroidDriver<AndroidElement> driver)
	{
		super(driver);
	}
	
/*components ID*
 * (non-Javadoc)
 * @see sat.testbases.Page#checkPage()
 */
	
	By profileBtnID=By.id("bottomButtonProfile");
    By settingBtnID=By.id("setting");
    By changePwdLabelID=By.id("changePwd");
    
	By checkBtnID=By.id("rightButton");     //tick btn on the top right of the page
	By backBtnID=By.id("leftButton");
	By topTitleID=By.id("topBarTitle");
	By currentPwdID = By.id("currentPwd");				
	By newPwdID = By.id("newPwd");
	By confirmPwdID=By.id("confirmPwd");
	
	By logOutBtnID=By.id("logout");
	
	//deal with login stuff
	By userNameID = By.id("et_login_username");	// username field, put email here
	By pwdID = By.id("et_login_password");	// pwd field
	By loginBtnID = By.id("btn_login_signin"); // login btn
	
	public AndroidElement getUserNameField(){
		return driver.findElement(userNameID);
	}
	
	public AndroidElement getPwdField(){
		return driver.findElement(pwdID);
	}
	
	public AndroidElement getLoginBtn(){
		return driver.findElement(loginBtnID);
	}
	
	
	public void setUserNameText(String userName)
	{
		getUserNameField().sendKeys(userName);
	}
   
	public void setPasswordText(String Pwd)
	{
		getPwdField().sendKeys(Pwd);
	}
	
	public void login(String userName, String Pwd){
		setUserNameText(userName);	
		setPasswordText(Pwd);
		clickLoginBtn();
	}
	
	
//need to add stuff about error info,we will do it later....
	
	public AndroidElement getProfileBottomBtn()
	{
		return driver.findElement(profileBtnID);
	}
	public AndroidElement getSettingBtn()
	{
		return driver.findElement(settingBtnID);
	}
	
	public AndroidElement getChangePwdLabel(){
		return driver.findElement(changePwdLabelID);
	}
	public AndroidElement getCheckMark(){
		return driver.findElement(checkBtnID);
	}
	public AndroidElement getBackBtn(){
		return driver.findElement(backBtnID);
	}
	public AndroidElement getTopTitle(){
		return driver.findElement(topTitleID);
	}
	 
	public AndroidElement getCurrentPwd(){
		return driver.findElement(currentPwdID);	
	}
	
	public AndroidElement getNewPwd(){
		return driver.findElement(newPwdID);
	}
	
	public AndroidElement getConfirmPwd(){
		return driver.findElement(confirmPwdID);
	}
	
	public AndroidElement getLogOutLabel()
	{
		return driver.findElement(logOutBtnID);
	}
	
	//set pwd
	public void setCurrentPwd(String curPwd)
	{
		getCurrentPwd().sendKeys(curPwd);
	}
   
	public void setNewPwd(String newPwd)
	{
		getNewPwd().sendKeys(newPwd);
	}
	
	public void setConfirmPwd(String confirmPwd){
		getConfirmPwd().sendKeys(confirmPwd);
	}
	
	public void inputPwd(){
		setCurrentPwd("123456Nyy");
		setNewPwd("12345678Nyy");
		setConfirmPwd("12345678Nyy");
	}
	
	public void inputPwdBack(){
		setCurrentPwd("12345678Nyy");
		setNewPwd("123456Nyy");
		setConfirmPwd("123456Nyy");
	}
	
	//click events
	public void clickCheckMark(){
		getCheckMark().click();
	}
	
	public void enterChangePwdPage(){
		getProfileBottomBtn().click();
		getSettingBtn().click();
		getChangePwdLabel().click();
	}
	
	public void clickLogOutLabel(){
		getLogOutLabel().click();
	}
	
	public void clickLoginBtn(){
		getLoginBtn().click();
	}
	@Override
	public void checkPage() {
		// TODO Auto-generated method stub
		//Assert.assertNotNull(getBackBtn());
		Assert.assertNotNull(getTopTitle());
		Assert.assertNotNull(getCheckMark());
		Assert.assertNotNull(getCurrentPwd());
		Assert.assertNotNull(getNewPwd());
		Assert.assertNotNull(getConfirmPwd());
	}
	
	
}
