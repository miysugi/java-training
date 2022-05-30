package com.samuraism.javatraining.fizzbuzz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("NonAsciiCharacters")
class FizzBuzzTest {

    @Test
    void 三でのみ割り切れる場合() {
        assertEquals("fizz", FizzBuzz.fizzBuzz(3));
        assertEquals("fizz", FizzBuzz.fizzBuzz(9));
        assertEquals("fizz", FizzBuzz.fizzBuzz(99));
    }
    @Test
    void 五でのみ割り切れる場合() {
        assertEquals("buzz", FizzBuzz.fizzBuzz(5));
        assertEquals("buzz", FizzBuzz.fizzBuzz(10));
        assertEquals("buzz", FizzBuzz.fizzBuzz(35));
    }
    @Test
    void 三と5で割り切れる場合() {
        assertEquals("fizzbuzz", FizzBuzz.fizzBuzz(0));
        assertEquals("fizzbuzz", FizzBuzz.fizzBuzz(15));
        assertEquals("fizzbuzz", FizzBuzz.fizzBuzz(60));
    }
    @Test
    void 三でも5でも割り切れない場合() {
        assertEquals("1", FizzBuzz.fizzBuzz(1));
        assertEquals("11", FizzBuzz.fizzBuzz(11));
        assertEquals("22", FizzBuzz.fizzBuzz(22));
    }
}