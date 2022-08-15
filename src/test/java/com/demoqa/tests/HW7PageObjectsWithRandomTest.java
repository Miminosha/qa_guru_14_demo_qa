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
            gender,
            address,
            subject;

    @BeforeEach
    void prepareTestData() {
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        userEmail = faker.internet().emailAddress();
        userNumber = faker.phoneNumber().subscriberNumber();
//        dateOfBirth = faker.date().birthday().toString();
        day = String.valueOf(faker.number().numberBetween(1, 31));
        month = "June";
        year = faker.number().numberBetween(1990, 2005) + "";
//        gender = ;
        subject = faker.university().name();
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
                .setSubject(subject)
                .setHobbies("Music")
                .uploadPicture("lemur.jpg")
                .setAddress(address)
                .setStateCity("NCR", "Delhi")
                .click("#submit")
                .checkResultsVisible()
                .checkResult("Student Email", userEmail)
                .checkResult("Hobbies", "Music")
                .checkResult("State and City", "NCR Delhi");

        String expectedDateOfBirth = format("%s %s,%s", day, month, year);
        $(".table-responsive table").$(byText("Date of Birth"))
                .parent().shouldHave(text(expectedDateOfBirth));

    }
}
