package test1;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;


public class LaunchBrowser {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(
        		new LaunchOptions().setHeadless(false)
        		);
        BrowserContext context = browser.newContext(
        	    new Browser.NewContextOptions().setViewportSize(null)
        	);
        Page page = context.newPage();
       // Page page = browser.newPage();
        page.navigate("https://automationexercise.com/");
        
        
        page.locator("//a[@href='/login'][contains(.,'Signup / Login')]").click();
       
    }
	
	

}
