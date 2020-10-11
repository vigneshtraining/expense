<#import "/spring.ftl" as spring />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Expense Splitter - Register User</title>
    <link href="css/main.css" rel="stylesheet">
</head>
<body>
<h2>Register User</h2>
<@spring.bind "user"/>
    <form action="/register" method="post" name="user">
        Username:<br>
        <@spring.formInput "user.userName"/>
        <@spring.showErrors "<br>"/>
        <#--<input type="text" value="userName"/>-->
        <br><br>
        Password:<br>
        <@spring.formPasswordInput "user.password"/>
        <@spring.showErrors "<br>"/>
        <br><br>

        First name:<br>
        <@spring.formInput "user.firstName"/>
        <br><br>

        Last name:<br>
        <@spring.formInput "user.lastName"/>
        <br><br>

        Email:<br>
        <@spring.formInput "user.email"/>
        <@spring.showErrors "<br>"/>
        <br><br>

        Phone:<br>
        <@spring.formInput "user.mobile"/>
        <br><br>
        <input type="submit" value="Submit">
    </form>
<script src="/js/main.js"></script>
</body>
</html>