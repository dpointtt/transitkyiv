<div class="container bg-white">
    <#list routes as route_>
    <div class="bg-light">
        <div class="row btn-outline-success mb-4">
            <a class="noline routelink" href="/route?rid=${route_.id}">
                <div class="col text-center m-2">
                    <img class="float-start mb-2" src="/img/svg/${route_.transports_.t_image}" style="width: 80px;" alt="">
                    <h2 class="deftxt float-start m-2">&nbsp;${route_.routeNumber}&nbsp;&nbsp;${route_.transports_.transport}</h2><br><br><br>
                    <h2 class="lowtxt float-start">${route_.routeStart} &mdash; ${route_.routeEnd}</h2>
                </div>
            </a>
        </div>
    </div>
    </#list>
</div>