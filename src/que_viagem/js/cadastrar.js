function optionCadastro(opcaoCadastro) {
    let show = document.getElementById("show");
    show.innerHTML = ""; // Limpa o conteúdo anterior

    if (opcaoCadastro == "viajante") {
        var inputNome = document.createElement("input");
        inputNome.setAttribute("id", "Nome")
        var inputDataNascimento = document.createElement("input");
        inputDataNascimento.setAttribute("id", "DataNascimento")
        var inputCPF = document.createElement("input");
        inputCPF.setAttribute("id", "CPFCNPJ")
        var inputEmail = document.createElement("input");
        inputEmail.setAttribute("id", "Email")
        var inputSenha = document.createElement("input");
        inputSenha.setAttribute("id", "Senha")

        let labelNome = document.createElement("label");
        labelNome.textContent = "Nome";

        let labelDataNascimento = document.createElement("label");
        labelDataNascimento.textContent = "Data de Nascimento";

        let labelCPF = document.createElement("label");
        labelCPF.textContent = "CPF";

        let labelEmail = document.createElement("label");
        labelEmail.textContent = "Email";

        let labelSenha = document.createElement("label");
        labelSenha.textContent = "Senha";

        show.appendChild(labelNome);
        show.appendChild(inputNome);
        show.appendChild(labelDataNascimento);
        show.appendChild(inputDataNascimento);
        show.appendChild(labelCPF);
        show.appendChild(inputCPF);
        show.appendChild(labelEmail);
        show.appendChild(inputEmail);
        show.appendChild(labelSenha);
        show.appendChild(inputSenha);

        document.getElementsByClassName("row-login")[0].style.height="800px"

    } else if (opcaoCadastro == "anunciante") {
        var inputNome = document.createElement("input");
        inputNome.setAttribute("id", "Nome")
        var inputDataNascimento = document.createElement("input");
        inputDataNascimento.setAttribute("id", "DataNascimento")
        var inputCPF = document.createElement("input");
        inputCPF.setAttribute("id", "CPFCNPJ")
        var inputEmail = document.createElement("input");
        inputEmail.setAttribute("id", "Email")
        var inputSenha = document.createElement("input");
        inputSenha.setAttribute("id", "Senha")

        let labelNome = document.createElement("label");
        labelNome.textContent = "Nome";

        let labelDataNascimento = document.createElement("label");
        labelDataNascimento.textContent = "Data de Nascimento";

        let labelCPF = document.createElement("label");
        labelCPF.textContent = "CNPJ/CPF";

        let labelEmail = document.createElement("label");
        labelEmail.textContent = "Email";

        let labelSenha = document.createElement("label");
        labelSenha.textContent = "Senha";

        show.appendChild(labelNome);
        show.appendChild(inputNome);
        show.appendChild(labelDataNascimento);
        show.appendChild(inputDataNascimento);
        show.appendChild(labelCPF);
        show.appendChild(inputCPF);
        show.appendChild(labelEmail);
        show.appendChild(inputEmail);
        show.appendChild(labelSenha);
        show.appendChild(inputSenha);
    } else {
        show.removeChild
        console.log("Opção inválida");
    }
}

$("#cadastrar-user").on("submit", function (event) {
    var Email = $("#Email").val();
    var Senha = $("#Senha").val();
    var Nome = $("#Nome").val();
    var DataNascimento = $("#DataNascimento").val();
    var CPF = $("#CPFCNPJ").val();
    $(".error-div").html('');

    event.preventDefault();
    var url = 'http://localhost:8080/users/cadastrar';
    $.ajax({
        type: "POST",
        url: url,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: JSON.stringify({

            email: Email,
            senha: Senha,
            nome: Nome,
            dataNascimento: DataNascimento,
            cnpj: CPF
            
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