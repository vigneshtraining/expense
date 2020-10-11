<#import "/spring.ftl" as spring />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Expense Splitter - Login </title>
    <link href="css/main.css" rel="stylesheet">
</head>
<body>
<h2>Login</h2>
<@spring.bind "user"/>


<form action="/login" method="post">
    Username:<br>
    <@spring.formInput "user.userName"/>
    <@spring.showErrors "<br>"/>
    <br><br>
    Password:<br>
    <@spring.formPasswordInput "user.password"/>
    <@spring.showErrors "<br>"/>
    <br><br>

    <input type="submit" value="Submit"/>
</form>
</body>
</html>
