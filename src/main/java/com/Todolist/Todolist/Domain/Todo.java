package com.Todolist.Todolist.Domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Todo {
    @Id
    private Long id;
    private String text;
    private Date date;
    private String due;

    public String getDue() {
        return due;
    }

    public void setDue(String due) {
        this.due = due;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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

    public Todo(String text, Long id) {
        this.id = id;
        this.text = text;

    }

    @Override
    public String toString() {
            return "Todo [id = " + id + "text = " + text + "date = " + date + "due = " + due + "]";
    }

}
