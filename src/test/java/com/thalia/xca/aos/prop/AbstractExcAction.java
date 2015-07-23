package com.thalia.xca.aos.prop;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.SessionNotFoundException;

public abstract class AbstractExcAction {

	protected String eName = null;
	protected MobileElement element = null;
	protected AndroidDriver<MobileElement> wd;
	
	public AbstractExcAction(AndroidDriver<MobileElement> wd){
		this.wd = wd;
	}
	
	public final void performAction() {
		
		try {
			actionPerformedWithThrows();
		} catch (NoSuchElementException ex) {
            wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			List<MobileElement> temps = wd.findElementsByName("\"Thalia\" wurde beendet.");
			if (temps.size() > 0){
	    		assertTrue("Before clicking Element \"" + eName + "\" the app broke down: SessionNotFoundException", false);
			} else {
				assertTrue("Element \"" + eName + "\" could not be located : NoSuchElementException", false);
			}
		} catch (InterruptedException e) {
    		assertTrue("Some Thread interrupted: " + e.getStackTrace(), false);
		} catch (ArrayIndexOutOfBoundsException e) {
    		assertTrue("Element \"" + eName + "\" could not be located : ArrayIndexOutOfBoundsException", false);
		} catch (IndexOutOfBoundsException e) {
    		assertTrue("Element \"" + eName + "\" could not be located : IndexOutOfBoundsException", false);
		} catch (WebDriverException e) {
			assertTrue("WebDriver Exception", false);
		
		} finally {
			try {
				wd.quit();
			} catch (SessionNotFoundException e) {
	    		assertTrue("Before clicking Element \"" + eName + "\" the app broke down: SessionNotFoundException", false);
	
			}
		}
	}
	
	public abstract void actionPerformedWithThrows()
			throws NoSuchElementException, InterruptedException;
}
