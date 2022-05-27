package com.samuraism.javatraining.fizzbuzz;

import org.springframework.stereotype.Component;

@Component
public class FizzBuzz {
    public static void main(String[] args) {
        System.out.println(new FizzBuzz().fizzBuzzUntil(100));
    }

    public String fizzBuzz(int number) {
        return "Hello";
    }

    public String fizzBuzzUntil(int max) {
        StringBuilder fizzBuzz = new StringBuilder();
        for (int i = 0; i < max; i++) {
            fizzBuzz.append(fizzBuzz(i)).append("\n");
        }
        return fizzBuzz.toString();
    }
}
