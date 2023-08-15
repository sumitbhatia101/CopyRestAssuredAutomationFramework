package germany.utils;



public final class LocalIPutils {
    private LocalIPutils() {
    }

    static String hostIP;

    public static String getLocalIPAddress(){

        try {
            hostIP = "http://"+ System.getenv("HOST_IP");
            System.out.println("host IP = "+hostIP); //non-compliant code & needs to be replaced by a logger.


        } catch (Exception e) {
            e.printStackTrace();
        }

        return hostIP;
    }

}

