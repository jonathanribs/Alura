
var botaoAdicionar = document.querySelector("#buscar-pacientes");
botaoAdicionar.addEventListener("click", function(){
    console.log("Buscando Endereços...");
    var xhr = new XMLHttpRequest();
    //Pre configurar requisição (Tudo será executado após a requisição ser enviada):
    xhr.open("GET", "https://api-pacientes.herokuapp.com/pacientes"); //a requisição vai ser do tipo "get" e será feita para o endereço em questão
    xhr.addEventListener("load", function(){ //quando a requisição for carregada, ou seja, após já ter "feito o get" dos arquivos 

        if (xhr.status == 200){
            var resposta = xhr.responseText
            console.log(resposta);
            console.log(typeof resposta);
            var pacientes = JSON.parse(resposta);
            console.log(pacientes);
            console.log(typeof pacientes);

            pacientes.forEach(function(paciente){
                adicionaPacienteNaTabela(paciente); 
            });
        } else {
            console.log(xhr.status);
            console.log(xhr.responseText);
        }

    });
    //Enviar requisição:
    xhr.send();

});