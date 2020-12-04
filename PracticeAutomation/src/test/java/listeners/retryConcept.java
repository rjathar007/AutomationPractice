package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class retryConcept implements IRetryAnalyzer
{
	int counter=0;
	int retryAttempt=3;
	public boolean retry(ITestResult result)
	{
		if (counter<retryAttempt) {
			counter++;
			return true;
			
		}
		return false;
	}

}
