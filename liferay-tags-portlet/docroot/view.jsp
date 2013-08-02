<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="java.util.HashMap"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portlet.journal.model.JournalArticle"%>
<%@page import="com.liferay.portal.kernel.util.KeyValuePair"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="com.liferay.portal.kernel.util.DiffResult"%>
<%@page import="java.util.ArrayList"%>
<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<%
/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */
%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<portlet:defineObjects />
<theme:defineObjects/>


<div style="border-style:solid;border-width:1px;padding:10px;margin:10px;"> 
	<b>liferay-ui:tabs</b><br/>
	 <portlet:renderURL var="portletURL"></portlet:renderURL>
	 <liferay-ui:tabs param="currTAB"  names="tab1,tab2,tab3" refresh="<%= true %>" url="<%=portletURL.toString() %>">
	               <liferay-ui:section>
	                    <%@ include file="tab1.jsp" %>
	               </liferay-ui:section>
	               <liferay-ui:section>
	                   <%@ include file="tab2.jsp" %>
	               </liferay-ui:section>
	               <liferay-ui:section>
	                   <%@ include file="tab3.jsp" %>
	               </liferay-ui:section>
	</liferay-ui:tabs>
</div>
<div style="border-style:solid;border-width:1px;padding:10px;margin:10px;">
	<b>liferay-ui:input-date</b>
	<liferay-ui:input-date yearRangeEnd="2020" yearRangeStart="2000"  dayParam="day" monthParam="month" yearParam="year"></liferay-ui:input-date>
</div>
<br/><br/>
<div style="border-style:solid;border-width:1px;padding:10px;margin:10px;">
	<b>liferay-ui:calendar</b><br/>
	<%
	Set set=new HashSet();
	set.add(new Integer(2));
	%>
	<liferay-ui:calendar year="2013" month="1" headerPattern="dd/MM/yyyy" data="<%=set %>" day="3"></liferay-ui:calendar>
</div>
<%-- <div style="border-style:solid;border-width:1px;padding:10px;margin:10px;">
	<b>liferay-ui:flash</b><br/> 
	<liferay-ui:flash movie="/liferay-tags-portlet/docroot/Car-speakers-590x90.swf" id="flash"></liferay-ui:flash>
</div> --%>

<div style="border-style:solid;border-width:1px;padding:10px;margin:10px;">
	<b>liferay-ui:icon-***</b><br/>
	
	<liferay-ui:icon-delete url="<%=portletURL.toString() %>"/><br/>
	<liferay-ui:icon-help message="Help"></liferay-ui:icon-help><br/>
	<liferay-ui:icon-deactivate url="<%=portletURL.toString() %>"/>
	<br/>
	<liferay-ui:icon-menu>
		<liferay-ui:icon-delete url="<%=portletURL.toString() %>"/>
		<liferay-ui:icon-deactivate url="<%=portletURL.toString() %>"/>
	</liferay-ui:icon-menu>
	<br/>
	<liferay-ui:icon-list>
		<liferay-ui:icon-delete url="<%=portletURL.toString() %>"/>
		<liferay-ui:icon-deactivate url="<%=portletURL.toString() %>"/>
	</liferay-ui:icon-list>
</div>
<div style="border-style:solid;border-width:1px;padding:10px;margin:10px;">
	<b>liferay-ui:toggle-***</b><br/>
	<liferay-ui:toggle id="Mycontent" showMessage="More Options" hideMessage="Less Options">
		<div id="Mycontent" style="display:none;">
				MycontentMycontentMycontentMycontentMycontentMycontentMycontentMycontent
		</div>
	</liferay-ui:toggle>
	
	 <liferay-ui:toggle-area id="Mycontent1">
		<div id="Mycontent1">
				Mycontent111MycontentMycontentMycontentMycontentMycontentMycontentMycontent
			</div>	
	</liferay-ui:toggle-area> 
</div>

<div style="border-style:solid;border-width:1px;padding:10px;margin:10px;">
	<b>liferay-ui:ratings</b><br/>
	<liferay-ui:ratings className="<%=User.class.getName() %>"  classPK="<%=themeDisplay.getUserId() %>" />
</div>

<div style="border-style:solid;border-width:1px;padding:10px;margin:10px;">
	<b>liferay-ui:asset-tags</b><br/>
	<liferay-ui:asset-tags-selector curTags="tag4"/>
</div>
<div style="border-style:solid;border-width:1px;padding:10px;margin:10px;">
	<b>liferay-ui:input-move-boxes</b><br/>
	<%
	List leftBox = new ArrayList(), rightBox = new ArrayList();
	rightBox.add(new KeyValuePair("5","I5"));
	leftBox.add(new KeyValuePair("1", "I1"));
	leftBox.add(new KeyValuePair("2", "I2"));
	leftBox.add(new KeyValuePair("3", "I3"));
	leftBox.add(new KeyValuePair("4", "I4"));
	%>
	<liferay-ui:input-move-boxes
	leftBoxName="left_box"
	leftTitle="Available Items"
	leftList="<%=leftBox%>"
	leftReorder="true"
	rightBoxName="items"
	rightTitle="Selected Items"
	rightList="<%=rightBox%>"
	rightReorder="true" 
	 />
</div>
<div style="border-style:solid;border-width:1px;padding:10px;margin:10px;">
	<b>liferay-ui:input-scheduler</b><br/>
	<liferay-ui:input-scheduler>
	</liferay-ui:input-scheduler>
</div>
<div style="border-style:solid;border-width:1px;padding:10px;margin:10px;">
	<b>liferay-ui:input-time</b><br/>
	<liferay-ui:input-time minuteParam="minute" amPmParam="ampm" hourParam="hour"/>
</div>
<div style="border-style:solid;border-width:1px;padding:10px;margin:10px;">
	<b>liferay-ui:input-time-zone</b><br/>
	<liferay-ui:input-time-zone name="time"></liferay-ui:input-time-zone>
</div>

<div style="border-style:solid;border-width:1px;padding:10px;margin:10px;">
	<b>liferay-ui:input-permission</b><br/>
	<liferay-ui:input-permissions modelName="<%=User.class.getName() %>"></liferay-ui:input-permissions>
</div>
<div style="border-style:solid;border-width:1px;padding:10px;margin:10px;">
	<b>liferay-ui:input-resource</b><br/>
	<liferay-ui:input-resource url="http://www.google.com"></liferay-ui:input-resource>
</div>
<div style="border-style:solid;border-width:1px;padding:10px;margin:10px;">
	<b>liferay-ui:asset-links</b><br/>
	<liferay-ui:asset-links assetEntryId="11706" className="<%=JournalArticle.class.getName() %>" classPK="11704"></liferay-ui:asset-links>
</div>

<div style="border-style:solid;border-width:1px;padding:10px;margin:10px;">
	<b>liferay-ui:header</b><br/>
	<liferay-ui:header title="header"></liferay-ui:header>
</div>

<div style="border-style:solid;border-width:1px;padding:10px;margin:10px;">
	<b>liferay-ui:panel</b><br/>
	<liferay-ui:panel-container accordion="false">
		<liferay-ui:panel title="Panel1">
			Panel1 Content
		</liferay-ui:panel>
		<liferay-ui:panel title="Panel2">
			Panel2 Content
		</liferay-ui:panel>
	</liferay-ui:panel-container>
</div>



