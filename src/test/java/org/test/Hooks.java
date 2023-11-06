package org.test;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;

public class Hooks  {

	WebDriver driver;
	@After
	public void after(Scenario s) {
		
		if (s.isFailed()) {
			
			TakesScreenshot t = (TakesScreenshot)driver;
			byte[] snap = t.getScreenshotAs(OutputType.BYTES);
			s.embed(snap, "image/png");
		}
		
	}
}
