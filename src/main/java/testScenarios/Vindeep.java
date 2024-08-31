package testScenarios;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Vindeep {

	@Test
	public void vin() throws InterruptedException {
		// TODO Auto-generated method stub
		ArrayList<String> exp_data=new ArrayList<String>();
		exp_data.add("Days");
		exp_data.add("Months");
		exp_data.add("Years");
		
		WebDriver obj = new EdgeDriver();
		obj.manage().window().maximize();
		obj.get("https://vindeep.com/Calculators/FDCalc.aspx");
		String title=obj.getTitle();
		System.out.println("Title="+title);
		if(title.equals("Fixed Deposit Calculator | Calculate FD Interest, Maturity value"))
		{
			System.out.println("Title matched..");
			obj.findElement(By.id("ContentPlaceHolder1_cphCentre_FDAmount")).clear();
			obj.findElement(By.id("ContentPlaceHolder1_cphCentre_FDAmount")).sendKeys("200000");
			obj.findElement(By.id("ContentPlaceHolder1_cphCentre_Period")).clear();
			obj.findElement(By.id("ContentPlaceHolder1_cphCentre_Period")).sendKeys("70");
			//dropdown code
			Select opts=new Select(obj.findElement(By.id("ContentPlaceHolder1_cphCentre_PeriodDropDown")));
			opts.selectByVisibleText("Days");
			List<WebElement> allItems=opts.getOptions();
			System.out.println("total Items="+allItems.size());
			for(int i=0;i<allItems.size();i++)
			{
				System.out.println(allItems.get(i).getText());
				if(exp_data.get(i).equals(allItems.get(i).getText()))
				{
					System.out.println("Item matched...");
				}
				else
				{
					System.out.println("Item not matched...");
				}
			}
			obj.findElement(By.id("ContentPlaceHolder1_cphCentre_InterestRate")).clear();
			obj.findElement(By.id("ContentPlaceHolder1_cphCentre_InterestRate")).sendKeys("5.40");
			//dropdown code-interest Compounding Frequency
			obj.findElement(By.name("ctl00$ContentPlaceHolder1$cphCentre$btnFDMAmount")).click();
			Thread.sleep(5000);
			String fdAmount=obj.findElement(By.id("ContentPlaceHolder1_cphCentre_MaturityAmountTextBox")).getAttribute("value");
			System.out.println("FD Amount="+fdAmount);
		}
		else
		{
			System.out.println("Title not matched..");
		}
		obj.quit();
	}

}
