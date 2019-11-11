package com.vooc.Controls;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.vooc.Extensions.DriverExtensions;

public class Button extends DriverExtensions {
	private WebElement element;
	Actions action = new Actions(Browser());


	public Button(WebElement Element) {
		element = Element;
	}

	public void Click() {
		element.click();
	}

	public void ClickWithAction() {
		action.click(element).perform();
	}
	
	public void DoubleClick() {
		action.doubleClick(element).release().build().perform();
	}
	
	public void RightClick() {
		action.contextClick(element).release().build().perform();
	}
}
