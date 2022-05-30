package com.samuraism.javatraining.fizzbuzz;

import org.springframework.stereotype.Component;

@Component
public class FizzBuzz {
    public static void main(String[] args) {
        System.out.println(new FizzBuzz().fizzBuzz());
    }

    static public String fizzBuzz(int number) {
        String result = "";
        if (number%3==0) {
            result += "fizz";
        }
        if (number%5==0) {
            result += "buzz";
        }
        if (number % 3 != 0 && number % 5 != 0) {
            result+=number;
        }
        return result;
    }

    public String fizzBuzz() {
        StringBuilder fizzBuzz = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            fizzBuzz.append(fizzBuzz(i)).append("\n");
        }
        return fizzBuzz.toString();
    }
}
