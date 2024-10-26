<%@page import="java.sql.ResultSet"%>
<%@page import="common.JDBConnect"%>
<%@page import="java.sql.Statement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<table border="1">
			<%
				JDBConnect jdbc = new JDBConnect(application);
			String sql = "select id, pass, name, joindate, regidate from userlist";
			Statement stmt = jdbc.con.createStatement();

			// 쿼리수행
			ResultSet rs = stmt.executeQuery(sql);
%>
					<tr>
						<td align="center">ID </td>
						<td align="center">PW </td>
						<td align="center">NAME </td>
						<td align="center">DATE </td>
					<tr>
<% 
			while (rs.next()) {
				String id = rs.getString(1);
				String pass = rs.getString(2);
				String name = rs.getString("name");
				java.sql.Date regidate = rs.getDate("regidate");

				%>
				<tr>
						<td align="center"><% out.println(String.format("%s",id));%> </td>
						<td align="center"><% out.println(String.format("%s",pass));%> </td>
						<td align="center"><% out.println(String.format("%s",name));%> </td>
						<td align="center"><% out.println(String.format("%s",regidate));%> </td>
					<tr>
					
				<%
			}

			%>
</table>