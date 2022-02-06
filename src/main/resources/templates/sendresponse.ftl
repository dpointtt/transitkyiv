<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Відгук</title>
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

<div class="container text-center" style="margin-top: 120px; margin-bottom: 100px;">
    <h1 class="gradtxt">Надіслати відгук</h1>
    <h2 class="deftxt">Напишіть свій відгук.</h2>
    <form action="/send-response" method="post">
        <div class="input-group-lg text-center">
            <textarea name="responseText" class="form-control" aria-label="With textarea"></textarea>
        </div>
        <button type="submit" class="gradbtn btn btn-success mt-4">Надіслати</button>
    </form>
</div>

<#include "parts/author.ftl">

</body>
</html>