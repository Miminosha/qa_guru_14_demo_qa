package com.demoqa;

import org.junit.jupiter.api.*;

import java.lang.module.Configuration;

public class ExampleJUnit5Test {

    @BeforeAll
    static void configure(){
        System.out.println("    This is the @BeforeAll");
    }

    @AfterAll
    static void tearDown(){
        System.out.println("    This is the @AfterAll");
    }

    @BeforeEach
    void beforeTest(){
        System.out.println("    This is the @BeforeEach");
    }

    @AfterEach
    void afterEach(){
        System.out.println("    This is the @AfterEach");
    }

    @Test
    void firstTest0(){
        System.out.println("    This is the @Test0");
    }

    @Test
    void firstTest1(){
        System.out.println("    This is the @Test1");
    }
}
