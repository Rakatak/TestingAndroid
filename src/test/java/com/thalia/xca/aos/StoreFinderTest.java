package com.thalia.xca.aos;

import static org.junit.Assert.assertTrue;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

import com.thalia.xca.aos.prop.AbstractExcAction;
import com.thalia.xca.aos.prop.AndroidCapabilities;
import com.thalia.xca.aos.prop.AppiumSetup;

public class StoreFinderTest {
	
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
    public void closestStoresTest() throws Exception {
    	
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
				
		    	eName = "eu.thalia.app:id/storelocator_item";
		    	element = wd.findElementById(eName);
		    	element.click();
		    	Thread.sleep(3000);
		    	
		    	eName = "eu.thalia.app:id/nextStores";
		    	element = wd.findElementById(eName);
		    	element.click();
		    	Thread.sleep(10000);
		    	
		    	eName = "eu.thalia.app:id/storeIcon";
		    	List<MobileElement> temp = wd.findElementsById(eName);
		    	
		    	assertTrue("No Stores closest were located", temp.size() > 1 );
			}
    	};
    	action.performAction();
    }
    
    @Test
    public void stateStoresTest() throws Exception {
    	
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
    	    	
		    	eName = "eu.thalia.app:id/storelocator_item";
		    	element = wd.findElementById(eName);
		    	element.click();
		    	Thread.sleep(3000);
		    	
		    	eName = "eu.thalia.app:id/allStores";
		    	element = wd.findElementById(eName);
		    	element.click();
		    	Thread.sleep(3000);
		    	
		    	eName = "Berlin";
		    	element = wd.findElementByName(eName);
		    	element.click();
		    	Thread.sleep(10000);
		    	
		    	eName = "eu.thalia.app:id/storeIcon";
		    	List<MobileElement> temp = wd.findElementsById(eName);
		    	
		    	assertTrue("No Stores with state selection were located", temp.size() > 1 );
			}
    	};
    	action.performAction();
    }
    
    @Test
    public void farStoresTest() throws Exception {
    	
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
    	    	
		    	eName = "eu.thalia.app:id/storelocator_item";
		    	element = wd.findElementById(eName);
		    	element.click();
		    	Thread.sleep(3000);
		    	
		    	eName = "eu.thalia.app:id/nextStores";
		    	element = wd.findElementById(eName);
		    	element.click();
		    	Thread.sleep(5000);
		    	
				wd.swipe(200, (int)(aCap.screenHeight*0.8), 200, (int)(aCap.screenHeight*0.1), 500);
		    	
			    eName = "eu.thalia.app:id/showMoreStoresLabel";
		    	element = wd.findElementById(eName);
		    	element.click();
		    	Thread.sleep(4000);

		    	eName = "eu.thalia.app:id/storeIcon";
		    	List<MobileElement> temp = wd.findElementsById(eName);
		    	
		    	if (aCap.screenHeight == AppiumSetup.galaxyHeight || aCap.screenHeight == AppiumSetup.motoHeight) {
		    		assertTrue("No additional Stores far were displayed", temp.size() > 1 );
				} else {
					assertTrue("No additional Stores far were displayed", temp.size() > 2 );
				}
		    	
			}
    	};
    	action.performAction();
    }
    
    @Test
    public void chooseStoreTest() throws Exception {
    	
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
				
		    	eName = "eu.thalia.app:id/storelocator_item";
		    	element = wd.findElementById(eName);
		    	element.click();
		    	Thread.sleep(3000);
		    	
		    	eName = "eu.thalia.app:id/nextStores";
		    	element = wd.findElementById(eName);
		    	element.click();
		    	Thread.sleep(10000);
		    	
		    	eName = "eu.thalia.app:id/storeIcon";
		    	List<MobileElement> temp = wd.findElementsById(eName);
		    	temp.get(1).click();
		    	Thread.sleep(2000);
		    	
		    	eName = "Als meine Filiale festlegen";
		    	element = wd.findElementByName(eName);
		    	element.click();
		    	Thread.sleep(2000);
		    	
		    	eName = "eu.thalia.app:id/storeTitle";
		    	if (aCap.screenHeight == AppiumSetup.motoHeight || aCap.screenHeight == AppiumSetup.galaxyHeight) {
		    		wd.navigate().back();
			    	temp = wd.findElementsById(eName);
			    	assertTrue("No Stores closest were located", temp.size() > 0 );

		    	} else {
			    	temp = wd.findElementsById(eName);
			    	assertTrue("No Stores closest were located", temp.size() > 2 );
		    	}
			}
    	};
    	action.performAction();
    }
    
    @Test
    public void chooseStoreSortimentTest() throws Exception {
    	
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
				
		    	eName = "eu.thalia.app:id/storelocator_item";
		    	element = wd.findElementById(eName);
		    	element.click();
		    	Thread.sleep(3000);
		    	
		    	eName = "eu.thalia.app:id/nextStores";
		    	element = wd.findElementById(eName);
		    	element.click();
		    	Thread.sleep(10000);
		    	
		    	eName = "eu.thalia.app:id/storeIcon";
		    	List<MobileElement> temp = wd.findElementsById(eName);
		    	temp.get(1).click();
		    	Thread.sleep(2000);
		    	
		    	eName = "Als meine Filiale festlegen";
		    	element = wd.findElementByName(eName);
		    	element.click();
		    	Thread.sleep(2000);
		    	
		    	eName = "android:id/up";
				element = wd.findElementById(eName);
		    	element.click();
		    	Thread.sleep(3000);
		    	
		    	eName = "eu.thalia.app:id/webshop_item";
		    	element = wd.findElementById(eName);
				element.click();
				Thread.sleep(4000);
				
				aCap.scrollDownMenu(wd);
				Thread.sleep(2000);
		
				eName = "Ratgeber";
				element = wd.findElementByName(eName);
		    	element.click();
				Thread.sleep(3000);
		
				eName = "eu.thalia.app:id/priceLabel";
				element = wd.findElementById(eName);
		    	element.click();
		    	Thread.sleep(3000);
		    	
		    	eName = "Berlin Gesundbrunnen-Center";
				element = wd.findElementByName(eName);
		    	Thread.sleep(3000);
		    	
		    	assertTrue("Selected Store wasn't displayed on detail article page", element.isDisplayed() );
			}
    	};
    	action.performAction();
    }
}
