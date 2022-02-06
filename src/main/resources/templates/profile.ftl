<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Профіль</title>
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
  <img src="/img/png/user.png" alt="" style="width: 200px; height: auto;">
  <h2 class="bigtxt">${userinfo.userName}</h2>
  <div class="text-start bg-light mt-5 p-4">
    <h1 class="gradtxt text-center mb-4" style="font-size: 48px;">Інформація:</h1>
    <h2 class="deftxt mb-3">Ім'я: ${userinfo.firstName}</h2>
    <h2 class="deftxt mb-3">Прізвище: ${userinfo.lastName}</h2>
    <div class="text-center mt-3 p-4">
      <h2 class="deftxt text-center mb-4" style="font-size: 48px;">Дії:</h2>
      <form action="/profile" method="post">
        <button type="submit" class="gradbtn btn btn-success mt-4">Вихід</button>
      </form>
    </div>
  </div>
</div>

<#include "parts/author.ftl">

</body>
</html>