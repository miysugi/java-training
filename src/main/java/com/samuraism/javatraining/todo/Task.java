package com.samuraism.javatraining.todo;

import jakarta.persistence.*;

@Entity
@Table(name = "Task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String text;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getText() {
        return text;
    }

    public void setText(String firstName) {
        this.text = firstName;
    }
}