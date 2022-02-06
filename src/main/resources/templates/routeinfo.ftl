<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Маршрут ${routeV.routeNumber}</title>
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
    <img src="/img/svg/${routeV.transports_.t_image}" alt="" style="width: 200px; height: auto;">
    <h2 class="bigtxt">${routeV.transports_.transport} ${routeV.routeNumber}</h2>
    <div class="text-start bg-light mt-5 p-4">
        <h1 class="gradtxt text-center mb-4" style="font-size: 48px;">Інформація:</h1>
        <#if routeV.driver??><h2 class="deftxt mb-3">Водій: ${routeV.driver.firstName} ${routeV.driver.lastName}</h2></#if>
        <h2 class="deftxt mb-3">Маршрут: ${routeV.routeStart} &mdash; ${routeV.routeEnd}</h2>
        <h2 class="deftxt mb-3">Дні роботи: ${routeV.schedule_}</h2>
        <h2 class="deftxt mb-3">Час роботи: ${routeV.timeStart}&mdash;${routeV.timeEnd}</h2>
        <h2 class="deftxt mb-3">Інтервал: ${routeV.interval_} хв.</h2>
        <div class="text-center mt-3 p-4">
            <h1 class="gradtxt text-center mb-4" style="font-size: 48px;">Повний маршрут:</h1>
            <h2 class="deftxt mb-3" style="font-size: 30px">
                <#list routeV.routeStopsList as routestopsl>
                    ${routestopsl.stop_.stopAddress} &mdash; <wbr>
                </#list>
                (зворот. напр.).
            </h2>
        </div>
    </div>
</div>

<#include "parts/author.ftl">

</body>
</html>