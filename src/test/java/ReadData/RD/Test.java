package ReadData.RD;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Test {

	static WebDriver driver;
	public WebElement Locator;

	public WebElement findMyElement(String attribute, String attrval) throws Exception {

		switch (attribute.toLowerCase()) {
		case "id": {
			Locator = driver.findElement(By.id(attrval));
		}
			break;
		case "name": {
			Locator = driver.findElement(By.name(attrval));
		}
			break;
		case "xpath": {
			Locator = driver.findElement(By.xpath(attrval));
		}
			break;
		default:
			throw new Exception("Unknown selector type " + attribute);
		}

		return Locator;
	}
}