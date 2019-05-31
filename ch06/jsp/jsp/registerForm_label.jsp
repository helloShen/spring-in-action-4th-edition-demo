<!-- 在表单上方集中显示所有错误 -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <title>Spitter</title>
        <link rel="stylesheet" type="text/css"
              href="<c:url value="css/registerForm_label.css" />" > <!-- 绑定样式表 -->
    </head>
    <body>
        <h1>Register</h1>

        <sf:form method="POST" commandName="spitter"> <!-- Model中必须有个名为spitter的对象 -->
            <sf: label path="firstName" cssErrorClass="error">First Name: </sf: label> <!-- label标签绑定spitter.firstName域，下同 -->
                <sf: input path="firstName" cssErrorClass="error" /><br/> <!-- input标签绑定spitter.firstName域，下同 -->
            <sf: label path="lastName" cssErrorClass="error">Last Name: </sf: label>
                <sf: input path="lastName" cssErrorClass="error" /><br/>
            <sf: label path="username" cssErrorClass="error">Username: </sf: label>
                <sf: input path="username" cssErrorClass="error" /><br/>
            <sf: label path="password" cssErrorClass="error">Password: </sf: label>
                <sf: input path="password" cssErrorClass="error" /><br/>
            <input type="submit" value="Register" /> <!-- 表单提交按钮, Register是显示在按钮上的文本 -->
        </sf:form>
    </body>
</html>
