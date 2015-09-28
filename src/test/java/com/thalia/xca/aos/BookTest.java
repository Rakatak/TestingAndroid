package com.thalia.xca.aos;

import static org.junit.Assert.assertTrue;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

import com.thalia.xca.aos.prop.AbstractExcAction;
import com.thalia.xca.aos.prop.AndroidCapabilities;
import com.thalia.xca.aos.prop.AppiumSetup;
import com.thalia.xca.aos.prop.UIElements;

public class BookTest {
	
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
    public void detailPageTest() throws Exception {

    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
				
		        //Checking detailpage equality with selected product (Name and Price)
		        eName = "eu.thalia.app:id/webshop_item";
		        element = wd.findElementById(eName);
		    	element.click();
		    	Thread.sleep(3000);
		    	
		    	aCap.scrollDownMenu(wd);
				Thread.sleep(3000);
				
				eName = "Kalender";
				element = wd.findElementByName(eName);
		    	element.click();
				Thread.sleep(4000);
		
				aCap.retry(wd);
		        Thread.sleep(2000);
		        
				eName = "eu.thalia.app:id/action_view_toggle_tab";
		    	element = wd.findElementById(eName);
		    	element.click();
		    	Thread.sleep(3000);
		    		
		    	
		    	eName = "eu.thalia.app:id/currentPrice";
				element = wd.findElementsById(eName).get(0);
		    	String checkPrice = element.getAttribute("name");
				Thread.sleep(6000);

		    	eName = "eu.thalia.app:id/articleTitle";
				element = wd.findElementsById(eName).get(0);
		    	String checkName = element.getAttribute("name");
		    	element.click();
				Thread.sleep(3000);
				
				wd.getPageSource();
	        	wd.swipe(10, 20, 10, 20, 100);
		    	eName = "eu.thalia.app:id/currentPrice";
				element = wd.findElementsById(eName).get(0);
				String resultPrice = element.getAttribute("name");
				Thread.sleep(1000);

				eName = "eu.thalia.app:id/articleTitle";
				element = wd.findElementsById(eName).get(0);
		    	String resultName = element.getAttribute("name");
		    	Thread.sleep(500);
		    
		    	assertTrue("The product: (" + checkName + ") wasn't displayed correctly in detail. Result : " + resultName, resultName.equals(checkName) && resultPrice.equals(checkPrice));
			}
    	};
    	action.performAction();
    }
    
    @Test
    public void detailPageComplete() throws Exception {

    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {

		    	int checker = 0;
		    	ArrayList<String> checkList = new ArrayList<String>();
		    	checkList.add("eu.thalia.app:id/articleTitle");
		    	checkList.add("eu.thalia.app:id/articleSubtitle");
		    	checkList.add("eu.thalia.app:id/currentPrice");
		    	checkList.add("eu.thalia.app:id/articleImg");
		    	checkList.add(UIElements.shoppingCartBtn);
		        
		    	Thread.sleep(500);
		               
		    	eName = "eu.thalia.app:id/webshop_item";
		    	element = wd.findElementById(eName);
				element.click();
				Thread.sleep(3000);
						
				aCap.scrollDownMenu(wd);
				Thread.sleep(2000);
		
				eName = "Kalender";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(5000);	
		
				aCap.retry(wd);
		        Thread.sleep(2000);
		        
				eName = "eu.thalia.app:id/articleImg";
				wd.findElementsById(eName).get(0).click();
				Thread.sleep(4000);
				
				wd.swipe(200, (int)(aCap.screenHeight*0.3), 300, (int)(aCap.screenHeight*0.6), 500);
				wd.getPageSource();

				for (int i = 0; i < checkList.size(); i++){
					Thread.sleep(1000);
					eName = checkList.get(i);
					if (wd.findElementById(eName).isDisplayed()){
						checker++;
					}
				}
		    	assertTrue("Detail Page is not complete", checker == checkList.size());
			}
    	};
    	action.performAction();
    }
    
    @Test @Ignore
    public void bookExtractTest() throws Exception {

    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {

		    	//Checking detailpage equality with selected product (Name and Price)		
		    	eName = "eu.thalia.app:id/webshop_item";
		    	element = wd.findElementById(eName);
				element.click();
				Thread.sleep(3000);
				
				aCap.scrollDownMenu(wd);
				Thread.sleep(2000);
		
				eName = "Kalender";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(4000);
		
				aCap.retry(wd);
		        Thread.sleep(2000);
		        
				eName = "eu.thalia.app:id/articleImg";
				wd.findElementsById(eName).get(0).click();
				Thread.sleep(4000);
		
				if (aCap.screenHeight == AppiumSetup.motoHeight) { 
					Thread.sleep(1500);
					wd.swipe(300, (int)(aCap.screenHeight*0.6), 300, (int)(aCap.screenHeight*0.3), 500);
					Thread.sleep(3000);
				}
				
				eName = "Probelesen";
				wd.findElementsByName(eName).get(0).click();
				Thread.sleep(1000);

				eName = UIElements.actionBarTitleClass;
				element = wd.findElementsByClassName(eName).get(0);
		    	String result = element.getAttribute("name");
		    	
				assertTrue("The read example wasn't displayed correctly in detail. Result : " , result.contains("Leseprobe"));
			}
    	};
    	action.performAction();
    }    
    
    @Ignore @Test
    public void availabilityTest() throws Exception {

    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {

		    	//Checking detailpage equality with selected product (Name and Price)		
		    	eName = "eu.thalia.app:id/webshop_item";
		    	element = wd.findElementById(eName);
				element.click();
				Thread.sleep(3000);
				
				aCap.scrollDownMenu(wd);
				Thread.sleep(2000);
		
				eName = "Kalender";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(4000);
		
				aCap.retry(wd);
		        Thread.sleep(2000);
		        
				eName = "eu.thalia.app:id/articleImg";
				wd.findElementsById(eName).get(0).click();
				Thread.sleep(4000);
		
				if (aCap.screenHeight == AppiumSetup.motoHeight) { 
					Thread.sleep(1500);
					wd.swipe(300, (int)(aCap.screenHeight*0.5), 300, (int)(aCap.screenHeight*0.3), 500); 
					Thread.sleep(3000);
				}
				
				wd.getPageSource();
				eName = "eu.thalia.app:id/storeAvailabilityButton";
				wd.findElementsById(eName).get(0).click();
				Thread.sleep(8000);

				eName = "eu.thalia.app:id/storeTitle";
				List<MobileElement> list = new ArrayList<MobileElement>();
		    	list = wd.findElementsById(eName);
		    	String check = list.get(1).getAttribute("name");
		    	list.get(1).click();
		    	Thread.sleep(2000);
		    	list = wd.findElementsByName("Berlin " + check);
		    	
				assertTrue("Checking for availability didn't send a response" , list.size() > 0);
			}
    	};
    	action.performAction();
    }    
}
