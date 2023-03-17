package platform.kpi;

import org.testng.annotations.Test;
import platform.InitTest;
import platform.utils.PropertiesUtils;

import java.util.Properties;

public class mockTest extends InitTest {


    @Test
    public void mocktest1(){
        Properties properties = PropertiesUtils.getProperties("test.properties");
        System.out.println(properties.getProperty("headless"));

    }

//    @Test
    public void mocktest2(){
//        System.out.println("mockTest2 " +x +" Test " + test);

    }
}
