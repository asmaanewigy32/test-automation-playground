package com.qacart.todo.utils;

import java.util.Properties;

public class ConfigUtils {

    private final Properties properties;
    private static ConfigUtils configUtils;

    private ConfigUtils()
    {
        String env = System.getProperty("env","production");
        switch (env)
        {
            case "production":
                properties = PropertiesUtils.loadProperties("src/test/java/com/qacart/todo/configer/production.properties");
                break;
            case "local" :
                properties = PropertiesUtils.loadProperties("src/test/java/com/qacart/todo/configer/local.properties");
                break;
            default:
                throw new RuntimeException("Environment isn`t supported");
        }
    }

    public static ConfigUtils getInstance()
    {
        if(configUtils==null)
        {
            configUtils= new ConfigUtils();
        }
        return configUtils;
    }

    @SuppressWarnings("SuspiciousIndentAfterControlStatement")
    public String getBaseUrl()
    {
        String prop= properties.getProperty("baseUrl");
        if(prop != null) return  prop;
            throw new RuntimeException("Couldn`t find the base url in the property  file");
    }

    public String getEmail()
    {
        String prop= properties.getProperty("email");
        if(prop != null) return  prop;
        throw new RuntimeException("Couldn`t find the email in the property  file");
    }

    public String getPassword()
    {
        String prop= properties.getProperty("password");
        if(prop != null) return  prop;
        throw new RuntimeException("Couldn`t find the password in the property  file");
    }
}
