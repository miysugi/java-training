package com.samuraism.training.model;

import javax.persistence.*;

@Entity
@Table(name = "FIZZ")
@NamedQuery(name = "FizzBuzz.findAll", query = "SELECT e FROM Fizz e")
    public class Fizz {
    @Id
    private Integer number;
    private String fizzBuzz;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer id) {
        this.number = id;
    }


    public String getFizzBuzz() {
        return fizzBuzz;
    }

    public void setFizzBuzz(String firstName) {
        this.fizzBuzz = firstName;
    }
}