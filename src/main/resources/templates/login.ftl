<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Вхід</title>
    <link rel="stylesheet" href="/css/styles.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;300;400;500;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <script type="text/javascript" src="/webjars/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

<#import "/spring.ftl" as spring />
<#include "parts/navbar.ftl">

<div class="container text-center" style="margin-top: 120px; margin-bottom: 100px;">
    <h1 class="gradtxt">Вхід</h1>
    <form action="/login" method="post">
        <h2 class="lowtxt mb-1">Логін</h2>
        <input class="mb-3" type="text" name="username" placeholder="username">
        <h2 class="lowtxt mb-1">Пароль</h2>
        <input type="password" name="password" placeholder="password"><br><br>
        <button class="gradbtn btn btn-success" type="submit" name="addUser">Вхід</button>
    </form>
</div>

<#include "parts/author.ftl">

</body>
</html>