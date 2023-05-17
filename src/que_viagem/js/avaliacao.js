// $("#login-user").on("submit", function (event) {
//     var email = $("#email").val();
//     var password = $("#password").val();
//     $(".error-div").html('');

//     event.preventDefault();
//     var url = 'http://localhost:8080/users/login';
//     $.ajax({
//         type: "POST",
//         url: url,
//         contentType: "application/json; charset=utf-8",
//         dataType: "json",
//         data: JSON.stringify({
//             email: email,
//             password: password,
//         }),
//         success: function (data) {
//             console.log(data);
//             sessionStorage.setItem("userId", data.id_user)
//             sessionStorage.setItem("userEmail", data.email_user)
//             sessionStorage.setItem("userType", data.type_user)
//             window.location.href = 'dashboard.html';
//         },
//         error: function (err) {
//             var error = err.responseJSON.message;
//             $(".error-div").html(error);
//         }
//     });
// });
var ratingValue = 1;

// $("#form-rating").submit(function (event) {
//     return false;
//     var rating = ratingValue
//     var comment = $(".txt-comment").val();
//     console.log(rating, comment);

//     event.preventDefault();
//     $(".error-div").html('');
//     var url = 'http://localhost:8080/users/save-rating';
//     $.ajax({
//         type: "POST",
//         url: url,
//         contentType: "application/json; charset=utf-8",
//         dataType: "json",
//         data: JSON.stringify({
//             rating: rating,
//             comment: comment,
//         }),
//         success: function (data) {
//             console.log(data);
//         },
//         error: function (err) {
//             var error = err.responseJSON.message;
//             // $(".error-div").html(error);
//         }
//     });
// });


$(document).ready(function () {
    let searchParams = new URLSearchParams(window.location.search)
    let packageId = searchParams.get('id')


    var url = 'http://localhost:8080/packages/' + packageId;

    const requestSerch = $.ajax({
        type: "GET",
        url: url,
        dataType: "json"
    });
    requestSerch.done(response => {
        var details = '';
        details = `
        <h1 class="h2-details">${response.title_package}</h1>
        <hr>
        <p class="p-text">Destino: ${response.destiny_package}. Preço: R$ ${response.price_package}. Data de início da viagem: ${response.init_date_travel_package}. Data de fim da viagem: ${response.final_date_travel_package}</p>
        <p class="p-text">Descrição: ${response.description_package}</p>`;

        $(".details-text").html(details);
        // $(response).each(i => {

        // });
    });

    $(".my-rating").starRating({
        initialRating: 1,
        useFullStars: true,
        strokeColor: '#894A00',
        strokeWidth: 4,
        starSize: 4,
        onHover: function (currentIndex, currentRating, $el) {
            // do something on mouseover
            console.log(currentIndex);
        }
    });

    $('.star-rating input[type="radio"]').change(function () {
        var rating = $(this).val();
        ratingValue = rating;
        console.log('Valor selecionado: ' + rating);
    });

    $('#form-rating').on('submit', function (e) {
        // validation code here
        e.preventDefault();
        var rating = ratingValue
        var comment = $(".txt-comment").val();
        console.log(rating, comment);

        $(".error-div").html('');
        var url = 'http://localhost:8080/ratings';
        var sendingData = {
            note_rating: rating,
            comment_rating: comment,
            fk_id_package_rating: packageId,
            fk_id_user_rating: sessionStorage.getItem("userId")
        }
        $.ajax({
            type: "POST",
            url: url,
            crossDomain: true,
            // headers: {
            //     'Access-Control-Allow-Origin':'*'
            // },
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            data: JSON.stringify(sendingData),
            success: function (data) {
                console.log(data);
                alert("avaliação salva com sucesso!");
                window.location.href = 'avaliacoes.html?idPackage=' + packageId;
            },
            error: function (err) {
                var error = err.responseJSON.message;
                alert("erro ao salvar avaliação.");
            }
        });

    });

});


