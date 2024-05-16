/*
IntelliJ IDEA 2024.1.1 (Community Edition)
Build #IC-241.15989.150, built on April 29, 2024
@Author FX504GE a.k.a. Imam FR
Java Developer
Created on 06/05/2024 2:04 PM
@Last Modified 06/05/2024 2:04 PM
Version 1.0
*/

package com.juaracoding.ifrujian4.ujian4.impl;

import com.juaracoding.ifrujian4.ujian4.connection.Constants;
import org.testng.TestNG;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RunnerUjian {

    private static String namaDepan = "Imam";
    private static String namaBealakng = "Faizal";
    private static String passWord = "faiz123";
    private static String alaMat = "Cawang, Jakarta Timur";
    private static String noHp = "854255865532";
    private static String email = "faizal.imam";

    private String Browser = Constants.EDGE;

    public String getBrowser() {
        return Browser;
    }

    public String getNamaDepan() {
        return namaDepan;
    }
    public String getNamaBelakang() {
        return namaBealakng;
    }
    public String getPassWord() {
        return passWord;
    }
    public String getAlaMat() {
        return alaMat;
    }
    public String getNoHp() {
        return noHp;
    }
    public String getEmail() {
        return email;
    }

    public static void main(String[] args) {
        String rootProject = System.getProperty("user.dir");
        TestNG runner = new TestNG();
        runner.setOutputDirectory(rootProject+"\\output-testng\\selenium\\"+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMyyyy-HHmmss")));
        List<String> suitefiles = new ArrayList<String>();
        suitefiles.add(rootProject+"\\ujianloginpositif.xml");
        suitefiles.add(rootProject+"\\ujianloginnegatif.xml");
        suitefiles.add(rootProject+"\\ujiansoal11.xml");
        runner.setTestSuites(suitefiles);
        runner.run();
    }
}
