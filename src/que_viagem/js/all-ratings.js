$(document).ready(function () {
    let searchParams = new URLSearchParams(window.location.search)
    let packageId = searchParams.get('idPackage')


    var url = 'http://localhost:8080/ratings/get-ratings?fk_id_package_rating=' + packageId;
    var details = '';

    const requestSerch = $.ajax({
        type: "GET",
        url: url,
        dataType: "json"
    });
    requestSerch.done(response => {
        $(response).each(i => {
            info = response[i];
            details += `
            <div class="div-all">
            <p> Nota: ${info.note_rating}</p>
            <p> Comentario: ${info.comment_rating}</p>
            <p> Data avaliação: ${info.date_rating}</p> </div>
            `;
        });
    $(".all-ratings").html(details);

    });


});