<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Головна сторінка</title>
    <link rel="stylesheet" href="/css/styles.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;300;400;500;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <script type="text/javascript" src="/webjars/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

<#include "parts/navbar.ftl">

<div class="container text-start mb-5" style="margin-top: 120px">
    <img src="/img/svg/LogoHome.svg" class="float-end mt-2 mb-2" style="width: 32%; height: auto;" alt="">
    <h1 class="gradtxt">Transit Kyiv</h1>
    <h2 class="deftxt ms-2">Зручний інструмент</h2>
    <h2 class="deftxt ms-2">для пошуку потрібних</h2>
    <h2 class="deftxt ms-2">автобусів, тролейбусів</h2>
    <h2 class="deftxt ms-2">та трамваїв в місті Київ.</h2>
</div>

<div class="text-center mt-5 mb-5">
    <img src="/img/svg/Line.svg" alt="" style="width: 90%;">
</div>

<div class="container text-center mb-5">
    <h1 class="gradtxt" style="font-size: 64px;">Як почати користуватись?</h1>
    <div class="text-start mb-5" style="margin-top: 80px;">
        <img src="/img/svg/Tram.svg" class="float-end" style="width: 22%; height: auto; margin-right: 6%;" alt="">
        <h2 class="deftxt">1. Зареєструвати акаунт</h2>
        <h2 class="deftxt" style="margin-left: 40px;">в системі Transit Kyiv.</h2>
        <form class="d-flex" action="/registration">
            <button class="gradbtn btn btn-success mt-4" style="margin-left: 9%;" type="submit">Зареєструватись</button>
        </form>
        <h2 class="lowtxt mt-3" style="margin-left: 4%;">якщо вже маєте акаунт,
            <a class="noline" href="/login">Увійти</a></h2>
    </div>
    <div class="text-end" style="margin-top: 100px;">
        <img src="/img/svg/Bus.svg" class="float-start" style="width: 22%; height: auto; margin-left: 6%;" alt="">
        <h2 class="deftxt">2. Натиснути на кнопку</h2>
        <h2 class="deftxt" style="margin-right: 15px;"><a class="disabled dtxt noline" style="font-weight: 500;" href="#">пошук маршруту</a> на</h2>
        <h2 class="deftxt" style="margin-right: 110px;">верхній панелі.</h2>
    </div>
</div>

<div class="text-center mb-3" style="margin-top: 4%;">
    <img src="/img/svg/Line.svg" alt="" style="width: 90%;">
</div>

<div class="container text-center">
    <h2 class="deftxt">Про нас</h2>
    <div class="text-center mt-5">
        <h2 class="lowtxt">Transit Kyiv замислювався як проект для коледжу і на даний час таким і залишається.</h2>
        <h2 class="lowtxt">За допомогою цього сайту можна знаходити автобуси, трамваї та тролейбуси від однієї</h2>
        <h2 class="lowtxt">зупинки до іншої, а також дізнатись детальнішу інформацію про рух транспорту.</h2>

        <div class="text-center mb-3 mt-3">
            <img src="/img/svg/Line.svg" alt="" style="width: 80%;">
        </div>

        <h2 class="lowtxt">Нам дуже важливо знайти вашу думку, щодо цього проекту, тому</h2>
        <h2 class="lowtxt">відсилайте свої відгуки за допомогою кнопки <a class="noline" href="/send-response">надіслати відгук</a> на</h2>
        <h2 class="lowtxt">верхній панелі.</h2>
    </div>
</div>

<#include "parts/author.ftl">

</body>
</html>