package com.thalia.xca.aos;

import static org.junit.Assert.assertTrue;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

import com.thalia.xca.aos.prop.AbstractExcAction;
import com.thalia.xca.aos.prop.AndroidCapabilities;

public class ShoppingCartTest {
	
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
    public void checkIcon() throws Exception {
    	
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {

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
		    	
		    	eName = "eu.thalia.app:id/articleTitle";
				element = wd.findElementById(eName);
		    	Thread.sleep(2000);

		    	wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		    	eName = "eu.thalia.app:id/shoppingCartBtn";
		    	List<MobileElement> temps = wd.findElementsById(eName);
		    	while (temps.size() == 0){
					wd.swipe((int)(aCap.screenWidth*0.8), 400, (int)(aCap.screenWidth*0.12), 400, 500);
			    	Thread.sleep(3000);
		    		temps = wd.findElementsById(eName);
		    		Thread.sleep(3000);
		    	}
		    	temps.get(0).click();
				wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		    	Thread.sleep(3000);
		    	
		    	eName = "android:id/up";
				element = wd.findElementById(eName);
		    	element.click();
		    	Thread.sleep(5000);
		    	
				wd.getPageSource();
				eName = "eu.thalia.app:id/countContainer";
				temps = wd.findElementsById(eName);
				Thread.sleep(1000);
		    		    	
				assertTrue("Article count not shown for article in cart" , temps.size() > 0 );     
			}
    	};
    	action.performAction();
    }
    
    @Test
    public void checkArticleTest() throws Exception {
    	
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {

				String check;

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
		    	
		    	wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		    	eName = "eu.thalia.app:id/shoppingCartBtn";
		    	List<MobileElement> temps = wd.findElementsById(eName);
		    	while (temps.size() == 0){
					wd.swipe((int)(aCap.screenWidth*0.8), 400, (int)(aCap.screenWidth*0.12), 400, 500);
			    	Thread.sleep(3000);
		    		temps = wd.findElementsById(eName);
		    		Thread.sleep(3000);
		    	}
		    	
		    	eName = "eu.thalia.app:id/articleTitle";
				element = wd.findElementById(eName);
				check = element.getAttribute("name");
		    	Thread.sleep(4000);
		    	
		    	temps.get(0).click();
				wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		    	Thread.sleep(3000);
		
		    	eName = "android:id/up";
				element = wd.findElementById(eName);
		    	element.click();
		    	Thread.sleep(3000);
		    	
		    	eName = "eu.thalia.app:id/shoppingcart_item";
				element = wd.findElementById(eName);
		    	element.click();
		    	Thread.sleep(8000);
		    	
				wd.swipe(400, 400, 400, 200, 500);
		    	Thread.sleep(8000);

				wd.getPageSource();
				wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				temps = wd.findElementsByName(check);
		    		    	
				assertTrue("Article in cart (" + check + ") not present" , temps.size() > 0 );     
			}
    	};
    	action.performAction();
    }
    
    @Test 
    public void deleteArticleTest() throws Exception {
    	
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {

				String check;

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
		    	
		    	wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		    	eName = "eu.thalia.app:id/shoppingCartBtn";
		    	List<MobileElement> temps = wd.findElementsById(eName);
		    	while (temps.size() == 0){
					wd.swipe((int)(aCap.screenWidth*0.8), 400, (int)(aCap.screenWidth*0.12), 400, 500);
			    	Thread.sleep(3000);
		    		temps = wd.findElementsById(eName);
		    		Thread.sleep(3000);
		    	}
		    	eName = "eu.thalia.app:id/articleTitle";
				element = wd.findElementById(eName);
				check = element.getAttribute("name");
		    	Thread.sleep(4000);
		    	
		    	temps.get(0).click();
				wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		    	Thread.sleep(3000);
		
		    	eName = "android:id/up";
				element = wd.findElementById(eName);
		    	element.click();
		    	Thread.sleep(3000);
		    	
		    	eName = "eu.thalia.app:id/shoppingcart_item";
				element = wd.findElementById(eName);
		    	element.click();
		    	Thread.sleep(8000);
		    	
				wd.swipe(400, 400, 400, 200, 500);
		    	Thread.sleep(8000);

				wd.getPageSource();
		    	eName = "Entfernen Link";
		    	element = wd.findElementByName(eName);
		    	element.click();
		    	Thread.sleep(20000);
		    	
				wd.getPageSource();
				wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				temps = wd.findElementsByName(check);
		    		    	
				assertTrue("Article (" + check + ") still appears in cart" , temps.size() == 0);     
			}
    	};
    	action.performAction();
    }
    
    @Test
    public void toWishListTest() throws Exception {
    	
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {

				String check;

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
		    	
		    	wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		    	eName = "eu.thalia.app:id/shoppingCartBtn";
		    	List<MobileElement> temps = wd.findElementsById(eName);
		    	while (temps.size() == 0){
					wd.swipe((int)(aCap.screenWidth*0.8), 400, (int)(aCap.screenWidth*0.12), 400, 500);
			    	Thread.sleep(3000);
		    		temps = wd.findElementsById(eName);
		    		Thread.sleep(3000);
		    	}
		    	eName = "eu.thalia.app:id/articleTitle";
				element = wd.findElementById(eName);
				check = element.getAttribute("name");
		    	Thread.sleep(4000);
		    	
		    	temps.get(0).click();
				wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		    	Thread.sleep(3000);
		
		    	eName = "android:id/up";
				element = wd.findElementById(eName);
		    	element.click();
		    	Thread.sleep(3000);
		    	
		    	eName = "eu.thalia.app:id/shoppingcart_item";
				element = wd.findElementById(eName);
		    	element.click();
		    	Thread.sleep(10000);
		    	
				wd.swipe(400, 400, 400, 200, 500);
		    	Thread.sleep(8000);

				wd.getPageSource();
		    	eName = "Zum Merkzettel Link";
		    	element = wd.findElementByName(eName);
		    	element.click();
		    	Thread.sleep(20000);
		    	
				wd.getPageSource();
				wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				temps = wd.findElementsByName(check);
		    		    	
				assertTrue("Article (" + check + ") still appears in cart" , temps.size() == 0);     
			}
	    };
	    action.performAction();
    }
    
    @Test
    public void doubleArticleTest() throws Exception {
    	
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {

				String check;

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
		
				wd.getPageSource();
				eName = "eu.thalia.app:id/priceLabel";
				element = wd.findElementById(eName);
		    	element.click();
		    	Thread.sleep(3000);
		    	
				wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		    	eName = "eu.thalia.app:id/shoppingCartBtn";
		    	List<MobileElement> temps = wd.findElementsById(eName);
		    	while (temps.size() == 0){
					wd.swipe((int)(aCap.screenWidth*0.8), 400, (int)(aCap.screenWidth*0.12), 400, 500);
			    	Thread.sleep(3000);
		    		temps = wd.findElementsById(eName);
		    		Thread.sleep(3000);
		    	}
		    	eName = "eu.thalia.app:id/articleTitle";
				element = wd.findElementById(eName);
				check = element.getAttribute("name");
		    	Thread.sleep(4000);
		    	
		    	temps.get(0).click();
				wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		    	Thread.sleep(3000);
		    	
		    	eName = "eu.thalia.app:id/shoppingCartBtn";
				element = wd.findElementById(eName);
		    	element.click();
		    	Thread.sleep(3000);
		
		    	eName = "android:id/up";
				element = wd.findElementById(eName);
		    	element.click();
		    	Thread.sleep(3000);
		    	
		    	eName = "eu.thalia.app:id/shoppingcart_item";
				element = wd.findElementById(eName);
		    	element.click();
		    	Thread.sleep(8000);
		    	
				wd.swipe(400, 400, 400, 200, 500);
		    	Thread.sleep(8000);

				wd.getPageSource();
				wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				temps = wd.findElementsByName(check);
		    		    	
				assertTrue("Article (" + check + ") still appears in cart" , temps.size() == 0);     
			}
	    };
	    action.performAction();
    }
}
