package Sele;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Basetest1 
{
	ExtentReports reports;
	ExtentTest tests;
	public void init()
	{
	String path="./Result/myreport.html";
	ExtentReports reports=new ExtentReports(path);
	reports.addSystemInfo("engineer","rakesh");
	}
	
	@BeforeMethod
	public void precondition(Method testname)
	{
String name=testname.getName();
tests=reports.startTest(name);

}
	@AfterMethod
	public void postcondition(ITestResult res)
	{
		int s=res.getStatus();
		if(s==1)
		{
			tests.log(LogStatus.PASS, "pass");
		}
	
		else
			if(s==2)
			{
				tests.log(LogStatus.FAIL, "fail");
			}
		reports.endTest(tests);
	}
	@AfterSuite()
	public void endsuite()
	{
		reports.flush();
	}

@Test
public void TestA()
{
	tests.log(LogStatus.INFO,"TestA");
}
@Test
public void TestB()
{
	Assert.fail();
	tests.log(LogStatus.INFO,"TestB");
}

}