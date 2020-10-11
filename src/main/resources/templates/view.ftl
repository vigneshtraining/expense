<#import "/spring.ftl" as spring />

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title> Expense Dashboard</title>
    <link href="css/main.css" rel="stylesheet">
</head>
<body>
<h2>Expense Dashboard</h2>
<@spring.bind "exp"/>

<div>
    <nobr>
        <a href="/splitExpense">Split Expense</a> || <a href="/participant">Add Participant</a>
    </nobr>
</div>

<br/>

<form action="/expense" method="post" name="exp">
    Date (dd/mm/yyyy format):<br>
    <@spring.formInput "exp.expDate"/>
    <br><br>
    Description:<br>
    <@spring.formInput "exp.description"/>
    <@spring.showErrors "<br>"/>

    <br><br>
    Amount:<br>
    <@spring.formInput "exp.amount"/>
    <@spring.showErrors "<br>"/>
    <br><br>
    Participant List:<br>

    <select name="plist" value="plist" multiple>
        <#if exp.participantList??>
            <#list exp.participantList as participant>
                <option value="${participant.participantName}">${participant.participantName}</option>
                <br/>
            </#list>
        <#else>
            Please add Participants!!
        </#if>
    </select>

    <@spring.showErrors "<br>"/>
    <br><br>
    Participant:<br>
    <select name="payee" value="payee">
        <#if exp.participantList??>
        <#list exp.participantList as participant>
            <option value="${participant.participantName}">${participant.participantName}</option>
            <br/>
        </#list>
        <#else>
            Please add Participants!!
        </#if>
    </select>
    <@spring.showErrors "<br>"/>
    <br><br>
    <input type="submit" value="Add "/>
</form>

<br/><br/>
<div>
    <table border="1">
        <tr>
            <th>Date</th>
            <th>Description</th>
            <th>Amount</th>
            <th>Participant List</th>
            <th>Participant</th>
            <th></th>
        </tr>
        <#if expenseList??>
        <#list expenseList![] as exp>
            <tr>
                <td>${exp.expDate}</td>
                <td>${exp.description}</td>
                <td>${exp.amount}</td>
                <td><#list exp.plist as plist>
                        ${plist_index + 1}.${plist}<#if plist_has_next>,</#if>
                    </#list>
                </td>
                <td>${exp.payee}</td>
                <td><a class="btn btn-sm btn-warning" role="button"
                       href="/delete/${exp.expId}">Delete</a></td>
            </tr>
        </#list>
        </#if>
    </table>
</div>
<script src="/js/main.js"></script>
</body>
</html>