package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {

    Properties prop;

    public ReadProperties() {
        try {
            InputStream input = new FileInputStream("src/test/resources/env.properties");

            // load a properties file
            prop = new Properties();
            prop.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return prop.getProperty(key);
    }
}
