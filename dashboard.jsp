<%@ page import="java.util.*" %>
<%
    String role = (String) request.getAttribute("role");
%>
<h2>Welcome to Dashboard</h2>
<p>Your role: <strong><%= role %></strong></p>

<% if ("ADMIN".equals(role)) { %>
    <p>Access to Admin Controls</p>
<% } else { %>
    <p>Standard user access</p>
<% } %>

<a href="logout">Logout</a>
