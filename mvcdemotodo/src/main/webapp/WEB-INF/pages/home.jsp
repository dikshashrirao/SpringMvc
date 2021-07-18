<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
       
       <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <%@ page isELIgnored="false" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" 
    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title><c:out value='${page}' />TO DO APP!</title>
  </head>
  <body>
  <div class="container mt-3">
   <h1>Welcome to TODO Manager!</h1>
   
   <c:if test="${mesg}">
      <div class="alert alert-success">
       <b><c:out value="${mesg}"></c:out></b>
     </div>
   </c:if>
  
   
  <div class="row mt-5">
       <div class="col-md-2">
       <div class="list-group">
  <a href="" type="button" class="list-group-item list-group-item-action active" aria-current="true">
    Menu
  </a>
  <a href='<c:url value='/add' />' type="button" class="list-group-item 
  list-group-item-action">Add todo</a>
  
  <a href='<c:url value='/home' />' type="button" class="list-group-item
   list-group-item-action">view todo</a>
</div>
       </div>
       
     <div class="col-md-10">
        <c:if test="${page == 'home' }">
         <h1 class="text-center">All todo home page</h1>
         
         <c:forEach items="${todos}" var="t">
           <div class="card">
              <div class="card-body">
                  <h3><c:out value="${t.todoTitle }"></c:out></h3>
                   <p><c:out value="${t.todoContent }"></c:out></p>
                   <b><c:out value="${t.todoDate }"></c:out></b>
              </div>
           </div>
         </c:forEach>
        </c:if>
        <c:if test="${page == 'add' }">
           <h1 class="text-center">Add todo</h1>
           
           <form:form action="saveTodo" method="post" modelAttribute="todo">
             <div class="form-group">
               <form:input path="todoTitle" cssClass="form-control" placeholder="enter todo title here" />
             </div>
              <div class="form-group">
              <form:textarea path="todoContent" cssClass="form-control"
              palceholder="enter your content" cssStyle="height:300px;"/>
              </div>
              <div class="container text-center">
               <button class=" btn btn-outline-success">Add Todo</button>
              </div>
           </form:form>
           
           
        </c:if>
     </div>
  </div>
  </div>
   

  </body>
</html>