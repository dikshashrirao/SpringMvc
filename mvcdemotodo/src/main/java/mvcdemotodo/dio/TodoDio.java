package mvcdemotodo.dio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mvcdemotodo.model.Todo;
@Component
public class TodoDio {
  @Autowired
	HibernateTemplate hibernateTemplate;
  

  public int save(Todo t)
  {
	  Integer i=(Integer) this.hibernateTemplate.save(t);
	return i;
  }
  public List<Todo> getAll()
  {
	  List<Todo>l=this.hibernateTemplate.loadAll(Todo.class);
	  return l;
	 
  }
}
