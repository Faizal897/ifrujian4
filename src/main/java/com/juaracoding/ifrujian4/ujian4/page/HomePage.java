/*
IntelliJ IDEA 2023.3.6 (Community Edition)
Build #IC-233.15026.9, built on March 21, 2024
@Author FX504GE a.k.a. Imam FR
Java Developer
Created on 03/05/2024 10:37 AM
@Last Modified 03/05/2024 10:37 AM
Version 1.0
*/

package com.juaracoding.ifrujian4.ujian4.page;

import com.juaracoding.ifrujian4.ujian4.connection.Constants;
import com.juaracoding.ifrujian4.ujian4.connection.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;

    @FindBy(xpath = "//a[normalize-space()='Welcome : Admin']")
    private WebElement strWelcomAdmin;

    @FindBy(xpath = "//a[normalize-space()='Home']")
    private WebElement btnHome;

    @FindBy(xpath = "//a[normalize-space()='SOAL-1']")
    private WebElement btnSOAL1;

    @FindBy(xpath = "//a[normalize-space()='Soal-1.1']")
    private WebElement btnSOAL1_1;

    @FindBy(xpath = "//a[normalize-space()='Soal-1.2']")
    private WebElement btnSOAL1_2;

    @FindBy(xpath = "//a[normalize-space()='SOAL-2']")
    private WebElement btnSOAL2;

    @FindBy(xpath = "//li[4]//ul[1]//li[1]//a[1]")
    private WebElement btnSOAL2_1;

    @FindBy(xpath = "//li[4]//ul[1]//li[2]//a[1]")
    private WebElement btnSOAL2_2;

    @FindBy(xpath = "//h2[normalize-space()='4 Fitur Unggulan']")
    private WebElement homepageLogo;

    @FindBy(xpath = "//a[normalize-space()='logout']")
    private WebElement btnLogout;

    public HomePage() {
        this.driver= DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
    }

    public HomePage(WebDriver driver) {
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }

    public String homePageValidation() {
        return homepageLogo==null?"":
                new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                        .until(ExpectedConditions.visibilityOf(homepageLogo)).getText();
    }

    public WebElement logout(){
        return btnLogout;
    }

    public WebElement soal1(){
        return btnSOAL1;
    }
    public WebElement soal1_1(){
        return btnSOAL1_1;
    }
}
