package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomeWorkMemikova {

    @BeforeAll
    static void configure(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "760x840";
    }

    @Test
    void fillFormTest(){
        open("/automation-practice-form");
        $("#firstName").setValue("Anna");
        $("#lastName").setValue("Annina");
        $("#userEmail").setValue("Anna@anna.com");
        $("[for='gender-radio-2']").click();
        $("#userNumber").setValue("9998887766");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("2004");
        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__day--015").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#subjectsInput").setValue("Computer science").pressEnter();
        $(".custom-checkbox:nth-child(3) > .custom-control-label").click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/lemur.jpg"));
        $("#currentAddress").val("Address1");
        $("#state").click();
        $("#react-select-3-option-1").click();
        $("#city").click();
        $("#react-select-4-option-1").click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(
                text("Anna Annina"),
                text("Anna@anna.com"),
                text("Female"),
                text("9998887766"),
                text("15 June,2004"),
                text("English, Computer science"),
                text("Music"),
                text("lemur.jpg"),
                text("Address1"),
                text("Uttar Pradesh Lucknow"));
    }
}