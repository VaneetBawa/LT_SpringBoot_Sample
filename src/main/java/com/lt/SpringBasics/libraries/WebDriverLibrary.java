package com.lt.SpringBasics.libraries;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

@Configuration
public class WebDriverLibrary {

    @Bean
    public WebDriver getChromeDriver() throws MalformedURLException {
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("latest");

        HashMap<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("username", "");
        ltOptions.put("accessKey", "");
        ltOptions.put("project", "SpringBasics");
        ltOptions.put("build", "Spring-Basics-Build-1");
        ltOptions.put("name", "LambdaTest-SpringBoot-Test");
        ltOptions.put("selenium_version", "4.0.0");
        ltOptions.put("w3c", true);

        browserOptions.setCapability("LT:Options", ltOptions);

        String ltHubUrl = "https://hub.lambdatest.com/wd/hub";

        return new RemoteWebDriver(new URL(ltHubUrl), browserOptions);
    }
}
