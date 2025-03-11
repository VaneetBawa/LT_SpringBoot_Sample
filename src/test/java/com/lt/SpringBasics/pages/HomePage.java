package com.lt.SpringBasics.pages;

import jakarta.annotation.PostConstruct;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HomePage {

    @Autowired
    private WebDriver webDriver;

    @PostConstruct
    public void InitHomePage() {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(how = How.LINK_TEXT, using = "Login")
    public WebElement lnkLogin;

    @FindBy (how = How.LINK_TEXT, using = "Employee List")
    public WebElement lnkEmployeeList;

    public LoginPage ClickLogin() {
        lnkLogin.click();
        System.out.println("sample home page");
        return new LoginPage();
    }

    public void ClickEmployeeList () { lnkEmployeeList.click();}
}
