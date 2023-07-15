package germany.reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {//this class is being created a separate class to address the threadsafety.

    private ExtentManager() {}

    private static ThreadLocal<ExtentTest> threadLocal = new ThreadLocal<>();//by adding this, threadsafety is ensured for ExtentTest.This line declares a private static variable named exTest of type ThreadLocal<ExtentTest>. It is initialized with a new instance of ThreadLocal<>. ThreadLocal is a class that provides thread-local variables, meaning each thread will have its own copy of the variable.

    public static ExtentTest getExtent() {/*It returns the value of exTest by calling the get() method on the ThreadLocal object.
                                        This method is used to retrieve the ExtentTest object specific to the current thread.*/
        return threadLocal.get();
    }

     static void setExtent(ExtentTest test) {/*t sets the value of exTest by calling the set() method on the ThreadLocal object, passing the test object as the value.
                                                   This method is used to associate a specific ExtentTest object with the current thread.*/
        threadLocal.set(test);
    }

    /*To summarize, the above code defines a mechanism to store and retrieve an ExtentTest object specific to each thread using a ThreadLocal variable.
     The getTest() method retrieves the ExtentTest object for the current thread, while the setExtent(ExtentTest test) method sets the ExtentTest object for the current thread.
     This approach ensures thread-safety and allows different threads to have their own isolated instances of the ExtentTest object.*/
    //PS only the thread that sets the vale can get the value, thereby ensuring  threadsafety






}
