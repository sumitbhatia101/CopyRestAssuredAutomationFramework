package tests;

public class BaseTest {//incase we do not need to decouple the extet reports from Base class, the following code would come alive
    /*
    @BeforeSuite
    public void setupSuite(){


    }

    @AfterSuite
    public void tearDownSuite(){


    }
    @BeforeMethod
   public void setUp(Method meth){
//First Test

    }
    @AfterMethod
    public void teardown(ITestResult result){/*this piece would enable Extent report to know that a test has failed
                                             otherwise it shows all tests as passed even if some have failed.*/
       /* if (!result.isSuccess()){
            ExtentLogger.fail(String.valueOf(result.getThrowable()));
        }



        }

*/

}