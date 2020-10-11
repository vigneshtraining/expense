<#import "/spring.ftl" as spring />

<!DOCTYPE html>
<html lang="en">
<head>
    <title> Expense Splitter</title>
    <link href="css/main.css" rel="stylesheet">
</head>
<body>
<h2>Expense Splitter</h2>
<#--<@spring.bind "splitExpense"/>-->

<div>
    <nobr>
        <a href="/expense">Add Expense</a> || <a href="/participant">Add Participant</a>
    </nobr>
</div>

<#--<form action="/splitExpense" method="post">
    Description:<br>
    <@spring.formInput "splitExpense.description"/>
    <br><br>
    Participant:<br>

    <select name="plist" value="plist" multiple>
        <#list splitExpense.participantList as participant>
            <option value="${participant.participantName}">${participant.participantName}</option>
            <br/>
        </#list>
    </select>
    <br><br>
    Amount:<br>
    <@spring.formInput "splitExpense.amount"/>
    <br><br>
    <input type="submit" value="Split "/>
</form>

<br/><br/>
<div>
    <table border="1">
        <tr>
            <th>Participant Name</th>
            <th>Amount</th>
        </tr>
        <#list expenseSplit as exp>
            <tr>
                <td>${exp.participantName}</td>
                <td>${exp.share}</td>
            </tr>
        </#list>
    </table>
</div>-->
<div>
    <table border="1">
        <tr>
            <th>Who Pays</th>
            <th>To Whom</th>
            <th>How Much</th>

        </tr>
        <#list expenseSplit as key, value>
            <#if value gt 0 >
            <tr>
                <td>${key.payee}</td>
                <td>${key.payer}</td>
                <td>${value}</td>
            </tr>
        </#if>
        </#list>
    </table>
</div>
</body>
</html>