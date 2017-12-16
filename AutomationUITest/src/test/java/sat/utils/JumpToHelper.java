package sat.utils;

import org.junit.Assert;

import sat.sidechef.pages.SCProfilePage;
import sat.sidechef.pages.SCProfilePreviewPage;
import sat.sidechef.pages.SCRecipeCoverPage;
import sat.sidechef.pages.SCWikiCoverPage;
import sat.sidechef.pages.SCWikiPage;
import sat.testbases.Page;

public class JumpToHelper {
	
	
	/*
	 * This function test that we jump to the right page of user when clicking a user image.
	 * 
	 * for now, it only apply for SC, we don't follow others in BB
	 * 
	 * we could jump to a user profile page from two pages:
	 * - recipe cover in homescroll
	 * - profilepreview page(followers, following, search page(under user subpage))
	 */
	public void testUserJumpTo(Page objBefore, SCProfilePage objProfile){
		String userName = "";
		if(objBefore.getClass() == SCProfilePreviewPage.class){
			userName = SCProfilePreviewPage.class.cast(objBefore).jumpToUser();
		}else if(objBefore.getClass() == SCRecipeCoverPage.class){
			userName = SCRecipeCoverPage.class.cast(objBefore).jumpToUser();
		}else{
			System.out.println("testUserJump to should only be called in ProfilePreviewPage "
					+ "or SCRecipeCoverPage");
			System.exit(-1);
		}
		
		Assert.assertEquals(userName, objProfile.getRealName());
		objProfile.checkPage();
		
		objProfile.getBackBtn().click();
		
	}
	
	public void testRecipeJumpTo(){
		
	}
	
	public void testWikiJumpTo(Page objBefore, SCWikiPage objWiki){
		String wikiName = SCWikiCoverPage.class.cast(objBefore).jumpToWiki();
		// change this
		// Assert.assertEquals(userName, objProfile.getRealName());
		objWiki.checkPage();
		
		
	}
	

}
