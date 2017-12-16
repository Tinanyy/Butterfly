package sat.sidechef.ci_tests;
import org.openqa.selenium.Dimension;
import org.testng.annotations.*;
import sat.sidechef.pages.SCLandingPage;
import sat.sidechef.pages.SCNavigationBottomBarPage;
import sat.sidechef.pages.SCTutorialPage;
import sat.testbases.SideChefCITestBase;
import sat.utils.SCMisc;
public class SCTest4CITest extends SideChefCITestBase{

	SCTutorialPage objTutorial;
	SCMisc objMisc;
	SCLandingPage objLanding;
	SCNavigationBottomBarPage objNavBar;
	
	@BeforeClass
	public void setUp(){
		
		// set up pages
		objTutorial = new SCTutorialPage(driver);
		objMisc = new SCMisc(driver);
		objLanding = new SCLandingPage(driver);
		objNavBar = new SCNavigationBottomBarPage(driver);

	}
	
	
	@Test
	public void testIt() throws InterruptedException{
		
		Dimension screenSize = driver.manage().window().getSize();
        System.out.print(screenSize.width);
        System.out.print('\n');
        System.out.print(screenSize.height);
       
	}
	
	
}
