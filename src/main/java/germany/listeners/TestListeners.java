package germany.listeners;

import germany.annotations.FrameworkAnnotation;
import germany.reports.ExtentLogger;
import germany.reports.ExtentReport;
import germany.utils.ELKUtils;
import germany.utils.KibanaDashUtils;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestListeners implements ITestListener, ISuiteListener{//dont forget to enable/add this class in Listener section of TestnG xml

    @Override
    public void onStart(ISuite suite) {
        KibanaDashUtils.setUpKibanaDash();
        ExtentReport.initReports();
    }

   // This method is invoked after the SuiteRunner has run all the tests in the suite.
   @Override
    public void onFinish(ISuite suite) {

        ExtentReport.tearDownReports();
    }


    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getName()); //   use this instead of the next one if testname is required to be method name on the report.
        //ExtentReport.createTest(result.getMethod().getDescription());
        //find the authors and categories from the custom annotations and then I need to call the extent report method
        String[] authors= result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).authors();
        ExtentReport.addAuthor(authors);
        //as parameters are already there on this method, reflections cannot be used, so the last line is a workaround

        String[] categories= result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).categories();
        ExtentReport.addCategory(categories);
        //as parameters are already there on this method, reflections cannot be used, so the last line is a workaround

    }


     //Invoked each time a test succeeds... na dann
     @Override
    public void onTestSuccess(ITestResult result) {//this piece would enable Extent report to know that a test has passed

        ExtentLogger.pass(result.getName()+ " is passed");
         ELKUtils.sendDetailsToElk(result.getMethod().getDescription(), "pass");
    }

    // Invoked each time a test fails.
    @Override
    public void onTestFailure(ITestResult result) {//this piece would enable Extent report to know that a test has failed
        ExtentLogger.fail(result.getName()+ " - is Failed");
        ELKUtils.sendDetailsToElk(result.getMethod().getDescription(), "fail");

        ExtentLogger.fail(String.valueOf(result.getThrowable()));

        //ExtentLogger.fail(result.getThrowable().getMessage());
        //String cleanResult=(result.getThrowable().getMessage()).replaceAll("\\s"," ");// to remove characters that Jira API doesnot accept.
       // String stackTraceOutput =(Arrays.toString(result.getThrowable().getStackTrace()));
                        //ExtentLogger.info(Arrays.toString(result.getThrowable().getStackTrace())); // in case stacktrace is required on the report
        //String issueInJira = JiraUtils.createIssueInJira(cleanResult,stackTraceOutput);
        //ExtentLogger.fail("issue created in Jira - " + (" http://192.168.56.1:8181/browse/" + issueInJira));
        //ExtentLogger.fail("issue created in Jira : <a href='http://192.168.56.1:8181/browse/'>issueIn JIra</a>");

    }


    @Override
    public void onTestSkipped(ITestResult result) {//this piece would enable Extent report to know that a test has been skipped
        ExtentLogger.skip(result.getName() + " - is Skipped");
        ELKUtils.sendDetailsToElk(result.getMethod().getDescription(), "skipped");


    }
    public void onTestIgnored(ITestResult result) {//this piece would enable Extent report to know that a test has been skipped
        ExtentLogger.ignore(result.getName() + " - is ignored");
        ELKUtils.sendDetailsToElk(result.getMethod().getDescription(), "ignored");


    }


}
