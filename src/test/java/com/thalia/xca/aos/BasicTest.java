package com.thalia.xca.aos;

import static org.junit.Assert.assertTrue;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

import com.thalia.xca.aos.prop.AbstractExcAction;
import com.thalia.xca.aos.prop.AndroidCapabilities;

public class BasicTest {
	
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
    public void shoppingCartTest() throws Exception {

    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {		
				    			        
		    	eName = "eu.thalia.app:id/shoppingcart_item";
		    	element = wd.findElementById(eName);
		    	String check = element.getAttribute("name");
				element.click();
				Thread.sleep(2000);

				eName = "android:id/action_bar_title";
				element = wd.findElementById(eName);
				String result = element.getAttribute("name");

				assertTrue("The category: (" + check + ") didnt change the view. Result: " + result, result.equals(check));
			}
    	};
    	action.performAction();

    }
    
    @Test
    public void wishListTest() throws Exception {
    	
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {		    	
		    			        
		    	eName = "eu.thalia.app:id/wishlist_item";
		    	element = wd.findElementById(eName);
		    	String check = element.getAttribute("name");
				element.click();
				Thread.sleep(2000);

				eName = "android:id/action_bar_title";
				element = wd.findElementById(eName);
				String result = element.getAttribute("name");

				assertTrue("The category: (" + check + ") didnt change the view. Result: " + result, result.equals(check));
			}
    	};
    	action.performAction();
    }
    
    
    @Test
    public void sortimentTest() throws Exception {
    	
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
    	
				eName = "eu.thalia.app:id/webshop_item";
		    	element = wd.findElementById(eName);
		    	String check = element.getAttribute("name");
				element.click();
				Thread.sleep(2000);

				eName = "android:id/action_bar_title";
				element = wd.findElementById(eName);
				String result = element.getAttribute("name");

				assertTrue("The category: (" + check + ") didnt change the view. Result: " + result, result.equals(check));
			}
    	};
    	action.performAction();
        
    }
    
    
    
    @Test
    public void storeLocatorTest() throws Exception {
    	
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
    	
				eName = "eu.thalia.app:id/storelocator_item";
		    	element = wd.findElementById(eName);
		    	String check = element.getAttribute("name");
				element.click();
				Thread.sleep(2000);

				eName = "android:id/action_bar_title";
				element = wd.findElementById(eName);
				String result = element.getAttribute("name");

				assertTrue("The category: (" + check + ") didnt change the view. Result: " + result, result.equals(check));
			}
    	};
    	action.performAction();
    }
    
    @Test 
    public void scannerTest() throws Exception {
    	
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
    	
				eName = "eu.thalia.app:id/codescanner_item";
		    	element = wd.findElementById(eName);
		    	String check = element.getAttribute("name");
				element.click();
				Thread.sleep(2000);

				eName = "android:id/action_bar_title";
				element = wd.findElementById(eName);
				String result = element.getAttribute("name");

				assertTrue("The category: (" + check + ") didnt change the view. Result: " + result, result.equals(check));
			}
    	};
    	action.performAction();
    }
    
    @Test
    public void searchTest() throws Exception {
    	
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
    	
		    	eName = "eu.thalia.app:id/action_search";
		    	element = wd.findElementById(eName);
		    	element.click();		    	      
		    	Thread.sleep(1000);
		    	
		    	eName = "android:id/search_src_text";
		    	element = wd.findElementById(eName);
		    	Thread.sleep(1000);
		    	
				assertTrue("The category: (Search) didnt change the view", element.isDisplayed());      
			}
    	};
    	action.performAction();
        
    }
    
    @Test @Ignore
    public void imprintTest() throws Exception {
    	
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
    	
				wd.swipe(100, (int)(aCap.screenHeight*0.8), 100, (int)(aCap.screenHeight*0.15), 500);
				Thread.sleep(3000);
						
				eName = "eu.thalia.app:id/imprint_item";
				element = wd.findElementById(eName);
		    	String check = element.getAttribute("name");
				element.click();
				Thread.sleep(2000);
				
				eName = "android:id/action_bar_title";
				element = wd.findElementById(eName);
				String result = element.getAttribute("name");
				
				assertTrue("The category: (" + check + ") didnt change the view. Result: " + result, result.equals(check));
			}
    	};
    	action.performAction();
    }
    
    @Test @Ignore
    public void helpTest() throws Exception {
    	
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
		        
				wd.swipe(100, (int)(aCap.screenHeight*0.8), 100, (int)(aCap.screenHeight*0.15), 500);
				Thread.sleep(3000);
				
				eName = "eu.thalia.app:id/help_item";
				element = wd.findElementById(eName);
		    	String check = element.getAttribute("name");
				element.click();
				Thread.sleep(2000);
				
				eName = "android:id/action_bar_title";
				element = wd.findElementById(eName);
				String result = element.getAttribute("name");

				assertTrue("The category: (" + check + ") didnt change the view. Result: " + result, result.equals(check));			
			}
    	};
    	action.performAction();
    }
    
    
    
    @Test
    public void conditionsTest() throws Exception {
    	
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
				
    	    	//adapting to screen height if swipe is necessary				
				wd.swipe(100, (int)(aCap.screenHeight*0.8), 100, (int)(aCap.screenHeight*0.15), 500);
				Thread.sleep(3000);

				eName = "eu.thalia.app:id/agb_item";
				element = wd.findElementById(eName);
		    	String check = element.getAttribute("name");
				element.click();
				Thread.sleep(2000);

				eName = "android:id/action_bar_title";
				element = wd.findElementById(eName);
				String result = element.getAttribute("name");

				assertTrue("The category: (" + check + ") didnt change the view. Result: " + result, result.equals(check));
			}
    	};
    	action.performAction();
    }
    
    @Test
    public void accountTest() throws Exception {
    	
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
    	
				wd.swipe(100, (int)(aCap.screenHeight*0.8), 100, (int)(aCap.screenHeight*0.15), 500);
				Thread.sleep(3000);
				
				eName = "eu.thalia.app:id/accountsettings_item";
				element = wd.findElementById(eName);		
		    	String check = element.getAttribute("name");
				element.click();
				Thread.sleep(2000);

				eName = "android:id/action_bar_title";
				element = wd.findElementById(eName);
				String result = element.getAttribute("name");

				assertTrue("The category: (" + check + ") didnt change the view. Result: " + result, result.equals(check));
			}
    	};
    	action.performAction();
    }
    
    @Test
    public void countrySelectionTest() throws Exception {

    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
								    	
		    	eName = "eu.thalia.app:id/accountsettings_item";
				element = wd.findElementById(eName);		
				element.click();
				Thread.sleep(1000);
			
				eName = "eu.thalia.app:id/prefs_mandant_and_username";
				element = wd.findElementById(eName);
		    	Thread.sleep(500);
		    	
		    	assertTrue("User preferences doesn't match the shop selection", element.getAttribute("name").contains("Deutschland"));	
		    }
    	};	
    	action.performAction();
    }
      
}
