package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.ResultsTableComponent;
import com.demoqa.pages.components.StateCityComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationFormPage {

    private CalendarComponent calendarComponent = new CalendarComponent();
    private ResultsTableComponent resultsTableComponent = new ResultsTableComponent();

    private StateCityComponent stateCityComponent = new StateCityComponent();

    //Elements

    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail");

    private  final static String TITLE_TEXT = "Thanks for submitting the form";


    //Actions

    public RegistrationFormPage openPage(){
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationFormPage setFirstName(String value){
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationFormPage clearFirstName(String value){
        firstNameInput.clear();

        return this;
    }

    public RegistrationFormPage setLastName(String value){
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setEmail(String value){
        emailInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setGender(String value){
        $("#genterWrapper").$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage setNumber(String value){
        $("#userNumber").setValue(value);

        return this;
    }

    public RegistrationFormPage setBirthDate(String day, String month, String year){
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationFormPage checkResultsVisible (){
        resultsTableComponent.checkVisible();

        return this;
    }

    public RegistrationFormPage checkResult (String key, String value){
        resultsTableComponent.checkResult(key, value);

        return this;
    }

    public RegistrationFormPage setSubject(String value){
        $("#subjectsInput").setValue(value).pressEnter();

        return this;
    }

    public RegistrationFormPage setHobbies(String value){
        $("#hobbiesWrapper").$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage uploadPicture(String value){
        $("#uploadPicture").uploadFromClasspath(value);

        return this;
    }

    public RegistrationFormPage setAddress(String value){
        $("#currentAddress").val(value);

        return this;
    }

    public RegistrationFormPage click (String value){
        $(value).click();

        return this;
    }

    public RegistrationFormPage setStateCity (String state, String city){
        stateCityComponent.setStateCity(state, city);

        return this;
    }


}
