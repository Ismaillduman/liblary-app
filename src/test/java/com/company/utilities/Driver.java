package com.company.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.time.Duration;

public class Driver {
    //create a private constructor to remove access to this object
    private Driver(){}

    private static InheritableThreadLocal<WebDriver> driverPool= new InheritableThreadLocal<>();

    public static WebDriver getDriver() {
        if (driverPool.get() == null) {
            String browserType = ConfigurationReader.getProperty("browser");

            switch (browserType) {
                case "remote-chrome":
                    try {
                        // assign your grid server address
                        String gridAddress = "44.204.20.3";
                        URL url = new URL("http://" + gridAddress + ":4444/wd/hub");
                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                        desiredCapabilities.setBrowserName("chrome");
                        driverPool.set(new RemoteWebDriver(url, desiredCapabilities));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "chrome":
                    //WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "firefox":
                    //WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "headless-chrome":
                    // WebDriverManager.chromedriver().setup();
                    ChromeOptions option = new ChromeOptions();
                    option.addArguments("--headless=new");
                    driverPool.set(new ChromeDriver(option));
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;

            }
        }
        return driverPool.get();
    }
        public static void closeDriver(){
            if (driverPool.get()!=null){
            /*
            This line will terminate the currently existing driver completely. It will not exist going forward.
             */
                driverPool.get().quit();
            /*
            We assign the value back to "null" so that my "singleton" can create a newer one if needed.
             */
                driverPool.remove();
            }
        }

    }
