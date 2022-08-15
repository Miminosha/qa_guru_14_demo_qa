package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormPage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.format;

public class HW7PageObjectsWithRandomTest extends  TestBase {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    Faker faker = new Faker();

    String firstName,
            lastName,
            userEmail,
            userNumber,
            day,
            month,
            year,
            dateOfBirth,
            address;

    @BeforeEach
    void prepareTestData() {
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        userEmail = faker.internet().emailAddress();
        userNumber = faker.phoneNumber().subscriberNumber(10);
//        dateOfBirth = faker.date().birthday().toString();
        day = String.valueOf(faker.number().numberBetween(1, 30));
//        day = "15";
        month = "June";
        year = faker.number().numberBetween(1990, 2005) + "";
        address = faker.address().fullAddress();
    }


    @Test
    void fillFormWithRandomDataTest() {
        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender("Female")
                .setNumber(userNumber)
                .setBirthDate(day, month, year)
                .setSubject("Math")
                .setHobbies("Music")
                .uploadPicture("lemur.jpg")
                .setAddress(address)
                .setStateCity("NCR", "Delhi")
                .click("#submit")
                .checkResultsVisible()
                .checkResult("Student Name", firstName + " "+ lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Hobbies", "Music")
                .checkResult("State and City", "NCR Delhi");

        String expectedDateOfBirth = format("%s %s,%s", day, month, year);
        $(".table-responsive table").$(byText("Date of Birth"))
                .parent().shouldHave(text(expectedDateOfBirth));

    }
}
