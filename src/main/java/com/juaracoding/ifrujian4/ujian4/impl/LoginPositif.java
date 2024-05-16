/*
IntelliJ IDEA 2023.3.6 (Community Edition)
Build #IC-233.15026.9, built on March 21, 2024
@Author FX504GE a.k.a. Imam FR
Java Developer
Created on 03/05/2024 10:39 AM
@Last Modified 03/05/2024 10:39 AM
Version 1.0
*/

package com.juaracoding.ifrujian4.ujian4.impl;
import com.juaracoding.ifrujian4.ujian4.connection.*;
import com.juaracoding.ifrujian4.ujian4.page.HomePage;
import com.juaracoding.ifrujian4.ujian4.page.LoginPage;
import com.juaracoding.ifrujian4.ujian4.util.*;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPositif {
    public static WebDriver driver;
    private LoginPage loginPage ;
    private HomePage homePage;
    private RunnerUjian runnerUjian;

    @BeforeTest
    public void initCase(){
        runnerUjian = new RunnerUjian();
        DriverSingleton.getInstance(runnerUjian.getBrowser());
        this.driver = DriverSingleton.getDriver();
        this.driver.get(Constants.URL_LOGIN);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);

    }

    @Test(priority = 0)
    public void validLogin(){
        loginPage.clear();//STEP-1
        loginPage.inputUsername("Admin");//STEP-2
        loginPage.inputPassword("Admin@123");//STEP-3
        loginPage.clickLogin();//STEP-4
        String strValidation = homePage.homePageValidation();
        System.out.println("Home Page Validation "+strValidation+" terlihat, Berhasil Log In");
        GlobalFunction.delay(2);
        Assert.assertEquals("4 Fitur Unggulan",strValidation);//STEP-5
    }

    @Test(priority = 1)
    public void logout(){
        JavascriptExecutor js = (JavascriptExecutor) this.driver;
        js.executeScript("arguments[0].click()",homePage.logout());
        GlobalFunction.delay(2);
        Assert.assertEquals("Sign In",loginPage.loginFormValidation());
        System.out.println("Logo Sign In Terlihat, Berhasil Log Out");
    }

    @AfterTest
    public void closeDriver(){
        DriverSingleton.closeObjectInstance();
    }
}
