package Sele;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Basetest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path="./Result/myreport.html";
		ExtentReports reports=new ExtentReports(path);
		reports.addSystemInfo("engineer", "rakesh");

			ExtentTest tests=reports.startTest("testA");
			tests.log(LogStatus.PASS,"passes");
			reports.endTest(tests);
			ExtentTest tests1=reports.startTest("testA");
			tests1.log(LogStatus.FAIL,"fail");
			reports.endTest(tests1);
			reports.flush();
		}
	}


