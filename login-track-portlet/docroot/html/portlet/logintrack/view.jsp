<%
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<portlet:defineObjects/>
<theme:defineObjects/>

<c:choose>
	<c:when test="${themeDisplay.signedIn}">
		<div class="portlet-msg-info">
			<liferay-ui:message key="msg" arguments='<%=portletSession.getAttribute("loginCount") %>'/>
		</div>
		<div id="logincalendar"></div>
		
		<script type="text/javascript">
		AUI({ lang: 'ja' }).use("calendar",function(A){
		   var cal= new A.Calendar({panes:2});
		    cal.selectDates([<%=portletSession.getAttribute("data") %>]);
		    cal.render("#logincalendar");
		 });
		 AUI().ready(function(A){
			 A.all('.yui3-calendar-day').on('click',function(e){e.stopPropagation();})
			 });
		</script>
	</c:when>
	<c:otherwise>
		<div class="portlet-msg-error">
			<liferay-ui:message key="error-msg"/>
		</div>
	</c:otherwise>	
</c:choose>	