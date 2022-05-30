package com.samuraism.javatraining.fizzbuzz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@org.springframework.stereotype.Controller
public class FizzBuzzController {
    @Autowired
    private FizzBuzz fizzbuzz;

    @GetMapping("/fizzbuzz")
    String fizzbuzz(Model model) {
        var fizzBuzz = fizzbuzz.fizzBuzz();
        model.addAttribute("fizzBuzz", fizzBuzz);
        return "fizzbuzz";
    }
}
