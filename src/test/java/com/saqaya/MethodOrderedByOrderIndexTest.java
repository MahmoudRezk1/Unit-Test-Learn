package com.saqaya;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

// The Default order is: order by method name not the class method order.

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MethodOrderedByOrderIndexTest {

    @Order(0)
    @Test
    void testA(){
        System.out.println("Running Test A");
    }

    @Order(2)
    @Test
    void testB() {
        System.out.println("Running Test B");
    }

    @Order(1)
    @Test
    void testC(){
        System.out.println("Running Test C");
    }

    @Order(3)
    @Test
    void testD(){
        System.out.println("Running Test D");
    }
}
