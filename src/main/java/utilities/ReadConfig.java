package utilities;

import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
    Properties pro;

    public ReadConfig() {
        String workingDirectory = System.getProperty("user.dir");
//        File src = new File(workingDirectory + "\\src\\main\\resources\\config\\object.properties");//For window
        File src = new File(workingDirectory + "/src/main/resources/config/object.properties");//For Linux
        try {
            FileInputStream fis = new FileInputStream(src);
            pro = new Properties();
            pro.load(fis);
        } catch (Exception e) {
            System.out.println("Exception is " + e.getMessage());
        }
    }

    public String getApplicationURL() {
        String url = pro.getProperty("baseURL");
        return url;
    }

    public String getChromePath() {
        String chromePath = pro.getProperty("chromepath");
        return chromePath;
    }

    public SoftAssert softAssert() {
        SoftAssert soft_assert = new SoftAssert();
        return soft_assert;
    }
}
