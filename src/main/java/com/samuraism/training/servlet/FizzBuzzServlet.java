package com.samuraism.training.servlet;

import com.samuraism.training.model.FizzBuzz;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/fizzbuzz")
public class FizzBuzzServlet extends HttpServlet {
    @Inject
    FizzBuzz fizzBuzz;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String number = req.getParameter("number");
        int numberInt = 100;
        try {
            numberInt = Integer.parseInt(number);
        } catch (NumberFormatException | NullPointerException ignored) {
        }
        resp.getWriter().println(fizzBuzz.fizzBuzz(numberInt));
    }
}
