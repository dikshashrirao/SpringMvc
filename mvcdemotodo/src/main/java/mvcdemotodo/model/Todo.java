package mvcdemotodo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;
@Entity
public class Todo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
  private String todoTitle;
  private String todoContent;
  private Date todoDate;
public String getTodoTitle() {
	return todoTitle;
}
public void setTodoTitle(String todoTitle) {
	this.todoTitle = todoTitle;
}
public String getTodoContent() {
	return todoContent;
}
public void setTodoContent(String todoContent) {
	this.todoContent = todoContent;
}
public Date getTodoDate() {
	return todoDate;
}
public void setTodoDate(Date todoDate) {
	this.todoDate = todoDate;
}
public Todo(String todoTitle, String todoContent, Date todoDate) {
	super();
	this.todoTitle = todoTitle;
	this.todoContent = todoContent;
	this.todoDate = todoDate;
}
public Todo() {
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Todo [todoTitle=" + todoTitle + ", todoContent=" + todoContent + ", todoDate=" + todoDate + "]";
}
  
  
  
}