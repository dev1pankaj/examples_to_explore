<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %> 

<portlet:actionURL var="formAction">
	<portlet:param name="action" value="submit1"/>
</portlet:actionURL>
 	<form action="${formAction}" method="post">
 		<input name="name" type="text"/>  
 		<input  name="SUBMIT" type="submit" value="SUBMIT"/>
 	</form>
