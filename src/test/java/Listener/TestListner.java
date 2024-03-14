package Listener;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.bookswagon.qa.baseclass.BaseClass;

public class TestListner extends BaseClass implements ITestListener 
 {


	public void onTestStart(ITestResult result) {
	    System.out.println(".....onTestStart...... "+ result.getName());
	    extent.attachReporter(spark);
	}
	public void onTestSuccess(ITestResult result) {
	    System.out.println(".....onTestSuccess...... "+ result.getName());
	
	//inreport we have multiple meyhod so use extent obj so to capture a current method use result.get name 
	    
	    ExtentTest extentTest=extent.createTest(result.getName());
	    extentTest.pass("run when test is pass");
	extent.flush();//save everything
	}
	


	public void onTestFailure(ITestResult result) {
	    System.out.println(".....onTestFailure...... "+ result.getName());
	
	    ExtentTest extentTest=extent.createTest(result.getName());
	    extentTest.fail("run when test is fail");
	extent.flush();
	}



	public void onTestSkipped(ITestResult result) {
	    System.out.println(".....onTestSkipped...... "+ result.getName());
	    ExtentTest extentTest=extent.createTest(result.getName());
	    extentTest.skip("run when test is skipped");
	extent.flush();
	}}
