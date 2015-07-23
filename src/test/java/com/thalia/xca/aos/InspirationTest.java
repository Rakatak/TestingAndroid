package com.thalia.xca.aos;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import com.thalia.xca.aos.prop.AbstractExcAction;
import com.thalia.xca.aos.prop.AndroidCapabilities;

public class InspirationTest {
	
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
    public void bookWheelTest() throws Exception {

    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {		
				    			        
				wd.getPageSource();
				eName = "eu.thalia.app:id/inspiration_item";
		    	element = wd.findElementById(eName);
				element.click();
				Thread.sleep(1000);
				
				eName = "eu.thalia.app:id/articleImg";
		    	element = wd.findElementById(eName);
				element.click();
				Thread.sleep(1000);
				
				wd.getPageSource();
				eName = "eu.thalia.app:id/articleTitle";
		    	element = wd.findElementById(eName);
				
				assertTrue("Book Wheel didn't result in detail page view", element.isDisplayed());
			}
    	};
    	action.performAction();

    }
    
    @Test
    public void bestsellerSpiegelTest() throws Exception {
    	
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {		    	
		    			        
		    	eName = "eu.thalia.app:id/inspiration_item";
		    	element = wd.findElementById(eName);
				element.click();
				Thread.sleep(1000);
				
				eName = "SPIEGEL Bestseller Belletristik";
		    	element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(1000);
				
				eName = "SPIEGEL Bestseller Belletristik";
				element = wd.findElementByName(eName);
				Thread.sleep(1000);
				
				eName = "eu.thalia.app:id/articleImg";
		    	element = wd.findElementById(eName);
				element.click();
				Thread.sleep(1000);
				
				wd.getPageSource();
				eName = "eu.thalia.app:id/articleTitle";
		    	element = wd.findElementById(eName);
		    	
				assertTrue("Book Wheel didn't result in detail page view", element.isDisplayed());

			}
    	};
    	action.performAction();
    }
    
    
    @Test
    public void bestsellerThaliaTest() throws Exception {
    	
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
    	
				eName = "eu.thalia.app:id/inspiration_item";
		    	element = wd.findElementById(eName);
				element.click();
				Thread.sleep(1000);
				
				eName = "Thalia Bestseller Belletristik";
		    	element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(1000);
				
				eName = "Thalia Bestseller Belletristik";
//				element = wd.findElementByName(eName);
				Thread.sleep(1000);
				
				eName = "eu.thalia.app:id/articleImg";
		    	element = wd.findElementById(eName);
				element.click();
				Thread.sleep(1000);
				
				wd.getPageSource();
				eName = "eu.thalia.app:id/articleTitle";
		    	element = wd.findElementById(eName);
		    	
				assertTrue("Book Wheel didn't result in detail page view", element.isDisplayed());
			}
    	};
    	action.performAction();
        
    }
    
    
    @Test
    public void newBooksTest() throws Exception {
    	
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
    	
				eName = "eu.thalia.app:id/inspiration_item";
		    	element = wd.findElementById(eName);
				element.click();
				Thread.sleep(1000);
				
				eName = "eu.thalia.app:id/moreBtn";
		    	element = wd.findElementById(eName);
				element.click();
				Thread.sleep(1000);
				
				eName = "Neuheiten";
				element = wd.findElementByName(eName);
				Thread.sleep(1000);
				
				wd.getPageSource();
				eName = "eu.thalia.app:id/articleImg";
		    	element = wd.findElementById(eName);
				element.click();
				Thread.sleep(1000);
				
				wd.getPageSource();
				eName = "eu.thalia.app:id/articleTitle";
		    	element = wd.findElementById(eName);
		    	
				assertTrue("Book Wheel didn't result in detail page view", element.isDisplayed());
			}
    	};
    	action.performAction();
    }
    
    @Test
    public void favoriteCategoryTest() throws Exception {
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
				
				eName = "eu.thalia.app:id/webshop_item";
		    	element = wd.findElementById(eName);
				element.click();
				Thread.sleep(3000);
				
				eName = "Kalender";
				wd.scrollTo(eName);
				element = wd.findElementByName(eName);
				element.click();	
				Thread.sleep(2000);
				
				eName = "eu.thalia.app:id/action_favorite";
		    	element = wd.findElementById(eName);
				element.click();	
				Thread.sleep(2000);
				
				eName = "android:id/up";
				element = wd.findElementById(eName);
		    	element.click();
		    	Thread.sleep(3000);
		    	
		    	eName = "eu.thalia.app:id/inspiration_item";
		    	element = wd.findElementById(eName);
				element.click();
				Thread.sleep(5000);
				
//				wd.swipe((int)(aCap.screenWidth*0.7), (int)(aCap.screenHeight*0.8), (int)(aCap.screenWidth*0.8), (int)(aCap.screenHeight*0.36), 500);
				wd.getPageSource();
				wd.scrollTo("Kalender");
				eName = "Kalender";
				element = wd.findElementByName(eName);
				Thread.sleep(2000);

				assertTrue("Favorite Category didn't appear on Inspiration Site", element.isEnabled());
			}
    	};
    	action.performAction();
    }
    
    @Test
    public void deleteFavoriteCategoryTest() throws Exception {
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
				
				
				eName = "eu.thalia.app:id/webshop_item";
		    	element = wd.findElementById(eName);
				element.click();
				Thread.sleep(3000);
				
				eName = "Krimis & Thriller";
				wd.scrollTo(eName);
				element = wd.findElementByName(eName);
				element.click();	
				Thread.sleep(2000);
				
				eName = "eu.thalia.app:id/action_favorite";
		    	element = wd.findElementById(eName);
				element.click();	
				Thread.sleep(2000);
				
				eName = "Favorit entfernen";
				wd.scrollTo(eName);
				element = wd.findElementByName(eName);
				element.click();	
				Thread.sleep(2000);
				
				eName = "android:id/up";
				element = wd.findElementById(eName);
		    	element.click();
		    	Thread.sleep(3000);
		    	
		    	eName = "eu.thalia.app:id/inspiration_item";
		    	element = wd.findElementById(eName);
				element.click();
				Thread.sleep(5000);
				
				wd.swipe((int)(aCap.screenWidth*0.7), (int)(aCap.screenHeight*0.8), (int)(aCap.screenWidth*0.8), (int)(aCap.screenHeight*0.16), 500);
				wd.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
				
				wd.getPageSource();
				eName = "Krimis & Thriller";
				List<MobileElement> list = wd.findElementsByName(eName);
				Thread.sleep(2000);

				assertTrue("Favorite Category still appears on Inspiration Site", list.size() == 0);
			}
    	};
    	action.performAction();
    }
}
