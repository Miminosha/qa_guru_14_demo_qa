package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTest {

    @BeforeAll
    static void configure(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "760x840";
    }

    @Test
    void fillFormTest(){
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");


        $("#firstName").setValue("Anna");
        $("#lastName").setValue("Annina");
        $("#userEmail").setValue("Anna@anna.com");


        $("#genterWrapper").$(byText("Other")).click(); // best

        $("#userNumber").setValue("9998887766");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("June");

        $(".react-datepicker__year-select").selectOption("2004");
        $(".react-datepicker__day--015:not(.react-datepicker__day-outside-month").click();

        $("#subjectsInput").setValue("English").pressEnter();

        $("#hobbiesWrapper").$(byText("Music")).click();

        $("#uploadPicture").uploadFromClasspath("lemur.jpg");
        $("#currentAddress").val("Address1");
        $("#state").click();

        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();

        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive table").shouldHave(
                text("Anna Annina"),
                text("Anna@anna.com"),
                text("Other"),
                text("9998887766"),
                text("15 June,2004"),
                text("English"),
                text("Music"),
                text("lemur.jpg"),
                text("Address1"),
                text("NCR Delhi"));
    }
}