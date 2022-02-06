<nav class="navbar navbar-expand-lg fixed-top navbar-light bg-light">
    <div class="container m-0">
        <a class="navbar-brand nav-link active" aria-current="page" href="/">
            <img src="/img/svg/LogoMini.svg" alt="" width="140" height="50">
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item ms-4"><a class="nav-link" href="/find-route" style="font-size: 22px;">Пошук транспорту</a></li>
                <li class="nav-item ms-4"><a class="nav-link" href="/routeslist" style="font-size: 22px;">Список маршрутів</a></li>
                <li class="nav-item ms-4"><a class="nav-link" href="/profile" style="font-size: 22px;">Профіль<#if Session.user??>(${Session.user.userName})</#if></a></li>
                <li class="nav-item ms-4"><a class="nav-link" href="/send-response" style="font-size: 22px;">Надіслати відгук</a></li>
            </ul>
        </div>
    </div>
</nav>