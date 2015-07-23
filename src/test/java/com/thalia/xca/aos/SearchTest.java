package com.thalia.xca.aos;

import static org.junit.Assert.assertTrue;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

import com.thalia.xca.aos.prop.AbstractExcAction;
import com.thalia.xca.aos.prop.AndroidCapabilities;
import com.thalia.xca.aos.prop.AppiumSetup;

public class SearchTest {
	
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
    public void searchHistoryTest() throws Exception {
    	
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
		    	
		    	//the input for search
		    	String searchInput = "Rakatak";
		    	
		    	//open search
		    	eName = "eu.thalia.app:id/action_search";
		    	element = wd.findElementById(eName);
				element.click();
				Thread.sleep(2000);
				
				//enter characters into SearchBar
				eName = "android:id/search_plate";
				element = wd.findElementById(eName);
				Thread.sleep(2000);
				element.click();
				element.sendKeys(searchInput);
				Thread.sleep(1000);
				element.click();
				Thread.sleep(1000);
		        
				//hit "go" button on keyboard
				aCap.hitGoButton(wd);
				Thread.sleep(3000);
		   		
				//Check the SearchHistory, re-enter the searchInput via Dropdown menu and checking textvalue
				element.click();
				
				eName = "android:id/search_close_btn";
				element = wd.findElementById(eName);
				element.click();
				Thread.sleep(4000);
				
				//adaptive to screen resolution, shortcut history
				aCap.shortcutHistory(wd);
				Thread.sleep(5000);
				
				eName = "android:id/search_src_text";
				String result = wd.findElementById(eName).getAttribute("text");
				
				assertTrue("The input: (" + searchInput + ") wasn't displayed correctly in the history. Result: " + result, result.contains(searchInput));
			}
    	};
    	action.performAction();
    }
    
    @Test
    public void searchResultTest() throws Exception {
    	
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
    	
		    	//the input for search
		    	String searchInput = "Hund";
		    	List<MobileElement> resultList;
		    	int checker = 0;
		    	Thread.sleep(500);
		    	
		    	//open search
		    	eName = "eu.thalia.app:id/action_search";
		    	element = wd.findElementById(eName);
				element.click();
				Thread.sleep(2000);
				
				//enter characters into SearchBar
				eName = "android:id/search_plate";
				element = wd.findElementById(eName);
				element.click();
				Thread.sleep(2000);
				element.sendKeys(searchInput);
				Thread.sleep(2000);

				eName = "eu.thalia.app:id/action_view_toggle_tab";
				element = wd.findElementById(eName);
				element.click();
				Thread.sleep(10000);

				wd.getPageSource();
		   		eName = "eu.thalia.app:id/articleTitle";
		   		resultList = wd.findElementsById(eName);
		   		
		        //look if searchresults contain searchinput
		   		for (int i = 0; i < resultList.size(); i++){
		   			if (resultList.get(i).getAttribute("name").contains(searchInput)){
		   				checker++;
		   			}
		   		}
		        
		   		assertTrue("The input: (" + searchInput + ") wasn't displayed correctly in the results or doesn't have any result", checker > 0);
			}
    	};
    	action.performAction(); 
    }
    
    
    @Test
    public void searchCategoryTest() throws Exception {
    	
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {

		    	//open search
				eName = "eu.thalia.app:id/action_search";
		    	element = wd.findElementById(eName);
		    	element.click();
				Thread.sleep(3000);
				
				eName = "Verfeinern";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(500);
				
				//switch searchCategories
				eName = "Durchsuchen:";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(500);
				
				eName = "eBooks";
				element = wd.findElementByName(eName);
				String check = element.getAttribute("name");
				element.click();
				Thread.sleep(2000);
				
				eName = "Verfeinern";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(2000);
				
		   		eName = "eu.thalia.app:id/filter_option_label";
				element = wd.findElementsById(eName).get(1);
				String result = element.getAttribute("name");
				Thread.sleep(3000);
				
				assertTrue("The search category: (eBooks) wasn't displayed/selected correctly ", result.contains(check));
			}
    	};
    	action.performAction();    
    }
    
    @Test
    public void searchCategoryResultTest() throws Exception {
    	
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
    	
				//the input for search
		    	String searchInput = "Katze";
		    	List<MobileElement> resultList;
		    	int checker = 0;
		    	Thread.sleep(500);
		    	
		    	//open search
		    	eName = "eu.thalia.app:id/action_search";
		    	element = wd.findElementById(eName);
				element.click();
				Thread.sleep(2000);
				
				//enter characters into SearchBar
				eName = "android:id/search_plate";
				element = wd.findElementById(eName);
				element.click();
				Thread.sleep(2000);
				element.sendKeys(searchInput);
				Thread.sleep(5000);
				
				eName = "Verfeinern";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(2000);
				
				eName = "Durchsuchen:";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(500);
				
				eName = "eBooks";
				element = wd.findElementByXPath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.ListView[1]/android.widget.CheckedTextView[3]");
				String check = element.getAttribute("name").substring(1, 6);
				Thread.sleep(2000);
				element.click();
				Thread.sleep(7000);
				
				eName = "eu.thalia.app:id/action_view_toggle_tab";
				element = wd.findElementById(eName);
				element.click();
				Thread.sleep(6000);

		   		eName = "eu.thalia.app:id/articleTitle";
		   		resultList = wd.findElementsById(eName);
		   		
		        //look if searchresults contain searchinput
		   		for (int i = 0; i < resultList.size(); i++){
		   			if (resultList.get(i).getAttribute("name").contains(searchInput)){
		   				checker++;
		   			}
		   		}
		   		Thread.sleep(2000);

		   		assertTrue("The input: (" + searchInput + ") wasn't displayed correctly in the results or doesn't have any result", checker > 0);
		   		Thread.sleep(2000);
		   		
		   		eName = "Verfeinern";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(2000);
				
		   		eName = "eu.thalia.app:id/filter_option_label";
				element = wd.findElementsById(eName).get(1);
				String result = element.getAttribute("name");
				Thread.sleep(3000);
		   		
				assertTrue("The search category: (" + check + ") wasn't displayed/selected correctly : " + result, result.contains(check));
		    }
		};
		action.performAction();
        
    }
    
    @Test
    public void searchOptionsTest() throws Exception {
    	
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
    	
		    	//open search
				eName = "eu.thalia.app:id/action_search";
		    	element = wd.findElementById(eName);
				element.click();
				Thread.sleep(2000);

				eName = "Verfeinern";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(2000);
				
				eName = "Sortierung:";
				element = wd.findElementByName(eName);
				Thread.sleep(500);
				element.click();
		        
				eName = "zuletzt erschienen";
				element = wd.findElementByName(eName);
				String check = element.getAttribute("name");
				element.click();
				Thread.sleep(1000);
				
		    	List<MobileElement> list = wd.findElementsById("eu.thalia.app:id/filter_option_label");
		    	int checker = 0;
		    	
		    	for (MobileElement element : list) {
		    		if (element.getAttribute("name").contains("zuletzt erschienen")){
		    			checker++;
		    			break;
		    		}
		    	}

				
				
				//Check the category field
				assertTrue("The search option: (" + check + ") wasn't displayed/selected correctly ", checker > 0 );
		    }
		};
		action.performAction();
        
    }
    
    @Test
    public void searchOptionsResultTest() throws Exception {
    	
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
    	
				//the input for search
		    	String searchInput = "Katze";
		    	List<MobileElement> resultList;
		    	int checker = 0;
		    	Thread.sleep(500);
		    	
		    	//open search
		    	eName = "eu.thalia.app:id/action_search";
		    	element = wd.findElementById(eName);
				element.click();
				Thread.sleep(2000);
				
				//enter characters into SearchBar
				eName = "android:id/search_plate";
				element = wd.findElementById(eName);
				element.click();
				Thread.sleep(2000);
				element.sendKeys(searchInput);
				Thread.sleep(2000);
				
				eName = "Verfeinern";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(2000);
				
				//switch searchOptions
				eName = "Sortierung:";
				element = wd.findElementByName(eName);
				element.click();				
				Thread.sleep(4000);
		        
				eName = "zuletzt erschienen";
				element = wd.findElementByName(eName);
				String check = element.getAttribute("name");
				element.click();
				Thread.sleep(4000);
				
				eName = "eu.thalia.app:id/action_view_toggle_tab";
				element = wd.findElementById(eName);
				element.click();
				Thread.sleep(3000);

		   		eName = "eu.thalia.app:id/articleTitle";
		   		resultList = wd.findElementsById(eName);
		   		
		        //look if searchresults contain searchinput
		   		for (int i = 0; i < resultList.size(); i++){
		   			if (resultList.get(i).getAttribute("name").contains(searchInput)){
		   				checker++;
		   			}
		   		}
		   		Thread.sleep(6000);
		   		
		   		eName = "Verfeinern";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(3000);
				
		   		List<MobileElement> list = wd.findElementsById("eu.thalia.app:id/filter_option_label");
		    	int checker2 = 0;
		    	
		    	for (MobileElement element : list) {
		    		if (element.getAttribute("name").contains("zuletzt erschienen")){
		    			checker2++;
		    			break;
		    		}
		    	}
		   		
		   		assertTrue("The input: (" + searchInput + ") wasn't displayed correctly in the results or doesn't have any result", checker > 0);
				assertTrue("The search option: (" + check + ") wasn't displayed/selected correctly ", checker2 > 0);
		    }
		};
		action.performAction();
        
    }
    
    @Test
    public void checkSearchCategories() throws Exception {
    	
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
    	
				//option arrayList to check the content of search categories
		    	int checker = 0;
		    	ArrayList<String> checkList = new ArrayList<String>();
		        checkList.add("Alle Kategorien");
		        checkList.add("Bücher");
		        checkList.add("eBooks");
		        checkList.add("Hörbücher");
		        checkList.add("Hörbuch-Downloads");
//		        checkList.add("Filme");
		        checkList.add("Musik");
		        checkList.add("Spielwaren");
		        checkList.add("Games");        
		        checkList.add("Software");
		        
		    	//open search
		        eName = "eu.thalia.app:id/action_search";
		    	element = wd.findElementById(eName);
				element.click();
				Thread.sleep(2000);
				
				eName = "Verfeinern";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(2000);

				eName = "Durchsuchen:";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(500);
				
				//iterate on categories and checking
				for (int i = 0; i < checkList.size(); i++){
					if (i == 2 && aCap.screenHeight == AppiumSetup.motoHeight){
						wd.swipe(352, 890, 352, 442, 500);
					}
		            eName = checkList.get(i);
					if (wd.findElementByName(eName).isDisplayed()){
						checker++;
					}
				}
				//Check the total number
				assertTrue("The search categories are incomplete" + checker + " of " + checkList.size(), checker==checkList.size() );
			}
    	};
    	action.performAction();
        
    }
    
    @Test
    public void checkSearchOptions() throws Exception {
    	
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
    	
		    	//option arrayList to check the content of search options
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
		        
		    	//open search
		        eName = "eu.thalia.app:id/action_search";
		    	element = wd.findElementById(eName);
				element.click();
				Thread.sleep(2000);
				
				eName = "Verfeinern";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(2000);
				
				//switch searchOptions
				eName = "Sortierung:";
				element = wd.findElementByName(eName);
				Thread.sleep(500);
				element.click();
		        
				//iterate on options and checking
				for (int i = 0; i < checkList.size(); i++){
					eName = checkList.get(i);
					if (wd.findElementByName(eName).isDisplayed()){
						checker++;
						Thread.sleep(700);
					}
				}
				//Check the total number
				assertTrue("The search options are incomplete: " + checker + " of " + checkList.size(), checker==checkList.size() );
			}
    	};
    	action.performAction();
    }
     
}
