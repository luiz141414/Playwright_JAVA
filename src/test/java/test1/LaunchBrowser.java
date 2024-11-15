package test1;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import locators.Locators;
import java.awt.Dimension;
import java.awt.Toolkit;



public class LaunchBrowser {

	public static void main(String[] args) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;
		
		Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(
        		new LaunchOptions().setHeadless(false)
        		);
        BrowserContext context = browser.newContext(
        	    new Browser.NewContextOptions().setViewportSize(width, height)
        	);
      
        Page page = context.newPage();
       
        page.navigate("https://automationexercise.com/");
        
        
        page.locator(Locators.SIGNUP_LOGIN_BUTTON).click();
        page.locator(Locators.FIELD_NOME).fill("luiz fernando");
        page.waitForTimeout(5000);
        
        browser.close();
       // playwright.close();
       
    }
	


}
