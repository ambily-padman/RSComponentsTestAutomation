package com.rscomponents.rscomponentsUI.utilities;

import org.apache.log4j.Logger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {
    private static Logger Log = Logger.getLogger(Log.class.getName());//

    public static void startTestCase() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();

        Log.info("****************************************************************************************");

        Log.info("****************************************************************************************");

        Log.info("Executed on: " + dateFormat.format(date));
        Log.info("****************************************************************************************");
        Log.info("****************************************************************************************");

    }

    public static void endTestCase() {
        Log.info("##################################### END ###########################################");
    }

    public static void info(String message) {
        Log.info(message);
        System.out.println(message);
    }

    public static void warn(String message) {
        Log.warn(message);
        System.out.println(message);
    }

    public static void error(String message) {
        Log.error(message);
        System.out.println(message);
    }

    public static void fatal(String message) {
        Log.fatal(message);
        System.out.println(message);
    }

    public static void debug(String message) {
        Log.debug(message);
        System.out.println(message);
    }

}
