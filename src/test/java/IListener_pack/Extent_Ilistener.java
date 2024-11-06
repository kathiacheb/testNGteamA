package IListener_pack;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import utilities.utilities;

public class Extent_Ilistener extends utilities implements ITestListener{

	public static void main(String[] args) {
		

	}

	@Override
	public void onTestStart(ITestResult result) {
		log.info("on test start, now executing:" +result.getName());
		
	}
	@Override
	public void onStart(ITestContext context) {
		log.info("on start listener, extent report configuration done");
		 configreport();
	}
	
	@Override
	public void onFinish(ITestContext context) {
		log.info("on finish listener, extent report configuration done");
		extent.flush();
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test= extent.createTest(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("name of the passed method:" +result.getName(), ExtentColor.GREEN));	

	}

	@Override
	public void onTestFailure(ITestResult result) {
		test= extent.createTest(result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel("name of the failed method:" +result.getName(), ExtentColor.RED));	


	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test= extent.createTest(result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("name of the skipped method:" +result.getName(), ExtentColor.YELLOW));	


	}

	

	

}
