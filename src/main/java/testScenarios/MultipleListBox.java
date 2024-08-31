package testScenarios;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class MultipleListBox {

	@Test
	public void multiList() throws InterruptedException{
		// TODO Auto-generated method stub
		ArrayList<String> exp_cars=new ArrayList<String>();
		exp_cars.add("volvo");
		exp_cars.add("saab");
		exp_cars.add("audi");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
		driver.switchTo().frame("iframeResult");
		WebElement ele=driver.findElement(By.id("cars"));
		Select opts=new Select(ele);
		opts.selectByIndex(0);
		opts.selectByValue("saab");
		opts.selectByVisibleText("Audi");
		driver.findElement(By.xpath("/html/body/form/input")).click();
		Thread.sleep(4000);
		String selCars=driver.findElement(By.xpath("/html/body/div[1]")).getText();
		System.out.println("Selected Cars="+selCars);
		Reporter.log("Passed");
		driver.quit();
		
	}

}
