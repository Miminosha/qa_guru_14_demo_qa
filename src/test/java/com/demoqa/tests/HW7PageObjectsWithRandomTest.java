package com.demoqa.tests;

import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.demoqa.tests.TestData.*;
import static java.lang.String.format;

public class HW7PageObjectsWithRandomTest extends  TestBase {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();


    @Test
    @Tag("using")
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
