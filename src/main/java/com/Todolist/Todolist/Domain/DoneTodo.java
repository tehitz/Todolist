package com.Todolist.Todolist.Domain;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@Entity
public class DoneTodo {

    @JoinColumn(name="id")
    @Id
    private Long id;
    private String text;
    private String date;
    private String due;


    public DoneTodo() {

    }

    public DoneTodo(Long id, String date, String text, String due) {

        this.id = id;
        this.date = date;
        this.text = text;
        this.due = due;

    }



    public String getDue() {
        return due;
    }

    public void setDue(String due) {
        this.due = due;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    @Override
    public String toString() {
        return "DoneTodo [id = " + id + ", text = " + text + ", date = " + date + ", due = " + due + "]";
    }

}