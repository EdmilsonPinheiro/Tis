var userSessionId = sessionStorage.getItem("userId");
var userSessionEmail = sessionStorage.getItem("userEmail");
var timer = false;
if (userSessionEmail == null || userSessionId == null) {
    window.location.href = "login.html";
}

setTimeout(function () {
    timer = true;
    redirect();
}, 200000);

function redirect() {
    if (timer == true) {
        alert("Sessão expirada, faça login novamente.");
        window.location.href = 'login.html';
        sessionStorage.clear();
    }
}