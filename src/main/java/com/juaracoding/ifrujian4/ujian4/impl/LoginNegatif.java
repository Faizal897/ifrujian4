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

import com.juaracoding.ifrujian4.ujian4.connection.Constants;
import com.juaracoding.ifrujian4.ujian4.connection.DriverSingleton;
import com.juaracoding.ifrujian4.ujian4.page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginNegatif {
    public static WebDriver driver;
    private LoginPage loginPage;
    private RunnerUjian runnerUjian;

    @BeforeTest
    public void initCase(){
        runnerUjian = new RunnerUjian();
        DriverSingleton.getInstance(runnerUjian.getBrowser());
        this.driver = DriverSingleton.getDriver();
        this.driver.get(Constants.URL_LOGIN);
        loginPage = new LoginPage(driver);

    }

    @Test(priority = 0)
    public void emptyLogin(){
        loginPage.clear();//STEP-1
        loginPage.inputUsername("");//STEP-2
        loginPage.inputPassword("");//STEP-3
        loginPage.clickLogin();//STEP-4
        String strLoginKosong = loginPage.notifPasswordLoginKosong();//STEP-5
        System.out.println("Username & Password Kosong, tidak bisa Log In "+ strLoginKosong);
        Assert.assertEquals("password tidak boleh kosong", strLoginKosong);//STEP-6
    }

    @Test(priority = 1)
    public void invalidPassword(){
        loginPage.clear();//STEP-1
        loginPage.inputUsername("Admin123");//STEP-2
        loginPage.inputPassword("admin@123");//STEP-3
        loginPage.clickLogin();//STEP-4
        String strLoginPasswordInvalid = loginPage.notifPasswordLoginSalah();//STEP-5
        System.out.println("Password Salah, tidak bisa Log In "+ strLoginPasswordInvalid);
        Assert.assertEquals("invalid username", strLoginPasswordInvalid);//STEP-6
    }

    @Test(priority = 2)
    public void invalidUsername(){
        loginPage.clear();//STEP-1
        loginPage.inputUsername("admin");//STEP-2
        loginPage.inputPassword("Admin@123");//STEP-3
        loginPage.clickLogin();//STEP-4
        String strLoginUsernameInvalid = loginPage.notifUsernameLoginSalah();//STEP-5
        System.out.println("Username Salah, tidak bisa Log In "+ strLoginUsernameInvalid);
        Assert.assertEquals("invalid username", strLoginUsernameInvalid);//STEP-6
    }

    @Test(priority = 3)
    public void invalidLogin(){
        loginPage.clear();//STEP-1
        loginPage.inputUsername("admin");//STEP-2
        loginPage.inputPassword("admin@123");//STEP-3
        loginPage.clickLogin();//STEP-4
        String strUsernamePasswordInvalid = loginPage.notifUsernamePasswordSalah();//STEP-5
        System.out.println("Username & Password Salah, tidak bisa Log In "+ strUsernamePasswordInvalid);
        Assert.assertEquals("invalid username", strUsernamePasswordInvalid);//STEP-6
    }

    @AfterTest
    public void closeDriver(){
        DriverSingleton.closeObjectInstance();
    }
}
