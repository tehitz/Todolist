package com.Todolist.Todolist.Controller;

import com.Todolist.Todolist.Domain.Todo;
import com.Todolist.Todolist.Domain.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    //Saves a new todos
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Todo todo){
        TRepository.save(todo);
        return "redirect:todolist";
    }


}
