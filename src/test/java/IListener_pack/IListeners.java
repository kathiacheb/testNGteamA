package IListener_pack;

import org.testng.ITestListener;
import org.testng.ITestResult;


import utilities.utilities;

public class IListeners extends utilities implements ITestListener{

	@Override
	public void onTestSuccess(ITestResult result) {
		this.driver=((utilities)result.getInstance()).driver;
		System.out.println("test passed");
		try {
			
			screenshot("Allsucceed");
			log.info("test passed and screenshot was taken");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		this.driver= ((utilities)result.getInstance()).driver;
		System.out.println("test failed");
		try {
			screenshot("Allfailed");
			log.info("test failed and screenshot was taken");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		this.driver =((utilities)result.getInstance()).driver;
		System.out.println("test skipped");
		try {
			screenshot("Allskipped");
			log.info("test skipped and screenshot was taken");
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	
}
