package com.thalia.xca.aos;

import static org.junit.Assert.assertTrue;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

import com.thalia.xca.aos.prop.AbstractExcAction;
import com.thalia.xca.aos.prop.AndroidCapabilities;

public class LoginTest {
	
	private AndroidDriver<MobileElement> wd;
	private AndroidCapabilities aCap;

    @Before
    public void setUp() throws Exception {
    	aCap = new AndroidCapabilities();    	
    	if (wd == null){
    		wd = aCap.setCap();
    	}
    }
       
    @Test
    public void loginTest() throws Exception {
     	
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
    	    	
				eName = "eu.thalia.app:id/accountsettings_item";
		    	element = wd.findElementById(eName);
		    	element.click();
		    	Thread.sleep(3000);
		    	
		    	eName = "eu.thalia.app:id/floatingAlertBtn1";
		    	element = wd.findElementById(eName);
		    	element.click();
		    	Thread.sleep(500);
		        
		    	wd.getPageSource();
		    	eName = "eu.thalia.app:id/textEnterOAuthUserName";
		    	element = wd.findElementById(eName);
		    	element.click();
		    	element.sendKeys(aCap.username);
		    	Thread.sleep(500);
		    	
		    	wd.navigate().back();
				Thread.sleep(2000);
				
		    	eName = "eu.thalia.app:id/textEnterOAuthPassword";
		    	element = wd.findElementById(eName);
		    	element.click();
		    	element.sendKeys(aCap.password);
		    	Thread.sleep(1000);
		    	
		    	wd.navigate().back();
				Thread.sleep(2000);
				
		    	eName = "eu.thalia.app:id/buttonEnterOAuthCredentials";
		    	element = wd.findElementById(eName);
		    	element.click();
		    	Thread.sleep(3000);
		    	
		    	eName = "eu.thalia.app:id/prefs_mandant_and_username";
		    	element = wd.findElementById(eName);
		    	
		    	assertTrue("User didn't log in, that result was not expected", element.getAttribute("name").contains(aCap.username));
			}
    	};
    	action.performAction();
    }
    
    @Test
    public void loginLogoutTest() throws Exception {
     	
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
    	    	
				eName = "eu.thalia.app:id/accountsettings_item";
		    	element = wd.findElementById(eName);
		    	element.click();
		    	Thread.sleep(3000);
		    	
		    	eName = "eu.thalia.app:id/floatingAlertBtn1";
		    	element = wd.findElementById(eName);
		    	element.click();
		    	Thread.sleep(500);
		        
		    	eName = "eu.thalia.app:id/textEnterOAuthUserName";
		    	element = wd.findElementById(eName);
		    	element.click();
		    	element.sendKeys(aCap.username);
		    	Thread.sleep(500);
		    	
		    	wd.navigate().back();
				Thread.sleep(2000);
				
		    	eName = "eu.thalia.app:id/textEnterOAuthPassword";
		    	element = wd.findElementById(eName);
		    	element.click();
		    	element.sendKeys(aCap.password);
		    	Thread.sleep(1000);
		    	
		    	wd.navigate().back();
				Thread.sleep(2000);
				
		    	eName = "eu.thalia.app:id/buttonEnterOAuthCredentials";
		    	element = wd.findElementById(eName);
		    	element.click();
		    	Thread.sleep(3000);
		    	
		    	eName = "Abmelden";
		    	element = wd.findElementByName(eName);
		    	element.click();
		    	Thread.sleep(3000);
		    	
		    	eName = "Abmelden";
		    	element = wd.findElementByName(eName);
		    	element.click();
		    	Thread.sleep(3000);
		    	
		    	eName = "Jetzt anmelden";
		    	element = wd.findElementByName(eName);
		    	Thread.sleep(3000);
		    	
		    	assertTrue("User didn't log in, that result was not expected", element.isEnabled());
			}
    	};
    	action.performAction();
    }
    
    @Test
    public void loginFailTest() throws Exception {
    	    	
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
    			    	
		    	eName = "eu.thalia.app:id/accountsettings_item";
		    	element = wd.findElementById(eName);
		    	element.click();
		    	Thread.sleep(3000);
		    	
		    	eName = "eu.thalia.app:id/floatingAlertBtn1";
		    	element = wd.findElementById(eName);
		    	element.click();
		    	Thread.sleep(1000);
		        
		    	eName = "eu.thalia.app:id/textEnterOAuthUserName";
		    	element = wd.findElementById(eName);
		    	element.click();
		    	element.sendKeys("Robin");
		    	Thread.sleep(1000);
		        
		    	wd.navigate().back();
				Thread.sleep(2000);
				
		    	eName = "eu.thalia.app:id/textEnterOAuthPassword";
		    	element = wd.findElementById(eName);
		    	element.click();
		    	element.sendKeys("Textunes");
		    	Thread.sleep(1000);
		    	
		    	wd.navigate().back();
				Thread.sleep(2000);
		    	
		    	eName = "eu.thalia.app:id/buttonEnterOAuthCredentials";
		    	element = wd.findElementById(eName);
		    	element.click();
		    	Thread.sleep(3000);
		    	
		        wd.navigate().back();
		        
		        eName = "eu.thalia.app:id/floatingAlertBtn1";
		        element = wd.findElementById(eName);
		    	String result = element.getAttribute("name");
		        	
		        assertTrue("User has been logged in, that result was not expected", !result.contains("Abmelden"));
			}
    	};
    	action.performAction();
    }
    
    @Test
    public void dashboardLoginTest() throws Exception {
    	        
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
    	
		    	String check = "Buchhändler";
		    	
		    	eName = "eu.thalia.app:id/accountsettings_item";
		    	element = wd.findElementById(eName);
		    	element.click();
		    	Thread.sleep(3000);
		    	
		    	eName = "eu.thalia.app:id/floatingAlertBtn1";
		    	element = wd.findElementById(eName);
		    	element.click();
		    	Thread.sleep(500);
		        
		    	wd.getPageSource();
		    	eName = "eu.thalia.app:id/textEnterOAuthUserName";
		    	element = wd.findElementById(eName);
		    	element.click();
		//    	element.sendKeys("ttqa-staging-de@thqa.de");
		    	element.sendKeys("jens.zech@textunes.de");
		    	Thread.sleep(500);
		    	
		    	wd.navigate().back();
				Thread.sleep(2000);
		        
		    	eName = "eu.thalia.app:id/textEnterOAuthPassword";
		    	element = wd.findElementById(eName);
		    	element.click();
		//    	element.sendKeys("boshqa");
		    	element.sendKeys("textunes");
		    	Thread.sleep(500);
		    	
		    	wd.navigate().back();
				Thread.sleep(2000);
				
		    	eName = "eu.thalia.app:id/buttonEnterOAuthCredentials";
		    	element = wd.findElementById(eName);
		    	element.click();
		    	Thread.sleep(3000);
		    	
		    	eName = "android:id/up";
		    	element = wd.findElementById(eName);  //open menu
		    	element.click();
		    	Thread.sleep(3000);
		    	
				wd.swipe(100, (int)(aCap.screenHeight*0.8), 100, (int)(aCap.screenHeight*0.15), 500);
		    	Thread.sleep(3000);
		    	
		    	eName = "eu.thalia.app:id/bhdashboard_item";
		        element = wd.findElementById(eName);
				element.click();
				Thread.sleep(1000);
				
				eName = "OK";
				List<MobileElement> list = wd.findElementsByName(eName);
				if (list.size() > 0) {
					wd.findElementByName(eName).click();
					Thread.sleep(1000);
				}	
				
				eName = "android:id/action_bar_title";
				element = wd.findElementById(eName);
				String result = element.getAttribute("name");
				
				assertTrue("The category: (" + check + ") didnt change the view", result.contains(check));
			}
    	};
    	action.performAction();
    }
    
    @Test
    public void dashboardTestNoLogin() throws Exception {
        wd.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
    	
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
    	    	
		    	List <MobileElement> elements = new ArrayList<MobileElement>();
		    	Thread.sleep(500);
		    	eName = "eu.thalia.app:id/bhdashboard_item";
		    	
		    	if (aCap.screenHeight <= 900) {
					wd.swipe(100, (int)(aCap.screenHeight*0.8), 100, (int)(aCap.screenHeight*0.15), 500);
		    		Thread.sleep(3000);
		        	elements = wd.findElementsById(eName);
		            
		    	} else if (aCap.screenHeight >= 901) {
		        	elements = wd.findElementsById(eName);
		    	}
		        
				assertTrue("Dashboard is enabled, even though it shoudln't be", elements.size() == 0);
			}
    	};
    	action.performAction();
	}
    
}
