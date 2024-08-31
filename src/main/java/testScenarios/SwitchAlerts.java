package testScenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class SwitchAlerts {

	@Test
	public void alerts() throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("/html/body/button")).click();
		String alrtMssg=driver.switchTo().alert().getText();
		System.out.println("Alert Message="+alrtMssg);
		driver.switchTo().alert().sendKeys("Jack");
		driver.switchTo().alert().accept();
		Thread.sleep(4000);
		driver.quit();
		
	}

}
