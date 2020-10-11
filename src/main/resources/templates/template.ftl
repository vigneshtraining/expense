<#import "/spring.ftl" as spring />

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Participants</title>
    <link href="css/main.css" rel="stylesheet">
</head>
<body>
<h2>Add Participant</h2>
<@spring.bind "participant"/>

<div>
    <nobr>
        <a href="/splitExpense">Split Expense</a> | <a href="/expense">View Expense</a>
    </nobr>
</div>

<br/>

<form action="/participant" method="post">

    Name:<br>
    <@spring.formInput "participant.participantName"/>
    <@spring.showErrors "<br>"/>
    <br><br>
    Mobile Number:<br>
    <@spring.formInput "participant.mobileNum"/>
    <@spring.showErrors "<br>"/>
    <br><br>
    <input type="submit" value="Add Participant"/>
</form>

<br/><br/>
<div>
    <table border="1">
        <tr>
            <th>Participant Name</th>
            <th>Mobile Number</th>
            <th></th>
        </tr>
        <#if participantList??>
        <#list participantList as participant>
            <tr>
                <td>${participant.participantName}</td>
                <td>${participant.mobileNum}</td>
                <td><a class="btn btn-sm btn-warning" role="button"
                       href="/deleteparticipant/${participant.participantId}">Delete</a></td>
            </tr>
        </#list>
        </#if>
    </table>
</div>

</body>
</html>