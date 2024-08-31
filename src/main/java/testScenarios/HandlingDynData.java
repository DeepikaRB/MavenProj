package testScenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HandlingDynData {

	WebDriver driver;
	@Test
	public void dynDataMath()
	{
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.jqueryscript.net/demo/Simple-Math-Captcha-Plugin-for-jQuery-ebcaptcha/demo/");
		String str=driver.findElement(By.id("ebcaptchatext")).getText();
		System.out.println(str);
		String str1=str.substring(8, 9);
		String str2=str.substring(12, 13);
		System.out.println(str1+"\t"+str2);
		Integer res = Integer.valueOf(str1) + Integer.valueOf(str2);
		System.out.println(res);
		driver.findElement(By.id("ebcaptchainput")).sendKeys(String.valueOf(res));
		boolean chkenbl=driver.findElement(By.xpath("//*[@id=\"form\"]/input[2]")).isEnabled();
		System.out.println(chkenbl);
		Assert.assertEquals(chkenbl, true);
		System.out.println("Button Enabled-Entered value is correct!");
		driver.quit();
	}
}
