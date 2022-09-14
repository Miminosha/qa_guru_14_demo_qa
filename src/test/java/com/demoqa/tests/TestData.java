package com.demoqa.tests;

import com.github.javafaker.Faker;

public class TestData {
    public static Faker faker = new Faker();
    static String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            userNumber = faker.phoneNumber().subscriberNumber(10),
            day = String.valueOf(faker.number().numberBetween(1, 30)),
            month = "June",
            year = faker.number().numberBetween(1990, 2005) + "",
            address = faker.address().fullAddress(),
            gender = "Female",
            subject = "Math",
            hobby = "Music",
            picture = "lemur.jpg",
            state = "NCR",
            city = "Delhi",
            button = "#submit";
    }

