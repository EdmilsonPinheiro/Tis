$("#login-user").on("submit", function (event) {
    var email = $("#email").val();
    var password = $("#password").val();
    $(".error-div").html('');

    event.preventDefault();
    var url = 'http://localhost:8080/users/login';
    $.ajax({
        type: "POST",
        url: url,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: JSON.stringify({
            email: email,
            password: password,
        }),
        success: function (data) {
            console.log(data);
            sessionStorage.setItem("userId", data.id_user)
            sessionStorage.setItem("userEmail", data.email_user)
            sessionStorage.setItem("userType", data.type_user)
            window.location.href = 'dashboard.html';
        },
        error: function (err) {
            var error = err.responseJSON.message;
            $(".error-div").html(error);
        }
    });
});

sessionStorage.clear();

console.log(sessionStorage.getItem("userId"))