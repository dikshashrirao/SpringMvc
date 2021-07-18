package com.mvc.javabased.controller;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mvc.javabased.model.User;
import com.mvc.javabased.service.HomeService;

@Controller
public class HomeController {
	@Autowired
	HomeService hs;
	
@RequestMapping("/")
public String prelogin() {
	return "login";	
}

@RequestMapping("/register")
public String register() {	
	return "success";
}

@RequestMapping("/reg")
public String registerUser(@ModelAttribute User user,Model m) {	
	int id=hs.saveRecord(user);
	if (id>0) {
		return "login";
	}
	return "registration"; 
}
@RequestMapping("/login")
public String loginCheck(@ModelAttribute User user,Model m)
{
  if((user.getUname().equals("admin"))&&(user.getPass().equals("admin")))	
		  {
	         List<User>list=hs.showAll(user);
	        m.addAttribute("data", list);
	         return "success";
		  }
    else {
	  List<User>list=hs.showOne(user.getUname(),user.getPass());
      m.addAttribute("data", list);
       return "success";
      }
  }
@RequestMapping("/delete")
public String deleteUser(@RequestParam("id") int id,Model m)
{
	List<User>list=hs.deleteRecord(id);
     m.addAttribute("data", list);
    return "success";	
}
@RequestMapping("/edit")
public String editUser(@RequestParam("id") int id,Model m) 
{
	User user=hs.editRecord(id);
	m.addAttribute("data", user);
	return "edit";
}
@RequestMapping("/update")
public String updateUser(@ModelAttribute User user,Model m) 
{
	List<User>list=hs.updateRecord(user);
	m.addAttribute("data", list);
	return "success";
}
}
