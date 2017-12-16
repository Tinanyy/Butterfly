package sat.budgetbyte.ci_tests;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import sat.budgetbyte.pages.BBTutorialPage;
import sat.utils.BBMisc;
import sat.testbases.BudgetByteCITestBase;

public class BBTutorialCITest extends BudgetByteCITestBase{

	BBMisc bbMisc;
	BBTutorialPage bbTutorial;
	@Override
	public void setUp() {
		// TODO Auto-generated method stub
		bbMisc= new BBMisc(driver);
		bbTutorial=new BBTutorialPage(driver);
	}
 
	@Test
	public void testTutorial() throws InterruptedException{
		
		// check the first page of tutorial
		bbTutorial.checkMainpage();
		bbMisc.swipeToUp(300, 1);
	    bbMisc.tapRecipe(1,300);
		//check the 'tap the bookmark' page
		// check the recipe overview of tutorial
		bbTutorial.checkTapBookMark();
		bbMisc.swipeToUp(300, 3);
		bbTutorial.checkTapTheBtn();
		bbTutorial.checkStepByStep();
		TimeUnit.SECONDS.sleep(2);
		
	}	
}
