<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Дякуємо за реєстрацію!</title>
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
    <h2 class="deftxt">Admin page</h2>
</div>

<!--statistics card-->
<div class="container">
    <div class="row">
        <div class="col-md-4">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Кількість користувачів</h5>
                    <p class="card-text"><strong>${users?size}</strong></p>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Кількість водіїв</h5>
                    <p class="card-text"><strong>${drivers?size}</strong></p>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Кількість зупинок у системі</h5>
                    <p class="card-text"><strong>${stops?size}</strong></p>
                </div>
            </div>
        </div>
    </div>
</div>

<!--card add users-->
<div class="container mt-2">
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <div class="card-header">
                    <h4 class="deftxt">Додати користувача</h4>
                </div>
                <div class="card-body">
                    <form action="/admin/add-user" method="post">
                        <div class="form-group">
                            <label for="firstName">Ім'я</label>
                            <input type="text" class="form-control" id="firstName" name="firstName" placeholder="Ім'я">
                        </div>
                        <div class="form-group">
                            <label for="lastName">Прізвище</label>
                            <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Прізвище">
                        </div>
                        <div class="form-group">
                            <label for="userName">Логін</label>
                            <input type="text" class="form-control" id="userName" name="userName" placeholder="Логін">
                        </div>
                        <div class="form-group">
                            <label for="userPassword">Пароль</label>
                            <input type="password" class="form-control" id="userPassword" name="userPassword" placeholder="Пароль">
                        </div>
                        <!--select user role-->
                        <div class="form-group">
                            <label for="userRole">Роль</label>
                            <select class="form-control" id="userRole" name="userRole">
                                <option value="admin">Адміністратор</option>
                                <option value="user">Користувач</option>
                            </select>
                        </div>
                        <button type="submit" class="btn btn-primary mt-2">Додати</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<!--add driver card by firstName, lastName and age-->
<div class="container mt-2">
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <div class="card-header">
                    <h4 class="deftxt">Додати водія</h4>
                </div>
                <div class="card-body">
                    <form action="/admin/add-driver" method="post">
                        <div class="form-group">
                            <label for="firstName">Ім'я</label>
                            <input type="text" class="form-control" id="firstName" name="firstName" placeholder="Ім'я">
                        </div>
                        <div class="form-group">
                            <label for="lastName">Прізвище</label>
                            <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Прізвище">
                        </div>
                        <div class="form-group">
                            <label for="age">Вік</label>
                            <input type="number" class="form-control" id="age" name="age" placeholder="Вік">
                        </div>
                        <button type="submit" class="btn btn-primary mt-2">Додати</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<!--add stop card by stopAddress-->
<div class="container mt-2">
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <div class="card-header">
                    <h4 class="deftxt">Додати зупинку</h4>
                </div>
                <div class="card-body">
                    <form action="/admin/add-stop" method="post">
                        <div class="form-group">
                            <label for="stopAddress">Адреса</label>
                            <input type="text" class="form-control" id="stopAddress" name="stopAddress" placeholder="Адреса">
                        </div>
                        <button type="submit" class="btn btn-primary mt-2">Додати</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>


</body>
</html>