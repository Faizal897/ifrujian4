/*
IntelliJ IDEA 2023.3.6 (Community Edition)
Build #IC-233.15026.9, built on March 21, 2024
@Author FX504GE a.k.a. Imam FR
Java Developer
Created on 03/05/2024 10:36 AM
@Last Modified 03/05/2024 10:36 AM
Version 1.0
*/

package com.juaracoding.ifrujian4.ujian4.page;

import com.juaracoding.ifrujian4.ujian4.connection.Constants;
import com.juaracoding.ifrujian4.ujian4.connection.DriverSingleton;
import com.juaracoding.ifrujian4.ujian4.util.GlobalFunction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;

    @FindBy(xpath = "//h1[normalize-space()='Sign In']")
    private WebElement logoLogin;

    @FindBy(xpath = "//input[@id='username']")
    private WebElement txtFieldUsername;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement txtFieldPassword;

    @FindBy(xpath = "//li[normalize-space()='Username Tidak Boleh Kosong']")
    private WebElement usernameLoginKosong;

    @FindBy(xpath = "//li[normalize-space()='Password Tidak Boleh Kosong']")
    private WebElement passwordLoginKosong;

    @FindBy(xpath = "//li[@class='error']")
    private WebElement usernameLoginSalah;

    @FindBy(xpath = "//li[@class='error']")
    private WebElement passwordLoginSalah;

    @FindBy(xpath = "//li[normalize-space()='Invalid Username']")
    private WebElement salahUsernamePassword;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement tombolSignIn;


    public LoginPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
    }
    public LoginPage(WebDriver driver){
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }

    public void inputUsername(String username) {
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        try{
            new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(txtFieldUsername)).sendKeys(username);
        }catch (Exception e){
            System.out.println("Username Tidak Boleh Kosong");
        }
    }

    public void inputPassword(String password) {
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        try{
            new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(txtFieldPassword)).sendKeys(password);
        }catch (Exception e){
            System.out.println("Password Tidak Boleh Kosong");
        }
    }

    public void clear() {
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        try{
            /**Username dikosongkan**/
            new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(txtFieldUsername)).clear();
            /**Password dikosongkan**/
            new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(txtFieldPassword)).clear();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public String notifUsernameLoginKosong(){
        return usernameLoginKosong ==null?"":
                new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(usernameLoginKosong)).getText();
    }
    public String notifPasswordLoginKosong(){
        return passwordLoginKosong ==null?"":
                new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(passwordLoginKosong)).getText();
    }

    public String notifUsernameLoginSalah(){
        return usernameLoginSalah ==null?"":
                new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                        .until(ExpectedConditions.visibilityOf(usernameLoginSalah)).getText();
    }
    public String notifPasswordLoginSalah(){
        return passwordLoginSalah ==null?"":
                new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                        .until(ExpectedConditions.visibilityOf(passwordLoginSalah)).getText();
    }

    public String notifUsernamePasswordSalah(){
        return salahUsernamePassword ==null?"":
                new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                        .until(ExpectedConditions.visibilityOf(salahUsernamePassword)).getText();
    }

    public String loginFormValidation() {
        return logoLogin ==null?"":
            new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(logoLogin)).getText();
    }

//    public WebElement loginFormValidation() {
//        new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
//                .until(ExpectedConditions.visibilityOf(logoLogin)).getText();
//        return logoLogin;
//    }

    public void clickLogin(){
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        try{
            new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(tombolSignIn)).click();
        }catch (Exception e){
            System.out.println("Komponen Tombol Tidak Ditemukan !!");
        }
    }
}
