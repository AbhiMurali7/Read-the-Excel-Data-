package ReadData.RD;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import ReadData.RD.Test;

public class runTestStep{
	
	static WebDriver driver;
	public static Test OBJTest;
	
	public runTestStep() {
		OBJTest = new Test();
	}
	
public static String runTestStep1(String action, String value, String attribute, String attrval) throws Exception {
	 
    switch(action.toLowerCase()) {
    case "openbrowser":
        switch(value.toLowerCase()) {
        case "chrome":
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            return "OK";
        case "htmlunit":
            driver = new HtmlUnitDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            return "OK";
        default:
            return "Not OK";
        }
    case "navigate":
        driver.get(value);
        return "OK";
    case "usernamexpath":
        try {
            WebElement element = OBJTest.findMyElement(attribute,attrval);
            element.sendKeys(value);
            return "OK";
        } catch (Exception e) {
            System.out.println(e.toString());
            return "Not OK";
        }
    case "passwordxpath":
        try {
            WebElement element = OBJTest.findMyElement(attribute,attrval);
            element.sendKeys(value);
            return "OK";
        } catch (Exception e) {
            System.out.println(e.toString());
            return "Not OK";
        }
    case "username1":
        try {
            WebElement element = OBJTest.findMyElement(attribute,attrval);
            element.sendKeys(value);
            return "OK";
        } catch (Exception e) {
            System.out.println(e.toString());
            return "Not OK";
        }
    case "password1":
        try {
            WebElement element = OBJTest.findMyElement(attribute,attrval);
            element.sendKeys(value);
            return "OK";
        } catch (Exception e) {
            System.out.println(e.toString());
            return "Not OK";
        }
    case "loginclick":
        try {
            WebElement element = OBJTest.findMyElement(attribute,attrval);
            element.click();
            return "OK";
        } catch (Exception e) {
            System.out.println(e.toString());
            return "Not OK";
        }
//    case "validate":
//        try {
//            WebElement element = findMyElement(attribute,attrval);
//            if (element.getText().equals(value)) {
//                return "OK";
//            } else {
//                System.out.println("Actual value: " + element.getText() + ", expected value: " + value);
//                return "Not OK";
//            }
//        } catch (Exception e) {
//            System.out.println(e.toString());
//        }
    case "closebrowser":
        driver.quit();
        return "OK";
    default:
        throw new Exception("Unknown keyword " + action);
    }
}
}
