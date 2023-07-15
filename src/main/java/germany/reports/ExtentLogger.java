package germany.reports;


import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;





public final class ExtentLogger {
    private ExtentLogger() {    }

    public static void pass(String message) {//you pass some message and this would log it to the report

        ExtentManager.getExtent().pass(message);
    }


    public static void fail(String message) {//you pass some message and this would log it to the report
        ExtentManager.getExtent().fail(MarkupHelper.createLabel(message, ExtentColor.BLACK));//code from MarkupHelper is for formatting of the failure message.
        //ExtentManager.

    }


    public static void info(String message) {//you pass some message and this would log it to the report
        ExtentManager.getExtent().info(message);

    }

    public static void skip(String message) {//you pass some message and this would log it to the report
        ExtentManager.getExtent().info(message);

    }
    public static void ignore(String message) {//you pass some message and this would log it to the report
        ExtentManager.getExtent().info(message);

    }

    public static void logResponse(String message) {//you pass some message(response in this case) and this would log it to the report

       ExtentManager.getExtent().pass(MarkupHelper.createCodeBlock(message, CodeLanguage.JSON));
       //ExtentManager.getTest().pass(MarkupHelper.createLabel(message,ExtentColor.BLUE));
        //This block only formats the response on the extent report to json--only for better optics
        //ExtentManager is only created to handle issues with multithreading while logging the response.
        //


    }
}