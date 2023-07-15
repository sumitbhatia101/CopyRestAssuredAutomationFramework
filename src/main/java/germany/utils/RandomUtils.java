package germany.utils;

public final class RandomUtils {
static String a;
static String b;
    private RandomUtils(){}
public static int getId(){

        return FakerUtils.getNumber(7000,9000);
}
public static String getFirstName(){
         a= FakerUtils.getfname();
        return a;
}
    public static String getLastName(){
         b = FakerUtils.getlname();
        return b;
    }

    public static String getEmail(){
        return (a +"."+ b+ "@gmail.com").toLowerCase();
    }
}
