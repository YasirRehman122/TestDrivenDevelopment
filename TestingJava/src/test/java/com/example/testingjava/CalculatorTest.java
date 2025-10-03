package com.example.testingjava;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CalculatorTest {

    Calculator calculator = new Calculator();
    StringBuilder builder = new StringBuilder("");

//    @BeforeEach
//    void setBoilerPlate(){
//        calculator = new Calculator();
//    }

    @AfterEach
    void afterEach(){
        System.out.println("The state of object is: " + builder);
    }
    @Order(3)
    @ParameterizedTest
    @DisplayName("Division with valid values")
    @MethodSource("divisionArgumentsProvider")
    void testIntegerDivision_WhenValidValues_ReturnCorrectResult(Integer dividend, Integer divisor, Integer expectedResult){
        Integer result = calculator.integerDivision(dividend, divisor);
        assertEquals(expectedResult,result,"4/2 should return 2");
        builder.append("3");
    }

    @Order(1)
    @Test
    void testIntegerDivision_divisionByZero_throwArithmeticException(){
        int dividend = 5;
        int divisor = 0;
        String expectedExceptionMessage = "/ by zero";

        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
            calculator.integerDivision(dividend, divisor);
        }, "Division by zero should give arithmetic exception");

        assertEquals(expectedExceptionMessage, exception.getMessage(), "Exception message is incorrect");
        builder.append(1);
    }
    private static Stream<Arguments> divisionArgumentsProvider(){
        return Stream.of(
                Arguments.of(4,2,2),
                Arguments.of(40,20,2),
                Arguments.of(35,7,5),
                Arguments.of(121,11,11)
        );
    }

    @Test
    @Order(2)
    void orderTesterMethod(){
        assertEquals(1,1);
        builder.append(2);
    }
}
