package com.demoqa.tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.demoqa.utils.RandomUtils.*;
import static java.lang.String.format;

public class RegistrationFormWithFakerTests extends TestBase {
    Faker faker = new Faker(new Locale("ru"));

    String firstName,
    lastName,
    userEmail,
    userNumber,
    day,
    month,
    year;

    @BeforeEach
    void prepareTestData(){
//        firstName = RandomStringUtils.randomAlphabetic(10);
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        userEmail = faker.internet().emailAddress();
        userNumber = faker.phoneNumber().phoneNumber();
        day = faker.number().numberBetween(1, 30) + "";
        month = "June";
        year = faker.number().numberBetween(1990, 2005) + "";
    }


    @Test
    void fillFormTest(){
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");


        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);


        $("#genterWrapper").$(byText("Other")).click(); // best

        $("#userNumber").setValue(userNumber);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);

        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day-outside-month").click();
//        $(format(".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month", day)).click();

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
        $(".table-responsive table").$(byText("Student Name"))
                        .parent().shouldHave(text(firstName + " " + lastName));

//        String expectedFullName = (firstName + " " + lastName);
        String expectedFullName = format("%s %s", firstName, lastName);

        String expectedDateOfBirth = format("%s %s,%s", day, month, year);
        $(".table-responsive table").$(byText("Date of Birth"))
                .parent().shouldHave(text(expectedDateOfBirth));




//                shouldHave(
//                text("Anna Annina"),
//                text("Anna@anna.com"),
//                text("Other"),
//                text("9998887766"),
//                text("15 June,2004"),
//                text("English"),
//                text("Music"),
//                text("lemur.jpg"),
//                text("Address1"),
//                text("NCR Delhi"));
    }
}