package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormWithPageObjectsTest {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void configure(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "760x840";
    }

    @Test
    void fillFormWithMinimumDataTestTest(){
        registrationFormPage.openPage()
                .setFirstName("Anna")
                .setLastName("Annina")
                .setEmail("Anna@anna.com")
                .setGender("Female")
                .setNumber("9998887766")
                .setBirthDate("15", "June", "2004")
                .setSubject("English")
                .setHobbies("Music")
                .uploadPicture("lemur.jpg")
                .setAddress("Address1")
                .setStateCity("NCR", "Delhi")
                .click("#submit")
                .checkResultsVisible()
                .checkResult("Student Email", "Anna@anna.com")
                .checkResult("Date of Birth", "15 June,2004")
                .checkResult("Hobbies", "Music")
                .checkResult("State and City", "NCR Delhi");

