package com.samuraism.javatraining.fizzbuzz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {
    @Test
    void 三でのみ割り切れる場合() {
        assertEquals("fizz", FizzBuzz.fizzBuzz(3));
        assertEquals("Fizz", FizzBuzz.fizzBuzz(9));
        assertEquals("Fizz", FizzBuzz.fizzBuzz(99));
    }

    @Test
    void 五でのみ割り切れる場合() {
        assertEquals("Buzz", FizzBuzz.fizzBuzz(5));
        assertEquals("Buzz", FizzBuzz.fizzBuzz(10));
        assertEquals("Buzz", FizzBuzz.fizzBuzz(35));
    }

    @Test
    void 三と5で割り切れる場合() {
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(0));
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(15));
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(60));
    }

    @Test
    void 三でも5でも割り切れない場合() {
        assertEquals("11", FizzBuzz.fizzBuzz(11));
        assertEquals("23", FizzBuzz.fizzBuzz(23));
        assertEquals("37", FizzBuzz.fizzBuzz(37));
        assertEquals("97", FizzBuzz.fizzBuzz(97));
    }
}