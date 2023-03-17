package platform.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtils {

     public static Properties getProperties(String path) {
        File propertyFile = new File("target/classes/" +path);
        Properties props = new Properties();
         System.out.println(propertyFile.getAbsolutePath());
         try {
//            inputStream = PropertiesUtils.class.getClassLoader().getResourceAsStream(propertyFile.getPath());
            // load the properties file
            props.load(new FileInputStream(propertyFile));
        } catch (IOException ex) {
            throw new RuntimeException("[AUT-ERROR] Properties were not loaded from file with name :: "
                    + path + "instead throw exception:", ex);}
        return props;
    }
}
