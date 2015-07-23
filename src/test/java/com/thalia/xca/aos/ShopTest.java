package com.thalia.xca.aos;

import static org.junit.Assert.assertTrue;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

import com.thalia.xca.aos.prop.AbstractExcAction;
import com.thalia.xca.aos.prop.AndroidCapabilities;

public class ShopTest {
	
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
    public void shopCategoryTest() throws Exception {
    	
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
				    	
		    	//Checking Webshop item for section "" is displayed if selected    
		    	eName = "eu.thalia.app:id/webshop_item";
		    	element = wd.findElementById(eName);
				element.click();
				Thread.sleep(3000);
				
				aCap.scrollDownMenu(wd);
				Thread.sleep(2000);
		
				eName = "Kalender";
				element = wd.findElementByName(eName);
				String check = element.getAttribute("name");
				element.click();
				
				eName = "android:id/action_bar_title";
				String result = wd.findElementById(eName).getAttribute("name");
		        
				assertTrue("The category: (" + check + ") didn't change the view. Result : " + result, result.equals(check));
			}
    	};
    	action.performAction();
    }
    
    @Test
    public void checkShopOptions() throws Exception {
    	
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
			
		    	int checker = 0;
		    	ArrayList<String> checkList = new ArrayList<String>();
		        checkList.add("Beste Treffer");
		        checkList.add("Verkaufsrang");
		        checkList.add("zuletzt erschienen");
		        checkList.add("Erscheinungsjahr");
		        checkList.add("Preis: aufsteigend");
		        checkList.add("Preis: absteigend");
		        checkList.add("Titel: A-Z");
		        checkList.add("Titel: Z-A");	
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
		        Thread.sleep(4000);
		        
		        eName = "Verfeinern";
				element = wd.findElementByName(eName);
				element.click();
		        Thread.sleep(4000);
				
				eName = "Sortierung:";
				element = wd.findElementByName(eName);
				Thread.sleep(1000);
				element.click();
		        
				for (int i = 0; i < checkList.size(); i++){
					Thread.sleep(1000);
					eName = checkList.get(i);
					if (wd.findElementByName(eName).isDisplayed()){
	                    checker++;
	                    Thread.sleep(1000);
					}
				}
				assertTrue("The search options are incomplete: " + checker + " of " + checkList.size(), checker==checkList.size() );
			}
    	};
    	action.performAction();
	}
   
    @Test
    public void verfeinernTest() throws Exception {
    	
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
				
		    	//Checking Webshop item for section "Ratgeber" is displayed if selected		        
		    	eName = "eu.thalia.app:id/webshop_item";
		    	element = wd.findElementById(eName);
				element.click();
				Thread.sleep(3000);
				
				aCap.scrollDownMenu(wd);
				Thread.sleep(3000);
		
				eName = "Kalender";
				element = wd.findElementByName(eName);
				element.click();
		    	Thread.sleep(3000);
				
				eName = "Verfeinern";
				element = wd.findElementByName(eName);
				element.click();
		        Thread.sleep(4000);
		        
				eName = "eu.thalia.app:id/explistview";
				
				assertTrue("The Verfeinern-List was not displayed when selected Verfeinern category", wd.findElementById(eName).isDisplayed());
			}
    	};
    	action.performAction();
    }   
    
    @Test
    public void prizeFilterTest() throws Exception {
    	
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
				
				int checker = 0;
				
		    	//Checking Webshop item for section "Ratgeber" is displayed if selected		        
		    	eName = "eu.thalia.app:id/webshop_item";
		    	element = wd.findElementById(eName);
				element.click();
				Thread.sleep(3000);
				
				aCap.scrollDownMenu(wd);
				Thread.sleep(2000);
		
				eName = "Kalender";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(3000);
				
				eName = "Verfeinern";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(3000);
				
				eName = "FILTER";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(3000);
				
				eName = "Preis:";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(3000);
				
				eName = "Prize < ";
				element = wd.findElementByXPath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.ListView[1]/android.widget.CheckedTextView[2]");
				String temp = element.getAttribute("name");
				Pattern p = Pattern.compile("\\d*\\.\\d+");
			    Matcher m = p.matcher(temp);
				m.find();
				Double filter = Double.parseDouble(m.group());
				System.out.println(filter);
				element.click();
				Thread.sleep(6000);
				
				List<MobileElement> list = new ArrayList<MobileElement>();
				
				eName = "All Prizes";
				list = wd.findElementsById("eu.thalia.app:id/priceLabel");
				
				for (int i = 0; i < list.size(); i++){
					eName = "Prize Element Nr." + i;
					element =  list.get(i);
					int check = Integer.parseInt(element.getAttribute("name").substring(0, 1));
					if (check < filter){
						checker++;

					}
				}
				
				assertTrue("Articles with higher prize than " + filter + " were displayed which is not allowed", checker == list.size());  
			}
    	};
    	action.performAction();
    }   
    
    @Test @Ignore
    public void prizeSortTest() throws Exception {
    	
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
				
				int checker = 0;
				
		    	//Checking Webshop item for section "Ratgeber" is displayed if selected		        
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
				
				eName = "Verfeinern";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(2500);
				
				eName = "Sortierung:";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(1000);
			
				eName = "Preis: Absteigend";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(2500);
				
				eName = "Preis: Absteigend";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(2500);
				
				List<MobileElement> list = new ArrayList<MobileElement>();
				
				eName = "All Prizes";
				list = wd.findElementsById("eu.thalia.app:id/priceLabel");
				
				for (int i = 0; i < list.size()-1; i++){
					eName = "Prize Element Nr." + i;
					element =  list.get(i);
					MobileElement element2 = list.get(i);
					int check = Integer.parseInt(element.getAttribute("name").substring(0, 3));
					int check2 = Integer.parseInt(element2.getAttribute("name").substring(0, 3));
					if (check >= check2){
						checker++;

					}
				}
				
				assertTrue("Articles were not sorted starting from highest", checker == list.size() - 1);  
			}
    	};
    	action.performAction();
    }   
}
