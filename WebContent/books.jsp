<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css" integrity="sha384-nn4HPE8lTHyVtfCBi5yW9d20FjT8BJwUXyWZT9InLYax14RDjBj46LmSztkmNP9w" crossorigin="anonymous">
    <title>查询结果</title>
  </head>
  <body>
    <h1><s:property value="name"/>所著的图书有：</h1>
    <ul>
    <s:iterator value="books" id="aa">
    <li>
	  <s:a href = "infor?title=%{aa}"><s:property/></s:a>
	 </li>
    </s:iterator>
	</ul>
  </body>
</html>