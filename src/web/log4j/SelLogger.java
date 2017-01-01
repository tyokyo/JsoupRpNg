package web.log4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Reporter;

public class SelLogger {
    
    private static Logger logger = null;
    private static SelLogger logg = null;
    
    public static SelLogger getLogger(Class<?> T) {
        if (logger == null) {
            Properties props = new Properties();
            
            try {
                InputStream is = new FileInputStream("src//cn//opentest//utils//log4j.properties");
                props.load(is);
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            PropertyConfigurator.configure(props);
            logger = Logger.getLogger(T);
            logg = new SelLogger();
        }
        return logg;
    }
    
    // 重写logger方法
    public void log(String msg) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar ca = Calendar.getInstance();
        logger.info(msg);
        Reporter.log("Reporter:" + sdf.format(ca.getTime()) + "===>" + msg);
    }
    
    public void debug(String msg) {
        logger.debug(msg);
    }
    
    public void warn(String msg) {
        logger.warn(msg);
        Reporter.log("Reporter:" + msg);
    }
    
    public void error(String msg) {
        logger.error(msg);
        Reporter.log("Reporter:" + msg);
    }
}
