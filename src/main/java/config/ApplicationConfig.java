package config;


import org.apache.log4j.Logger;
import util.PropertyReader;

import java.io.Serializable;
import java.util.Properties;

public class ApplicationConfig implements Serializable{

    private static final long serialVersionUID = 1546153133100666389L;

    private final Logger iLogger = Logger.getLogger(ApplicationConfig.class);
    private static final String PROPERTIES = "local.properties";
    private static final String URL = "base.url";
    private static final String DRIVER_NAME = "driver.name";
    private static final String USER_LOGIN = "user.login";
    private static final String USER_PASSWORD = "user.password";

    private String iDriverName;

    private String iBaseUrl;

    private String login;

    private String password;



    private static ApplicationConfig instance;

    private ApplicationConfig() {
        if (PropertyReader.getInstance() != null) {
            Properties props = PropertyReader.getInstance().getProperties(PROPERTIES);
            setBaseUrl(props.getProperty(URL));
            setDriverName(props.getProperty(DRIVER_NAME));
            setPassword(props.getProperty(USER_PASSWORD));
            setLogin((props.getProperty(USER_LOGIN)));
        }
    }

    public static ApplicationConfig getInstance() {
        if (instance == null) {
            instance = new ApplicationConfig();
        }
        return instance;
    }

    public String getDriverName() {
        return iDriverName;
    }

    public void setDriverName(String iDriverName) {
        this.iDriverName = iDriverName;
        iLogger.info("Driver name: " + this.iDriverName);
    }

    public String getBaseUrl() {
        return iBaseUrl;
    }

    public void setBaseUrl(String iBaseUrl) {
        this.iBaseUrl = iBaseUrl;
        iLogger.info("Base url: " + this.iBaseUrl);
    }
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
