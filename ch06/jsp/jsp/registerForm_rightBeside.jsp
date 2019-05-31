<!-- 这个表单在输入域的右边直接显示错误信息 -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <title>Spitter</title>
        <link rel="stylesheet" type="text/css"
              href="<c:url value="css/registerForm_rightBeside.css" />" > <!-- 绑定样式表 -->
    </head>
    <body>
        <h1>Register</h1>
        <sf:form method="POST" commandName="spitter"> <!-- Model中必须有个名为spitter的对象 -->
            <sf: errors path="*" element="div" cssClass="errors" /> <!-- 默认渲染在span中，这里改成div。对应css样式class属性：errors -->
            First Name: <sf: input path="firstName" /><br/> <!-- 绑定spitter.firstName域，下同 -->
                <sf: errors path="firstName" /><br/> <!-- 在输入域旁显示错误信息 -->
            Last Name: <sf: input path="lastName" /><br/>
                <sf: errors path="lastName" /><br/>
            Username: <sf: input path="username" /><br/>
                <sf: errors path="username" /><br/>
            Password: <sf: input path="password" /><br/>
                <sf: errors path="password" /><br/>
            <input type="submit" value="Register" /> <!-- 表单提交按钮, Register是显示在按钮上的文本 -->
        </sf:form>
    </body>
</html>
