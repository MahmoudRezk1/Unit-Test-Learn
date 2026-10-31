package com.saqaya;

import org.junit.jupiter.api.*;

// The Default order is: order by method name not the class method order.

@TestInstance(TestInstance.Lifecycle.PER_CLASS) // will create one instance for all method
//@TestInstance(TestInstance.Lifecycle.PER_METHOD) // will create an instance for each method
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MethodOrderedByOrderIndexTest {
    StringBuilder string = new StringBuilder();

    @AfterEach
    void afterEach() {
        System.out.println("Current Value of string is: " + string);
    }

    @Order(0)
    @Test
    void testA() {
        System.out.println("Running Test A");
        string.append(1);
    }

    @Order(1)
    @Test
    void testB() {
        System.out.println("Running Test B");
        string.append(2);
    }

    @Order(2)
    @Test
    void testC() {
        System.out.println("Running Test C");
        string.append(3);
    }

    @Order(3)
    @Test
    void testD() {
        System.out.println("Running Test D");
        string.append(4);
    }
}
