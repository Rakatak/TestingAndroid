package com.thalia.xca.aos.prop;

import static org.junit.Assert.assertTrue;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

public class AndroidCapabilities {
	
    public String username;
    public String password;	
    public double screenWidth;
    public double screenHeight;
    
    public AndroidCapabilities (){
    }
    
	public AndroidDriver<MobileElement> setCap() throws InterruptedException, IOException{
		
		String computername = InetAddress.getLocalHost().getHostName();
		
		AndroidDriver<MobileElement> wd = null;
        
        DesiredCapabilities capabilities = new DesiredCapabilities();
        
		capabilities.setCapability("deviceName", "whatever");

    	if (computername.equals("Reserve2-iMac-2.local") || computername.equals("Reserve2-iMac.local") || computername.equals("Andreas-MacBook-Pro")){

    		capabilities.setCapability("app",AppiumSetup.appPath);
    		wd = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
            wd.manage().timeouts().implicitlyWait(AppiumSetup.timeOutfirst, TimeUnit.SECONDS);
        	Thread.sleep(5000);
            countrySelection("DE", wd);

            username = "xcabasicde@thqa.de";
    	    password = "hummel123";
            
    	} else {
    		
    		File currentDir = new File(System.getProperty("user.dir"));
    		
    		String mode = System.getProperty("MODE");
            String port = System.getProperty("PORT");
            String integration = System.getProperty("INTEGRATION");
            
    		String jenkinsPath = currentDir + "/xca/thalia/build/outputs/apk/thalia-" + mode + ".apk";

    		capabilities.setCapability("app", jenkinsPath);
            wd = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:" + port + "/wd/hub"), capabilities);
            wd.manage().timeouts().implicitlyWait(AppiumSetup.timeOutfirst, TimeUnit.SECONDS);
        	Thread.sleep(5000);
            countrySelection("DE", wd);
            
            username = "xcabasicde@thqa.de";
    	    password = "hummel123";
            
            if (integration.equals("yes")){
            	
            	username = "xcatestde5@thqa.de";
    	    	password = "hermes";
    	    	
            	Thread.sleep(2000);
            	selectIntegration(wd);
            	Thread.sleep(2000);
            }
    	}
    	
    	String[] dimensions = wd.manage().window().getSize().toString().split("\\D");
		screenWidth = (double) Integer.parseInt(dimensions[1]);
		screenHeight = (double) Integer.parseInt(dimensions[3]);
		wd.getPageSource();
		Thread.sleep(3000);
        return wd;          

	}

	public void selectIntegration(AndroidDriver<MobileElement> wd) {
		try{
			MobileElement element = null;
			
			element = wd.findElementById("eu.thalia.app:id/accountsettings_item");
			element.click();
			Thread.sleep(500);
			
			wd.getPageSource();
			wd.scrollTo("DEBUG:");
			Thread.sleep(1000);
			
			element = wd.findElementById("eu.thalia.app:id/prefs_bootstraploading_label");
			element.click();
			Thread.sleep(3000);
		    
			element = wd.findElementByName("Integration - https://integration.buch.de/api/device/v1/init");
			element.click();
			Thread.sleep(3000);
		    
			element = wd.findElementByXPath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]");
			element.click();
			Thread.sleep(1000);
			
			element = wd.findElementById("android:id/home");
			element.click();
			Thread.sleep(1000);
			
		} catch (Exception ex){
        	wd.quit();	
			assertTrue("selectIntegration() failed, no Internet Connection or REST-Api available", false);
		}
	}
	
	public void selectLive(AndroidDriver<MobileElement> wd) {
		try{
			MobileElement  element = null;
			
			element = wd.findElementById("eu.thalia.app:id/accountsettings_item");
			element.click();
			Thread.sleep(500);
			
			wd.scrollTo("com.thalia.crosschannel:id/prefs_bootstraploading_label");
			element = wd.findElementById("eu.thalia.app:id/prefs_bootstraploading_label");
			element.click();
			Thread.sleep(3000);
		    
			element = wd.findElementByName("Integration - https://integration.buch.de/api/device/v1/init");
			element.click();
			Thread.sleep(3000);
		    
			element = wd.findElementByXPath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]");
			element.click();
			Thread.sleep(1000);
			
			element = wd.findElementById("android:id/home");
			element.click();
			Thread.sleep(1000);
			
			element = wd.findElementById("android:id/up");
	    	element.click();
	    	Thread.sleep(1000);
	    	
		} catch (Exception ex){
        	wd.quit();	
			assertTrue("selectLive() failed, no Internet Connection or REST-Api available", false);
		}
	}

	public void countrySelection(String localeCode, AndroidDriver<MobileElement> wd){    	

    	try {
	    	List<MobileElement> list = wd.findElementsByName("Nochmal versuchen");
	    	if (list.size() > 0){
	    		list.get(0).click();
	        	Thread.sleep(5000);
	        	list = wd.findElementsByName("Nochmal versuchen");
	        	
	    	}
	    	Thread.sleep(1000);
	    	
	        wd.manage().timeouts().implicitlyWait(AppiumSetup.timeOutsecond, TimeUnit.SECONDS);	
	        Thread.sleep(2000);
	        
	    	if ( localeCode.equals("DE") || localeCode.equals("de") ) {
	    		wd.findElementByXPath("//android.widget.ListView[1]/android.widget.LinearLayout[1]").click();
	            
	    	} else if ( localeCode.equals("AT") || localeCode.equals("at") ){
	    		wd.findElementByXPath("//android.widget.ListView[1]/android.widget.LinearLayout[2]").click();
	    		
	    	} else if ( localeCode.equals("CH") || localeCode.equals("ch") ) {
	    		wd.findElementByXPath("//android.widget.ListView[1]/android.widget.LinearLayout[3]").click();
	    	}
	    	Thread.sleep(4000);
    	} catch (Exception ex) {
    		if (wd != null) {
        		wd.quit();	
    		}
    		assertTrue("Countryselection at appstart failed, no Internet Connection or REST-Api available", false);
    	}
    }
	
	public void shortcutHistory(AndroidDriver<MobileElement> wd){
		
		if (screenHeight == AppiumSetup.motoHeight){
			
			wd.tap(1, 322, 205, 500);
//			((JavascriptExecutor)wd).executeScript("mobile: tap", new HashMap<String, Double>() {{ put("tapCount", 1.0); put("touchCount", 1.0); put("duration", 0.5); put("x", 322.0); put("y", 205.8); }});
			
		} else if (screenHeight == AppiumSetup.galaxyHeight){
			
			wd.tap(1, (int)(screenWidth*0.5), (int)(screenHeight*0.187), 500);
//			((JavascriptExecutor)wd).executeScript("mobile: tap", new HashMap<String, Double>() {{ put("tapCount", 1.0); put("touchCount", 1.0); put("duration", 0.5); put("x", screenWidth*0.5); put("y", screenHeight*0.187); }});
			
		} else if (screenHeight == AppiumSetup.nexusHeight){
			
			wd.tap(1, (int)(screenWidth*0.236), (int)(screenHeight*0.1071), 500);
//			((JavascriptExecutor)wd).executeScript("mobile: tap", new HashMap<String, Double>() {{ put("tapCount", 1.0); put("touchCount", 1.0); put("duration", 0.5); put("x", screenWidth*0.236); put("y", screenHeight*0.1071); }});
			
		}
	}
	
	public void hitGoButton(AndroidDriver<MobileElement> wd){
		
		if (screenHeight == AppiumSetup.motoHeight){
			
			wd.tap(1, 705, 1123, 500);
//			((JavascriptExecutor)wd).executeScript("mobile: tap", new HashMap<String, Double>() {{ put("tapCount", 1.0); put("touchCount", 1.0); put("duration", 0.5); put("x", 705.9); put("y", 1123.8); }});
			
		} else if (screenHeight == AppiumSetup.galaxyHeight){
			
			wd.tap(1, (int)(screenWidth*0.9281), (int)(screenHeight*0.9585), 500);
//			((JavascriptExecutor)wd).executeScript("mobile: tap", new HashMap<String, Double>() {{ put("tapCount", 1.0); put("touchCount", 1.0); put("duration", 0.5); put("x", screenWidth*0.9281); put("y", screenHeight*0.9585); }});
			
		} else if (screenHeight == AppiumSetup.nexusHeight){
			
			wd.tap(1, (int)(screenWidth*0.8991), (int)(screenHeight*0.8281), 500);
//			((JavascriptExecutor)wd).executeScript("mobile: tap", new HashMap<String, Double>() {{ put("tapCount", 1.0); put("touchCount", 1.0); put("duration", 0.5); put("x", screenWidth*0.8991); put("y", screenHeight*0.8281); }});
			
		}
	}
	
	public void scrollDownMenu(AndroidDriver<MobileElement> wd) throws InterruptedException{
		
		if (screenHeight == AppiumSetup.motoHeight) {
			wd.swipe((int)(screenWidth*0.7), (int)(screenHeight*0.8), (int)(screenWidth*0.8), (int)(screenHeight*0.15), 500);
//			((JavascriptExecutor)wd).executeScript("mobile: swipe", new HashMap<String, Double>() {{ put("touchCount", 1.0); put("startX", screenWidth*0.7); put("startY", screenHeight*0.8); put("endX", screenWidth*0.8); put("endY", screenHeight*0.15); put("duration", 0.5); }});
			Thread.sleep(3000);
			wd.swipe((int)(screenWidth*0.7), (int)(screenHeight*0.8), (int)(screenWidth*0.8), (int)(screenHeight*0.15), 500);
//			((JavascriptExecutor)wd).executeScript("mobile: swipe", new HashMap<String, Double>() {{ put("touchCount", 1.0); put("startX", screenWidth*0.7); put("startY", screenHeight*0.9); put("endX", screenWidth*0.8); put("endY", screenHeight*0.2); put("duration", 0.5); }});
		} else {
			
			wd.swipe((int)(screenWidth*0.7), (int)(screenHeight*0.8), (int)(screenWidth*0.7), (int)(screenHeight*0.15), 500);
//			((JavascriptExecutor)wd).executeScript("mobile: swipe", new HashMap<String, Double>() {{ put("touchCount", 1.0); put("startX", screenWidth*0.7); put("startY", screenHeight*0.8); put("endX", screenWidth*0.7); put("endY", screenHeight*0.20); put("duration", 0.5); }});
			Thread.sleep(3000);
			wd.swipe((int)(screenWidth*0.7), (int)(screenHeight*0.8), (int)(screenWidth*0.7), (int)(screenHeight*0.15), 500);
//			((JavascriptExecutor)wd).executeScript("mobile: swipe", new HashMap<String, Double>() {{ put("touchCount", 1.0); put("startX", screenWidth*0.7); put("startY", screenHeight*0.9); put("endX", screenWidth*0.8); put("endY", screenHeight*0.2); put("duration", 0.5); }});
		}
	}
	
	public static void checkInet(){
		try {
			URL url = new URL("http://www.google.com");
			URLConnection con = url.openConnection();
			con.connect();
    
		} catch (Exception e) {
			System.out.println("Test was not executed due to failing Internet connectivity \n");

			e.printStackTrace();
		  	System.exit(0);
		} 
	}
}
