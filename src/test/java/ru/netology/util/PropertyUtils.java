package ru.netology.util;

import ru.netology.data.DBHelper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtils {
    public static Properties prop() {
        Properties properties = new Properties();
        try (InputStream is = DBHelper.class.getClassLoader().getResourceAsStream("application.properties")) {
            properties.load(is);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return properties;
    }
}
