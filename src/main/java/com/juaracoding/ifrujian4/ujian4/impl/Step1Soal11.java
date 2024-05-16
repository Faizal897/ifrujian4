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
import com.juaracoding.ifrujian4.ujian4.page.HomePage;
import com.juaracoding.ifrujian4.ujian4.page.LoginPage;
import com.juaracoding.ifrujian4.ujian4.page.Soal11;
import com.juaracoding.ifrujian4.ujian4.util.GlobalFunction;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Step1Soal11 {
    public static WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private Soal11 soal11;
    private RunnerUjian runnerUjian;

    @BeforeTest
    public void initCase() {
        runnerUjian = new RunnerUjian();
        DriverSingleton.getInstance(runnerUjian.getBrowser());
        this.driver = DriverSingleton.getDriver();
        this.driver.get(Constants.URL_LOGIN);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        soal11 = new Soal11(driver);

    }

    @Test(priority = 0)
    public void validLogin() {
        loginPage.clear();//STEP-1
        loginPage.inputUsername("Admin");//STEP-2
        loginPage.inputPassword("Admin@123");//STEP-3
        loginPage.clickLogin();//STEP-4
        String strValidation = homePage.homePageValidation();
        System.out.println("Home Page Validation " + strValidation + " terlihat, Berhasil Log In");
        GlobalFunction.delay(2);
        Assert.assertEquals("4 Fitur Unggulan", strValidation);//STEP-5
    }
    @Test(priority = 1)
    public void homeToSoal11(){
        JavascriptExecutor js = (JavascriptExecutor) this.driver;
        js.executeScript("arguments[0].click()",homePage.soal1_1());
        GlobalFunction.delay(2);
        String strValidation = soal11.logoUS();
        Assert.assertEquals("Ujian Selenium", strValidation);
        System.out.println("Logo Ujian Selenium Terlihat, dapat mengisi Form");
    }

    @Test(priority = 1)
    public void inputDataSoal11(){
        soal11.inputNamaDepan(runnerUjian.getNamaDepan());
        soal11.inputNamaBelakang(runnerUjian.getNamaBelakang());
        soal11.inputPassword(runnerUjian.getPassWord());
        JavascriptExecutor js = (JavascriptExecutor) this.driver;
        js.executeScript("window.scrollBy(0,1500)","");
        soal11.inputAlamat(runnerUjian.getAlaMat());
        soal11.inputNoHp(runnerUjian.getNoHp());
        soal11.inputEmail(runnerUjian.getEmail());
        soal11.submitData();
        js.executeScript("window.scrollBy(0,1500)","");
        GlobalFunction.delay(2);
        String strNamaDepan = soal11.cekND();
        String strNamaBelakang = soal11.cekNB();
        String strPassword = soal11.cekPwd();
        String strAlamat = soal11.cekAlmt();
        String strNoHp = soal11.cekHP();
        String strEmail = soal11.cekEml();
        System.out.println("Form sudah terisi");

        Assert.assertEquals(runnerUjian.getNamaDepan(),strNamaDepan);
        Assert.assertEquals(runnerUjian.getNamaBelakang(),strNamaBelakang);
        Assert.assertEquals(runnerUjian.getPassWord(),strPassword);
        Assert.assertEquals(runnerUjian.getAlaMat(),strAlamat);
        Assert.assertEquals("+62"+ runnerUjian.getNoHp(),strNoHp);
        Assert.assertEquals(runnerUjian.getEmail(),strEmail);
        GlobalFunction.delay(2);
        System.out.println("Form sudah sesuai");
    }

    @AfterTest
    public void closeDriver(){
        DriverSingleton.closeObjectInstance();
    }

}
