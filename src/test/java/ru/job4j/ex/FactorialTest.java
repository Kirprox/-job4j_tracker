package ru.job4j.ex;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertThrows;

class FactorialTest {

    @Test
    void whenExeption() {
        Factorial factorial = new Factorial();
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    factorial.calc(-1);
                });
        assertThat(exception.getMessage()).isEqualTo("Number could not be less than 0");
    }

    @Test
    void whenFactorial9Then362880() {
        Factorial factorial = new Factorial();
        int input = 9;
        int expected = 362880;
        int result = factorial.calc(input);
        assertThat(result).isEqualTo(expected);
    }

}