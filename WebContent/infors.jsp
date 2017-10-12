<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css" integrity="sha384-nn4HPE8lTHyVtfCBi5yW9d20FjT8BJwUXyWZT9InLYax14RDjBj46LmSztkmNP9w" crossorigin="anonymous">
    <title>详细信息</title>
  </head>
  <body>
    <h1 align= center>图书详细信息</h1>
    <table border = 1 class="pure-table pure-table-horizontal" align= center>
      <thead>
      <tr>
        <th>ISBN</th>
        <th>Title</th>
        <th>AuthorID</th>
        <th>Publisher</th>
        <th>PublishDate</th>
        <th>Price</th>
      </tr>
      </thead>
       <tbody>
      <tr>
        <td id="ISBN"><s:property value="isbn"/></td>
        <td><s:property value="title"/></td>
        <td><s:property value="authorID"/></td>
        <td><s:property value="publisher"/></td>
        <td><s:property value="publishDate"/></td>
        <td><s:property value="price"/></td>
      </tr>
      </tbody>
    </table>
    <hr>
    <h1 align= center>作者详细信息</h1>
    <table border = 1 class="pure-table pure-table-horizontal" align= center>
    <thead>
      <tr>
        <th>AuthorID</th>
        <th>Name</th>
        <th>Age</th>
        <th>Country</th>
      </tr>
      </thead>
      <tbody>
      <tr>
        <td><s:property value="authorID"/></td>
        <td><s:property value="name"/></td>
        <td><s:property value="age"/></td>
        <td><s:property value="country"/></td>
      </tr>
      </tbody>
    </table>
    <p align = center>
    <s:a href="del?isbn=%{isbn}" ><button class="pure-button">删除记录</button></s:a>
    </p>
  </body>
</html>