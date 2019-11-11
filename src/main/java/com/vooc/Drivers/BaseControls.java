package com.vooc.Drivers;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vooc.Const.TimeConst;
import com.vooc.Controls.Button;
import com.vooc.Controls.Div;
import com.vooc.Controls.Input;
import com.vooc.Utils.GetPropertiesFile;
import com.vooc.Utils.JsonFile;

public class BaseControls extends Driver {
	protected WebElement element;
	protected List<WebElement> listElement;

	public void GetWebElement(String value, String pageName) {
		String Selector = "";
		String ElementType = "";

		if (GetPropertiesFile.GetContentPropFile("IosDriverUse").equals("1")) {
			Selector = JsonFile.FindValueByKey(pageName, "IOS" + value, "Value");
			ElementType = JsonFile.FindValueByKey(pageName, "IOS" + value, "Type");
		} else {
			Selector = JsonFile.FindValueByKey(pageName, value, "Value");
			ElementType = JsonFile.FindValueByKey(pageName, value, "Type");
		}

		if (ElementType.toUpperCase().equals("XPATH")) {
			element = Browser().findElement(By.xpath(Selector));
		}
		if (ElementType.toUpperCase().equals("CSS")) {
			element = Browser().findElement(By.cssSelector(Selector));
		}
	}

	public void GetWebElement(String value, String pageName, String param) {
		String Selector = "";
		String ElementType = "";

		if (GetPropertiesFile.GetContentPropFile("IosDriverUse").equals("1")) {
			Selector = JsonFile.FindValueByKey(pageName, "IOS" + value, "Value");
			Selector = String.format(Selector, param);
			ElementType = JsonFile.FindValueByKey(pageName, "IOS" + value, "Type");
		} else {
			Selector = JsonFile.FindValueByKey(pageName, value, "Value");
			Selector = String.format(Selector, param);
			ElementType = JsonFile.FindValueByKey(pageName, value, "Type");
		}

		if (ElementType.toUpperCase().equals("XPATH")) {
			element = Browser().findElement(By.xpath(Selector));
		}
		if (ElementType.toUpperCase().equals("CSS")) {
			element = Browser().findElement(By.cssSelector(Selector));
		}
	}

	public void GetListWebElement(String value, String pageName) {
		String Selector = "";
		String ElementType = "";

		if (GetPropertiesFile.GetContentPropFile("IosDriverUse").equals("1")) {
			Selector = JsonFile.FindValueByKey(pageName, "IOS" + value, "Value");
			ElementType = JsonFile.FindValueByKey(pageName, "IOS" + value, "Type");
		} else {
			Selector = JsonFile.FindValueByKey(pageName, value, "Value");
			ElementType = JsonFile.FindValueByKey(pageName, value, "Type");
		}

		if (ElementType.toUpperCase().equals("XPATH")) {
			listElement = Browser().findElements(By.xpath(Selector));
		}
		if (ElementType.toUpperCase().equals("CSS")) {
			listElement = Browser().findElements(By.cssSelector(Selector));
		}
	}

	public void WaitPageIsLoaded() {
		WaitForPageHasComplete();
	}

	public void WaitControlIsDisplay(String value) {
		String pageName = getClass().getSimpleName().replace("Steps", "Page");
		GetWebElement(value, pageName);
		WebDriverWait wait = new WebDriverWait(Browser(), TimeConst.TimeSecWaitIsShort);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void WaitAttrIsDisplay(String value, String attr, String attrVal) {
		String pageName = getClass().getSimpleName().replace("Steps", "Page");
		GetWebElement(value, pageName);
		WebDriverWait wait = new WebDriverWait(Browser(), TimeConst.TimeSecWaitIsShort);
		wait.until(ExpectedConditions.attributeContains(element, attr, attrVal));
	}

	public boolean ControlIsExist(String value) {
		String pageName = getClass().getSimpleName().replace("Steps", "Page");
		String Selector = "";
		String ElementType = "";

		if (GetPropertiesFile.GetContentPropFile("IosDriverUse").equals("1")) {
			Selector = JsonFile.FindValueByKey(pageName, "IOS" + value, "Value");
			ElementType = JsonFile.FindValueByKey(pageName, "IOS" + value, "Type");
		} else {
			Selector = JsonFile.FindValueByKey(pageName, value, "Value");
			ElementType = JsonFile.FindValueByKey(pageName, value, "Type");
		}

		int count = 0;
		if (ElementType.toUpperCase().equals("XPATH")) {
			count = Browser().findElements(By.xpath(Selector)).size();
		}
		if (ElementType.toUpperCase().equals("CSS")) {
			count = Browser().findElements(By.cssSelector(Selector)).size();
		}
		return count > 0 ? true : false;
	}

	private Button _button;

	protected Button ControlButton(String value) {
		String pageName = getClass().getSimpleName().replace("Steps", "Page");
		_button = null;
		GetWebElement(value, pageName);
		if (_button == null) {
			_button = new Button(element);
		}
		return _button;
	}

	protected Button ControlButton(String value, String param) {
		String pageName = getClass().getSimpleName().replace("Steps", "Page");
		_button = null;
		GetWebElement(value, pageName, param);
		if (_button == null) {
			_button = new Button(element);
		}
		return _button;
	}

	private Input _input;

	protected Input ControlInput(String value) {
		String pageName = getClass().getSimpleName().replace("Steps", "Page");
		_input = null;
		GetWebElement(value, pageName);
		if (_input == null) {
			_input = new Input(element);
		}
		return _input;
	}

	protected Input ControlInput(String value, String param) {
		String pageName = getClass().getSimpleName().replace("Steps", "Page");
		_input = null;
		GetWebElement(value, pageName, param);
		if (_input == null) {
			_input = new Input(element);
		}
		return _input;
	}

	private Div _div;

	protected Div ControlDiv(String value) {
		String pageName = getClass().getSimpleName().replace("Steps", "Page");
		_div = null;
		GetWebElement(value, pageName);
		if (_div == null) {
			_div = new Div(element);
		}
		return _div;
	}

	protected Div ControlDiv(String value, String param) {
		String pageName = getClass().getSimpleName().replace("Steps", "Page");
		_div = null;
		GetWebElement(value, pageName, param);
		if (_div == null) {
			_div = new Div(element);
		}
		return _div;
	}

	protected Div ControlDivs(String value) {
		String pageName = getClass().getSimpleName().replace("Steps", "Page");
		_div = null;
		GetListWebElement(value, pageName);
		if (_div == null) {
			_div = new Div(listElement);
		}
		return _div;
	}

}
