package com.vooc.Controls;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.vooc.Extensions.DriverExtensions;

public class Div extends DriverExtensions{
	private WebElement element;
	private List<WebElement> listElement;
	Actions action = new Actions(Browser());
	
	public Div(WebElement Element) {
		element = Element;
	}
	
	public Div(List<WebElement> Elements) {
		listElement = Elements;
	}
	
	public void Click() {
		element.click();
	}
	
	public int Count() {
		return listElement.size();
	}
	
	public String GetText() {
		return element.getText();
	}

}
