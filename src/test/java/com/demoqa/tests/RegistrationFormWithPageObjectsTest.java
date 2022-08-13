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
                .setBirthDate("15", "June", "2004");
        $("#submit").click();

        registrationFormPage.checkResultsVisible()
                .checkResult("Date of Birth", "15 June,2004")
                .checkResult("Student Email", "Anna@anna.com");



//
//        $("#subjectsInput").setValue("English").pressEnter();
//
//        $("#hobbiesWrapper").$(byText("Music")).click();
//
//        $("#uploadPicture").uploadFromClasspath("lemur.jpg");
//        $("#currentAddress").val("Address1");
//        $("#state").click();
//
//        $("#stateCity-wrapper").$(byText("NCR")).click();
//        $("#city").click();
//
//        $("#stateCity-wrapper").$(byText("Delhi")).click();


//        $(".modal-dialog").should(appear);
//        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
//        $(".table-responsive table").shouldHave(
//                text("Anna Annina"),
//                text("Anna@anna.com"),
//                text("Other"),
//                text("9998887766"));
//                text("15 June,2004"),
//                text("English"),
//                text("Music"),
//                text("lemur.jpg"),
//                text("Address1"),
//                text("NCR Delhi"));
    }
}