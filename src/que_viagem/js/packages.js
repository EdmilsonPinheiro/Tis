$("#search-finished-package").on("submit", function (event) {
    var initialDate = $("#initialDate").val();
    var finalDate = $("#finalDate").val();

    event.preventDefault();
    var url = 'http://localhost:8080/packages/get-finished?initialDate=' + initialDate + '&finalDate=' + finalDate;

    const requestSerch = $.ajax({
        type: "GET",
        url: url,
        dataType: "json"
    });
    requestSerch.done(response => {
        line = '';
        var lineDetails = [];

        $(response).each(i => {
            info = response[i];
            line += `<tr scope="row" class="clickable-row" data-id-package=${info.id_package}>
                    <td>${info.id_package}</td>
                    <td>${info.title_package}</td>
                    <td>${info.destiny_package}</td>
                    <td> <a href="avaliacao-pacote.html?id=${info.id_package}">Avaliar pacote</a></td>
                </tr>`;

            lineDetails[info.id_package] = `<p>Título: ${info.title_package}</p>
                <p>Tamanho do pacote: ${info.size_group_package}</p>
                <p>Preço do pacote: R$ ${info.price_package}</p>
                <p>Data de início da viagem: ${info.init_date_travel_package}</p>
                <p>Data de fim da viagem: ${info.final_date_travel_package}</p>
                <p>Destino da viagem: ${info.destiny_package}</p>
                <p>Descrição do pacote: ${info.description_package}</p>`;
        });
        $("#t-body").html(line);


        $(".clickable-row").click(function () {
            var dataId = $(this).attr("data-id-package");
            $('#openModal').modal('show');
            $("#detail-package").html(lineDetails[dataId]);
        });

    });
});

$("#initialDate").attr('placeholder', "dd/mm/yyyy");
$("#finalDate").attr('placeholder', "dd/mm/yyyy");

$(document).ready(function ($) {
    $('#initialDate').on("keyup", function () {
        var v = this.value;
        if (v.match(/^\d{2}$/) !== null) {
            this.value = v + '/';
        } else if (v.match(/^\d{2}\/\d{2}$/) !== null) {
            this.value = v + '/';
        }
    });


    $('#finalDate').on("keyup", function () {
        var v = this.value;
        if (v.match(/^\d{2}$/) !== null) {
            this.value = v + '/';
        } else if (v.match(/^\d{2}\/\d{2}$/) !== null) {
            this.value = v + '/';
        }
    });
});

