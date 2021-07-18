package com.mvc.secondary.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mvc.secondary.model.User;
import com.mvc.secondary.service.HomeService;

@Controller
public class HomeController {
    @Autowired
	HomeService ser;
    
    @RequestMapping("/")
    public String prelogin()
    {
    	return "login";
    }
    @RequestMapping("/register")
    public String register()
    {
	    return "registration";
    }
    @RequestMapping("/reg")
    public String addRecord(@ModelAttribute User user)
    {
    	System.out.println(user.getAd().getCity());
    	System.out.println(user.getAd().getArea());
    	int id=ser.saveData(user);
    	System.out.println(id);
    	if(id>0) {
		return "login";
    	}
    	else
    		return "registration";
    }
    
    @RequestMapping("/login")
    public String loginCheck(@RequestParam("uname") String uname,@RequestParam("password") String password, Model m) {
   
    	if((uname.equals("admin"))&&(password.equals("admin")))
    	{
    		List<User>list=ser.showAllRecords();
    		m.addAttribute("data", list);
    		return "success";
    	}
    	else if ((!uname.equals("admin"))&&(!password.equals("admin"))) {
			List<User> list=ser.showOneRecord(uname,password);
			m.addAttribute("data", list);
			return "success";
		}
		return "login";	
    }
    @RequestMapping("/delete")
    public String deleteData(@RequestParam("uid") int uid,Model m) {
    	ser.deleteRecord(uid);
    	List<User>list=ser.showAllRecords();
		m.addAttribute("data", list);
		return "success"; 	
    }
    @RequestMapping("/edit")
    public String editData(@RequestParam("uid") int uid,Model m)
    {
    	User user=ser.editRecord(uid);
    	m.addAttribute("data", user);
		return "edit"; 
    }
    @RequestMapping("/update")
    public String updateData(@ModelAttribute User user,Model m) {
    	ser.updateRecord(user);
    	List<User>list=ser.showAllRecords();
		m.addAttribute("data", list);
		return "success"; 
    }

}
