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
import static com.demoqa.tests.TectData.*;
import static java.lang.String.format;

public class HW7PageObjectsWithRandomTest extends  TestBase {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();


    @Test
    void fillFormWithRandomDataTest() {
        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(gender)
                .setNumber(userNumber)
                .setBirthDate(day, month, year)
                .setSubject(subject)
                .setHobbies(hobby)
                .uploadPicture(picture)
                .setAddress(address)
                .setStateCity(state, city)
                .click(button)
                .checkResultsVisible()
                .checkResult("Student Name", firstName + " "+ lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Hobbies", hobby)
                .checkResult("State and City", state + " "+ city);

        String expectedDateOfBirth = format("%s %s,%s", day, month, year);
        $(".table-responsive table").$(byText("Date of Birth"))
                .parent().shouldHave(text(expectedDateOfBirth));

    }
}
