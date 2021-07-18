package com.mvc.maven.curd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mvc.maven.curd.model.User;
import com.mvc.maven.curd.service.HomeService;

@Controller
public class HomeController {
	@Autowired
	HomeService hs;
	
  @RequestMapping("/")
  public String login()
  {
    return "login";	
  }
  @RequestMapping("/register")
  public String register()
  {
    return "registration";	
  }
  @RequestMapping("/login")
  public String loginCheck(@RequestParam("uname") String uname,@RequestParam("password") String password,Model m)
  {
	if((uname.equals("admin"))&&(password.equals("admin"))) 
	{
		List<User>list=hs.showAll();
		m.addAttribute("data", list);
		return "success";
	}
	else if((!uname.equals("admin"))&&(!password.equals("admin")))  {
		List<User>list=hs.showOne(uname,password);
		m.addAttribute("data", list);
		return "success";
	}	
	else { return "login";}
  }
  @RequestMapping("/reg")
  public String registerdata(@ModelAttribute User user,Model m)
  {
	  int id=hs.saveData(user);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
	  if(id>0) {
		   return "login";	
	  }
	  else {
      return "registration";	
     }
  }
  @RequestMapping("/delete")
  public String deleteData(@RequestParam("uid")int uid,Model m)
  {
	  hs.deleteRecord(uid);
	  List<User>list=hs.showAll();
		m.addAttribute("data", list);
	  return "success";
  }
  @RequestMapping("/edit")
  public String editData(@ModelAttribute User user,@RequestParam("uid")int uid,Model m)
  {
	 User user1= hs.editRecord(uid);
		m.addAttribute("data", user1);
	  return "edit";
  }
  @RequestMapping("/update")
  public String updateData(@ModelAttribute User user,Model m)
  {
	  List<User>list=hs.updateRecord(user);
	  m.addAttribute("data", list);
	  return "success";
  }
}
