package org.uncommons.reportng;

import org.testng.Reporter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/** Simple logger interface. */
public class ReportLogger {
  private static final ThreadLocal<DateFormat> DATE_FORMAT = new ThreadLocal<DateFormat>() {
    @Override protected DateFormat initialValue() {
      return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
  };
  public static void logError(String message, Object... args) {
    Reporter.log(getPrefix() + String.format(message, args));
  }

  public static void logInfo(String message, Object... args) {
    Reporter.log(getPrefix() + String.format(message, args));
  }

  public static void logDebug(boolean debug, String message, Object... args) {
    if (debug) Reporter.log(getPrefix() + String.format(message, args));
  }

  private static String getPrefix() {
    StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
    if (stackTrace == null || stackTrace.length < 4) return "[BOGUS]";
    String className = stackTrace[3].getClassName();
    String methodName = stackTrace[3].getMethodName();
    className = className.replaceAll("[a-z\\.]", "");
    String timestamp = DATE_FORMAT.get().format(new Date());
    return String.format("%s [%s.%s] ", timestamp, className, methodName);
  }
}
