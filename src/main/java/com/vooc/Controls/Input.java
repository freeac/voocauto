package com.vooc.Controls;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.vooc.Extensions.DriverExtensions;

public class Input extends DriverExtensions {
	private WebElement element;
	Actions action = new Actions(Browser());

	public Input(WebElement Element) {
		element = Element;
	}

	public void Click() {
		element.click();
	}

	public void Clear() {
		element.clear();
	}

	public void ClearWithKeyboard() {
		element.sendKeys(Keys.END);
		element.sendKeys(Keys.SHIFT, Keys.HOME);
		element.sendKeys(Keys.DELETE);
		Clear();
	}

	public void InputValue(String val) {
		ClearWithKeyboard();
		element.sendKeys(val);
	}
	
	public void InputValueMobile(String val) {
		element.clear();
		element.sendKeys(val);
	}

	public String GetText() {
		return element.getText();
	}

	public String GetAttribute(String attrName) {
		return element.getAttribute(attrName);
	}
}
