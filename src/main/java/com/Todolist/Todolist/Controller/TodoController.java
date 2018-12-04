package com.Todolist.Todolist.Controller;

import com.Todolist.Todolist.Domain.Todo;
import com.Todolist.Todolist.Domain.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.sound.midi.Track;

@Controller
public class TodoController {

    @Autowired
    private TodoRepository TRepository;

    //Lists all todos
    @RequestMapping(value="/list")
    public String list(Model model) {
        model.addAttribute("todo", TRepository.findAll());
        return "list";
    }

    //Saves a todo's changes
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Todo todo){
        TRepository.save(todo);
        return "redirect:list";
    }

    @RequestMapping(value = "/")
    public String redirect() {
        return "redirect:list";
    }
    //Saves a new todo

    @RequestMapping(value = "/savetodo")
    public String saveTodo(Model model){
        model.addAttribute("todo", new Todo());
        return "savetodo";
    }

    //Login screen
    @RequestMapping(value="/login")
    public String login() {
        return "login";
    }


    //delete a todo
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "delete/{id}", method=RequestMethod.GET)
    public String delete(@PathVariable("id") Long id, Model model) {
        TRepository.deleteById(id);
        return "redirect:../list";
    }

    //Editing todos
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String editTodo(@PathVariable("id") Long id, Model model) {
        Todo todo = TRepository.findTodosById(id);
        model.addAttribute("todo", todo);
        return "edittodo";
    }


}
