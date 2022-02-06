<!DOCTYPE html>
<html lang="en">
<head>
    <title>Find Route</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
</head>
<body>
<h1>Transport List</h1>
<div>
    <#list transports as _transport>
        <div>${_transport.transport}</div><br />
    </#list>
</div>

<#include "parts/author.ftl">

</body>
</html>