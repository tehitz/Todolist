package com.Todolist.Todolist.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //generates value automatically
    private Long id;

    private String text;
    private String date() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY HH:mm");
        Date newdate = new Date();
        return dateFormat.format(newdate);
    }
    private String date = date().toString();
    private String due;




    //Default constructor
    public Todo() {

    }

    public Todo(String text, String date, String due) {
        this.text = text;
        this.due = due;
        this.date = date;
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
            return "Todo [id = " + id + ", text = " + text + ", date = " + date + ", due = " + due + "]";
    }

}
