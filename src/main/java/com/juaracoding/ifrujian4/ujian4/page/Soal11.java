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
import com.juaracoding.ifrujian4.ujian4.util.GlobalFunction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Soal11 {

    private WebDriver driver;

    @FindBy (xpath = "//h1[normalize-space()='Ujian Selenium']")
    private WebElement logoUjianSelenium;

    @FindBy (xpath = "//label[@for='namaDepan']")
    private WebElement logoNamaDepan;

    @FindBy (xpath = "//input[@id='namaDepan']")
    private WebElement txtNamaDepan;

    @FindBy (xpath = "//label[@for='namaBelakang']")
    private WebElement logoNamaBelakang;

    @FindBy (xpath = "//input[@id='namaBelakang']")
    private WebElement txtNamaBelakang;

    @FindBy (xpath = "//label[@for='password']")
    private WebElement logoPassword;

    @FindBy (xpath = "//input[@id='password']")
    private WebElement txtPassword;

    @FindBy (xpath = "//label[@for='alamatLengkap']")
    private WebElement logoAlamat;

    @FindBy (xpath = "//textarea[@id='alamatLengkap']")
    private WebElement txtAlamat;

    @FindBy (xpath = "//input[@id='noHp']")
    private WebElement txtTelp;

    @FindBy (xpath = "//input[@id='email']")
    private WebElement txtEmail;

    @FindBy (xpath = "//button[@type='submit']")
    private WebElement btnSubmitData;

    @FindBy (xpath = "//span[@id='xnamadepan']")
    private WebElement cekNamaDepan;

    @FindBy (xpath = "//span[@id='xnamabelakang']")
    private WebElement cekNamaBelakang;

    @FindBy (xpath = "//span[@id='xpassword']")
    private WebElement cekPassword;

    @FindBy (xpath = "//span[@id='xalamatlengkap']")
    private WebElement cekAlamat;

    @FindBy (xpath = "//span[@id='xnohp']")
    private WebElement cekNoHp;

    @FindBy (xpath = "//span[@id='xemail']")
    private WebElement cekEmail;


    public Soal11() {
        this.driver= DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
    }

    public Soal11(WebDriver driver) {
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }

    public String logoUS(){
        return logoUjianSelenium ==null?"":
                new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                        .until(ExpectedConditions.visibilityOf(logoUjianSelenium)).getText();
    }
    public String logoND(){
        return logoNamaDepan ==null?"":
                new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                        .until(ExpectedConditions.visibilityOf(logoNamaDepan)).getText();
    }
    public void inputNamaDepan(String namaDepan) {
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        try{
            new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(txtNamaDepan)).sendKeys(namaDepan);
        }catch (Exception e){}
    }
    public String logoNB(){
        return logoNamaBelakang ==null?"":
                new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                        .until(ExpectedConditions.visibilityOf(logoNamaBelakang)).getText();
    }
    public void inputNamaBelakang(String namaBelakang) {
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        try{
            new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(txtNamaBelakang)).sendKeys(namaBelakang);
        }catch (Exception e){}
    }
    public String logoPwd(){
        return logoPassword ==null?"":
                new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                        .until(ExpectedConditions.visibilityOf(logoPassword)).getText();
    }
    public void inputPassword(String password) {
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        try{
            new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(txtPassword)).sendKeys(password);
        }catch (Exception e){}
    }
    public String logoAlmt(){
        return logoAlamat ==null?"":
                new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                        .until(ExpectedConditions.visibilityOf(logoAlamat)).getText();
    }
    public void inputAlamat(String alamat) {
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        try{
            new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(txtAlamat)).sendKeys(alamat);
        }catch (Exception e){}
    }

    public void inputNoHp(String noHP) {
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        try{
            new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(txtTelp)).sendKeys(noHP);
        }catch (Exception e){}
    }
    public void inputEmail(String email) {
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        try{
            new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(txtEmail)).sendKeys(email);
        }catch (Exception e){}
    }
    public String cekND(){
        return cekNamaDepan ==null?"":
                new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                        .until(ExpectedConditions.visibilityOf(cekNamaDepan)).getText();
    }
    public String cekNB(){
        return cekNamaBelakang ==null?"":
                new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                        .until(ExpectedConditions.visibilityOf(cekNamaBelakang)).getText();
    }
    public String cekPwd(){
        return cekPassword ==null?"":
                new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                        .until(ExpectedConditions.visibilityOf(cekPassword)).getText();
    }
    public String cekAlmt(){
        return cekAlamat ==null?"":
                new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                        .until(ExpectedConditions.visibilityOf(cekAlamat)).getText();
    }
    public String cekHP(){
        return cekNoHp ==null?"":
                new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                        .until(ExpectedConditions.visibilityOf(cekNoHp)).getText();
    }
    public String cekEml(){
        return cekEmail ==null?"":
                new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                        .until(ExpectedConditions.visibilityOf(cekEmail)).getText();
    }
    public void submitData(){
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        try{
            new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(btnSubmitData)).click();
        }catch (Exception e){
            System.out.println("Tombol Submit, Hilang !!");
        }
    }

}
