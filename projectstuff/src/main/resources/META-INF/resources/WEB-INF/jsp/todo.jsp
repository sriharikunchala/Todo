<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
       <h3>Hi ${name}  </h3>
       <h2> You can add your Todos here......</h2>
       <hr>
       <div class="container">
	       <form:form method="post" modelAttribute="todo">
	                 <fieldset class="mb-3">
	                          <form:label path="description">Description</form:label>
			                  <form:input type="text" path="description" required = "required"/>
			                  <form:errors path="description" cssClass="text-warning"/>
			         </fieldset>
			         
			         <fieldset class="mb-3">
	                          <form:label path="targetDate">Target Date</form:label>
			                  <form:input type="Date" path="targetDate" required = "required"/>
			                  <form:errors path="targetDate" cssClass="text-warning"/>
			         </fieldset>
			         
			           <form:input type="hidden" path="done"/>
			          
			      
			       <input type="submit" class="btn btn-success"/>
	       </form:form>
	    </div>
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js  "></script>
   </body>
</html>