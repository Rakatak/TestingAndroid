package com.thalia.xca.aos;

import static org.junit.Assert.assertTrue;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

import com.thalia.xca.aos.prop.AbstractExcAction;
import com.thalia.xca.aos.prop.AndroidCapabilities;
import com.thalia.xca.aos.prop.AppiumSetup;

public class WishListTest {
	
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

		    	eName = "eu.thalia.app:id/func_btn_wishlist";
				element = wd.findElementById(eName);
		    	element.click();
		    	Thread.sleep(3000);
		
		    	eName = "android:id/up";
				element = wd.findElementById(eName);
		    	element.click();
		    	Thread.sleep(5000);

		    	wd.getPageSource();
		    	eName = "eu.thalia.app:id/countContainer";
				List<MobileElement> temps = wd.findElementsById(eName);
		    		    	
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
				String result;
		    	
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
				check = element.getAttribute("name");
		    	Thread.sleep(4000);

		    	eName = "eu.thalia.app:id/func_btn_wishlist";
				element = wd.findElementById(eName);
		    	element.click();
		    	Thread.sleep(3000);
		
		    	eName = "android:id/up";
				element = wd.findElementById(eName);
		    	element.click();
		    	Thread.sleep(3000);
		    	
		    	eName = "eu.thalia.app:id/wishlist_item";
				element = wd.findElementById(eName);
		    	element.click();
		    	Thread.sleep(3000);
		    	
		    	eName = "eu.thalia.app:id/articleTitle";
				element = wd.findElementById(eName);
				result = element.getAttribute("name");
		    	Thread.sleep(3000);
		    		    	
				assertTrue("Article on Wishlist (" + result + ") doesn't match article selected (" + check +")" , result.equals(check));     
			}
    	};
    	action.performAction();
    }
    
    @Test
    public void deleteArticleTest() throws Exception {
    	
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {

				List<MobileElement> list = new ArrayList<MobileElement>();

				eName = "eu.thalia.app:id/webshop_item";
		    	element = wd.findElementById(eName);
				element.click();
				Thread.sleep(3000);
				
				aCap.scrollDownMenu(wd);
				Thread.sleep(2000);
		
				eName = "Ratgeber";
				element = wd.findElementByName(eName);
		    	element.click();
				Thread.sleep(3000);
		
				eName = "eu.thalia.app:id/priceLabel";
				element = wd.findElementById(eName);
		    	element.click();
		    	Thread.sleep(4000);
		    	
		    	eName = "eu.thalia.app:id/func_btn_wishlist";
				element = wd.findElementById(eName);
		    	element.click();
		    	Thread.sleep(3000);
		
		    	eName = "android:id/up";
				element = wd.findElementById(eName);
		    	element.click();
		    	Thread.sleep(3000);
		    	
		    	eName = "eu.thalia.app:id/wishlist_item";
				element = wd.findElementById(eName);
		    	element.click();
		    	Thread.sleep(3000);
		    	
		    	eName = "eu.thalia.app:id/overflowBtn";
				element = wd.findElementById(eName);
		    	element.click();
		    	Thread.sleep(3000);
		    	
		    	eName = "Entfernen";
				element = wd.findElementByName(eName);
		    	element.click();
		    	Thread.sleep(3000);
		    	
		        wd.manage().timeouts().implicitlyWait(AppiumSetup.timeOutfirst, TimeUnit.SECONDS);	

		    	eName = "eu.thalia.app:id/articleTitle";  	
				list = wd.findElementsById(eName);

				assertTrue("Article still appears on whishlist after deletion", list.size() == 0);     
			}
    	};
    	action.performAction();
    }
    
    @Test
    public void toShoppingCartTest() throws Exception {
    	
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {

				List<MobileElement> list = new ArrayList<MobileElement>();

				eName = "eu.thalia.app:id/webshop_item";
		    	element = wd.findElementById(eName);
				element.click();
				Thread.sleep(3000);
				
				aCap.scrollDownMenu(wd);
				Thread.sleep(2000);
		
				eName = "Ratgeber";
				element = wd.findElementByName(eName);
		    	element.click();
				Thread.sleep(3000);
		
				eName = "eu.thalia.app:id/priceLabel";
				element = wd.findElementById(eName);
		    	element.click();
		    	Thread.sleep(4000);
		    	
		    	eName = "eu.thalia.app:id/func_btn_wishlist";
				element = wd.findElementById(eName);
		    	element.click();
		    	Thread.sleep(3000);
		
		    	eName = "android:id/up";
				element = wd.findElementById(eName);
		    	element.click();
		    	Thread.sleep(3000);
		    	
		    	eName = "eu.thalia.app:id/wishlist_item";
				element = wd.findElementById(eName);
		    	element.click();
		    	Thread.sleep(3000);
		    	
		    	eName = "eu.thalia.app:id/shoppingCartBtn";
				element = wd.findElementById(eName);
		    	element.click();
		    	Thread.sleep(3000);
		    	
		        wd.manage().timeouts().implicitlyWait(AppiumSetup.timeOutfirst, TimeUnit.SECONDS);	
		    	
		    	eName = "eu.thalia.app:id/articleTitle";  	
				list = wd.findElementsById(eName);

				assertTrue("Article still appears on whishlist after added to shoppingcart", list.size() == 0);     
			}
		};
    	action.performAction();
    }
    
    @Test @Ignore
    public void doubleArticleTest() throws Exception {
    	
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {

				List<MobileElement> list = new ArrayList<MobileElement>();
				
				System.out.println(aCap.screenHeight);
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
		
				eName = "eu.thalia.app:id/priceLabel";
				element = wd.findElementById(eName);
		    	element.click();
		    	Thread.sleep(4000);
		    	
		    	eName = "eu.thalia.app:id/func_btn_wishlist";
				element = wd.findElementById(eName);
		    	element.click();
		    	Thread.sleep(3000);
		    	element.click();
		
		    	eName = "android:id/up";
				element = wd.findElementById(eName);
		    	element.click();
		    	Thread.sleep(3000);

		    	eName = "eu.thalia.app:id/wishlist_item";
				element = wd.findElementById(eName);
		    	element.click();
		    	Thread.sleep(3000);
		    	
		        wd.manage().timeouts().implicitlyWait(AppiumSetup.timeOutfirst, TimeUnit.SECONDS);	
		    	
		    	eName = "eu.thalia.app:id/articleTitle";  	
				list = wd.findElementsById(eName);

				assertTrue("Article still appears on whishlist after deletion", list.size() == 0);     
			}
    	};
    	action.performAction();
    }
}
