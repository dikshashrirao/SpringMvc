package com.mvc.javabased.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
@Id
private int id;
private String uname,pass,name,mob;
public String getMob() {
	return mob;
}
public void setMob(String mob) {
	this.mob = mob;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public String getPass() {
	return pass;
}
public void setPass(String pass) {
	this.pass = pass;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}


}
