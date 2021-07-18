package mvcdemotodo.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mvcdemotodo.dio.TodoDio;
import mvcdemotodo.model.Todo;




@Controller
public class HomeController {
	
	@Autowired
	TodoDio todoDio;
	
 @RequestMapping("/home" )
	public String home(Model m )   { 
	 String str="home";
	 m.addAttribute("page", str);
	 List<Todo> l=this.todoDio.getAll();
	 m.addAttribute("todos", l);
		return "home";	
	}
 
 @RequestMapping("/add" )
 public String addTodo(Model m)
 {
	 Todo t=new Todo();
	 String str="add";
	 m.addAttribute("page", str);
	 m.addAttribute("todo", t);
	 return "home";
 }
 

 @Transactional
 @RequestMapping(value="/saveTodo", method=RequestMethod.POST )
 public String saveTodo(@ModelAttribute("todo") Todo t, Model m)
 {
	 m.addAttribute("page", "home");
 System.out.println(t);
	 t.setTodoDate(new Date());
	 this.todoDio.save(t);
	 m.addAttribute("mesg", "added successfully..");
	 return "home";
 }
}
