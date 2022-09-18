<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Пошук транспорту</title>
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

<!--FindPanel-->

<div class="container text-center justify-content-center" style="margin-top: 120px; margin-bottom: 30px;">
    <h2 class="deftxt mb-4">Пошук маршруту</h2>
    <form action="/find-route" method="post" class="mb-5 mt-4">
        <div class="input-group text-center justify-content-center" style="display: inline !important; white-space: nowrap">
            <div class="autocomplete w-50">
                <label class="form-label deftxt" for="fromInput">Від:</label>
                <input id="fromInput" type="text" name="fromAddress" class="form-control form-control-lg bg-light" placeholder="наприкл.: вулиця Льва Толстого" aria-label="FromAddress" autocomplete="on">
            </div>
            <div class="autocomplete w-50">
                <label class="form-label deftxt" for="toInput">До:</label>
                <input id="toInput" type="text" name="toAddress" class="form-control form-control-lg bg-light" placeholder="наприкл.: вулиця Сім'ї Сосніних" aria-label="ToAddress" autocomplete="on">
            </div>
            <div>
                <span class="input-group-text bg-white btn-outline-light justify-content-center text-center border-0 mt-2 mb-2">
                    <img src="/img/svg/LineImg.svg" alt="" style="max-width: 200px; height: auto;">
                </span>
            </div>
            <div class="input-group mb-3 mt-4 w-50 justify-content-center align-items-center text-center me-0" style="margin-left: 25%">
                <label class="input-group-text deftxt" for="inputGroupSelect01">Транспорт</label>
                <select name="transport" class="form-select form-select-lg" id="inputGroupSelect01">
                    <option value="" selected>Будь-який</option>
                    <option value="Маршрутка">Маршрутка</option>
                    <option value="Трамвай">Трамвай</option>
                    <option value="Тролейбус">Тролейбус</option>
                </select>
            </div>
        </div><br>
        <button type="submit" class="gradbtn btn btn-success mt-4">Пошук</button>
    </form>
</div>

<!--RoutesInfoBlocks-->
<div class="container bg-white">
    <#list froutes as froute_>
        <div class="bg-light">
            <div class="row btn-outline-success mb-4">
                <a class="noline routelink" href="/route?rid=${froute_.id}">
                    <div class="col text-center m-2">
                        <img class="float-start mb-2" src="/img/svg/${froute_.transports_.t_image}" style="width: 80px;" alt="">
                        <h2 class="deftxt float-start m-2">&nbsp;${froute_.routeNumber}&nbsp;&nbsp;${froute_.transports_.transport}</h2><br><br><br>
                        <h2 class="lowtxt float-start">${froute_.routeStart} &mdash; ${froute_.routeEnd}</h2>
                    </div>
                </a>
            </div>
        </div>
    </#list>
</div>

<#include "parts/author.ftl">

<script src="/js/Autocomplete.js"></script>
<script>
    var stopsArr = [<#list stopsList as stopItem>'${stopItem.stopAddress?string}',</#list>]
    autocomplete(document.getElementById("fromInput"), stopsArr);
    autocomplete(document.getElementById("toInput"), stopsArr);
</script>

</body>
</html>