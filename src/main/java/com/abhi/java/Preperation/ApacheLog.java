package com.abhi.java.Preperation;

import java.util.HashMap;

/**
 * Created by abhdogra1 on 1/29/2019.
 */

/**
 * String findTopIpaddress(String[] lines)
 * Given an Apache log file, return IP address(es) which accesses the site most often.
 *
 * Our log is in this format (Common Log Format). One entry per line.
 * 10.0.0.1 - frank [10/Dec/2000:12:34:56 -0500] "GET /a.gif HTTP/1.0" 200 234
 *
 * Log file entries are passsed as an array.
 *
 * NOTE: In case of tie, this returns a comma-separated list of the IP
 * addresses. Tie is not mentioned explicitly in the exercise on purpose.
 *
 */
public class ApacheLog {

    public static String findTopIpaddress(String[] lines) {
        HashMap<String,Integer> map = new HashMap<>();

        for(int i =0;i<lines.length;i++){
            int index = lines[i].indexOf('-');
            String ip = lines[i].substring(0,index-1);

            if(map.containsKey(ip)){
                map.put(ip,map.get(ip)+1);
            }else
                map.put(ip,1);
        }

        int biggest = -1;
        String mostUsed[] = new String[map.size()];

        int counter=0;
        for(String s : map.keySet()){
            int temp = map.get(s);
            if(temp == biggest)
                counter++;
            if(temp >= biggest) {
                biggest = temp;
                mostUsed[counter] = s;
            }
        }

        String retVal = "";
        String breaker = ",";
        for(int i = mostUsed.length-1; i >=0;i--){
            if(mostUsed[i] != null)
                retVal+=mostUsed[i]+breaker;
        }

        return retVal.substring(0,retVal.length()-1);
    }



    /**
     * boolean doTestsPass()
     * Returns true if the test passes. Otherwise returns false.
     */
    public static boolean doTestsPass() {
        // TODO: improve the test
        String lines[] = new String[] {
                "10.0.0.1 - frank [10/Dec/2000:12:34:56 -0500] \"GET /a.gif HTTP/1.0\" 200 234",
                "10.0.0.1 - frank [10/Dec/2000:12:34:57 -0500] \"GET /b.gif HTTP/1.0\" 200 234",
                "10.0.0.2 - nancy [10/Dec/2000:12:34:58 -0500] \"GET /c.gif HTTP/1.0\" 200 234",
                "10.0.0.2 - nancy [10/Dec/2000:12:34:59 -0500] \"GET /c.gif HTTP/1.0\" 200 234",
                "10.0.0.3 - logan [10/Dec/2000:12:34:59 -0500] \"GET /d.gif HTTP/1.0\" 200 234", };
        String result = findTopIpaddress(lines);

        if (result.equals("10.0.0.1,10.0.0.2")) {
            System.out.println("Test passed");
            return true;
        } else {
            System.out.println("Test failed");
            return false;
        }
    }

    public static void main(String[] args) {
        doTestsPass();
    }
}
