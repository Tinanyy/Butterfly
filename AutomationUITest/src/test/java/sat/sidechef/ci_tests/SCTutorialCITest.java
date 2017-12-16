package sat.sidechef.ci_tests;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import sat.sidechef.pages.SCTutorialPage;
import sat.testbases.SideChefCITestBase;
import sat.utils.SCMisc;
public class SCTutorialCITest extends SideChefCITestBase{
	
	/*
	 * declare pages
	 */
	SCMisc objMisc;
	SCTutorialPage objTutorial;
	
	@BeforeMethod
	@BeforeClass
	public void setUp(){
		// set up pages
		objMisc = new SCMisc(driver);
		objTutorial = new SCTutorialPage(driver);
	}

	
	@Test
	public void testTutorial() throws InterruptedException{
		
		// check the first page of tutorial
		objTutorial.checkMainpage();
		// go to one recipe
		objMisc.swipeToUp(300, 1);
		//driver.tap(1, 1297, 1200, 10);
		objMisc.tapRecipe(1,300);     
		//check the 'tap the bookmark' page
		
		// check the recipe overview of tutorial
		objTutorial.checkTapBookMark();
		objMisc.swipeToUp(300, 3);
		objTutorial.checkTapTheBtn();
		objTutorial.checkStepByStep();
		TimeUnit.SECONDS.sleep(2);
		
	}	

}
