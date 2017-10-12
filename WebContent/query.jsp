<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css" integrity="sha384-nn4HPE8lTHyVtfCBi5yW9d20FjT8BJwUXyWZT9InLYax14RDjBj46LmSztkmNP9w" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>根据作者查询</title>
</head>
<body>
<form class="pure-form pure-form-stacked" action = 'query'>
<fieldset>
<legend>查询一个作者的全部书籍</legend>
<label for="name">作者姓名：</label>
<input type="text" name="name" placeholder="姓名" required>
<span class="pure-form-message">This is a required field.</span>
<button type="submit" class="pure-button pure-button-primary" >查询</button>
</fieldset>
</form>
</body>
</html>