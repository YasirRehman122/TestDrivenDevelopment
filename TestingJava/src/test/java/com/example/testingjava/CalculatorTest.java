package com.example.testingjava;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    void testIntegerDivision_WhenValidValues_ReturnCorrectResult(){
        Calculator calculator = new Calculator();
        Integer result = calculator.integerDivision(4, 2);
        assertEquals(2,result,"4/2 should return 2");
    }
}
