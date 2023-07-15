package germany.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public final class ExtentReport {
    private ExtentReport() {}
    private static ExtentReports extent;
   private static ExtentTest test;// static variable and not threadsafe so threadsafety is required, for which we will create a new class extent manager .


    public static void initReports(){
        //Before Suite
         extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("index.html");//creating the object on the subclass for HTML report types in extent
        extent.attachReporter(spark); // passing the report format to the extent report...source video 21 selenium basic

    }

    public static void tearDownReports (){
        extent.flush();

    }

    public static void createTest(String name) {
    test = extent.createTest(name);
    ExtentManager.setExtent(test);
    }
    public static void addAuthor(String[] authors){
        for(String author: authors)
        ExtentManager.getExtent().assignAuthor(author);
    }

    public static void addCategory(String[] categories){
        for(String category: categories)
            ExtentManager.getExtent().assignCategory(categories);
    }
}
