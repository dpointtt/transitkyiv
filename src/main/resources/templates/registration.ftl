<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Реєстрація</title>
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
    <h1 class="gradtxt">Реєстрація</h1>
    <@spring.bind "tkusers" />

    <form action="/registration" method="post">
        <h2 class="lowtxt mb-1">Ім'я</h2>
        <@spring.formInput "tkusers.firstName" />
        <@spring.showErrors "<br>" /><br><br>

        <h2 class="lowtxt mb-1">Прізвище</h2>
        <@spring.formInput "tkusers.lastName" />
        <@spring.showErrors "<br>" /><br><br>

        <h2 class="lowtxt mb-1">Логін</h2>
        <@spring.formInput "tkusers.userName" />
        <@spring.showErrors "<br>" /><br><br>

        <h2 class="lowtxt mb-1">Пароль</h2>
        <@spring.formInput "tkusers.password" />
        <@spring.showErrors "<br>" /><br><br><br>

        <button class="gradbtn btn btn-success" type="submit" value="addUser">Зареєструватися</button>
    </form>
</div>

<#include "parts/author.ftl">

</body>
</html>